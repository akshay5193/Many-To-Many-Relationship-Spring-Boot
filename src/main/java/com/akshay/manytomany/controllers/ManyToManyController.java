package com.akshay.manytomany.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.akshay.manytomany.models.Category;
import com.akshay.manytomany.models.CategoryProduct;
import com.akshay.manytomany.models.Product;
import com.akshay.manytomany.services.ManyToManyService;

@Controller
public class ManyToManyController {
	
	@Autowired
	private ManyToManyService manyToManyService;
	
	
//	Load Index Page
	@GetMapping("/")
	public String index() {
		return "/index.jsp";
	}
	
	
//	-------------------------------   PRODUCT METHODs   -------------------------------
	
	
//	Load All Products Page
	@GetMapping ("/products")
	public String allProducts (Model model) {
		List <Product> products = manyToManyService.getAllProducts();
		model.addAttribute("products", products);
		return "/allProducts.jsp";
	}
	
	
//	Method to load create new product page
	@GetMapping ("/products/new")
	public String addNewProductPage (@ModelAttribute ("product") Product product) {
		return "/newProduct.jsp";
	}
	
	
//	Method to create a new product
	@PostMapping ("/products")
	public String addNewProduct(@Valid @ModelAttribute ("product") Product product, BindingResult result) {
		if (result.hasErrors()) {
			return "/newProduct.jsp";
		}
		else {
			manyToManyService.newProduct(product);
			return "redirect:/products";
		}
	}
	
	
//	Load Product Details Page
	@GetMapping ("/products/{id}")
	public String viewProductDetailsPage(@PathVariable ("id") Long id, Model model, @ModelAttribute ("middleTableObject") CategoryProduct cp) {
		Product product = manyToManyService.getProduct(id);
		model.addAttribute("nonCategories", manyToManyService.getNonCategories(product));
		model.addAttribute("product", product);
		return "/productDetails.jsp";
	}
	
	
//	Add Category to the Product
	@PostMapping ("/addCategory")
	public String addCategoryToProduct(@ModelAttribute ("middleTableObject") CategoryProduct cp) {
		manyToManyService.addCategoryToProduct(cp);
		return "redirect:/products/" + cp.getProduct().getId();
	}
	
	
//	-------------------------------   CATEGORY METHODs   -------------------------------
	
	
//	Load All Categories Page
	@GetMapping ("/categories")
	public String allCategories (Model model) {
		List <Category> categories = manyToManyService.getAllCategories();
		model.addAttribute("categories", categories);
		return "/allCategories.jsp";
	}
	
//Method to load create new category page
	@GetMapping ("/categories/new")
	public String addNewCategoryPage (@ModelAttribute ("category") Category category) {
		return "/newCategory.jsp";
	}
	
	
//	Method to create a new category
	@PostMapping ("/categories")
	public String addNewCategory(@Valid @ModelAttribute ("category") Category category, BindingResult result) {
		if (result.hasErrors()) {
			return "newCategory.jsp";
		}
		else {
			manyToManyService.newCategory(category);
			return "redirect:/categories";
		}
	}
	
	
//	Load Category Details Page
	@GetMapping ("/categories/{id}")
	public String viewCategoryDetailsPage(@ModelAttribute("middleTableObj") CategoryProduct cp, @PathVariable ("id") Long id, Model model) {
		Category category = manyToManyService.getCategory(id);
		model.addAttribute("nonProducts", manyToManyService.getProductsNotInCategory(category));
		System.out.print("non-product are here" + manyToManyService.getProductsNotInCategory(category));
		model.addAttribute("category", category);
		return "/categoryDetails.jsp";
	}
	
	
	
//	Add Product to the Category
	@PostMapping ("/addProduct")
	public String addProductToCategory(@ModelAttribute("middleTableObj") CategoryProduct cp) {
		manyToManyService.addProductToCategory(cp);
		return "redirect:/categories/" + cp.getCategory().getId();
	}

	
	
}
