package com.akshay.manytomany.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akshay.manytomany.models.Category;
import com.akshay.manytomany.models.CategoryProduct;
import com.akshay.manytomany.models.Product;
import com.akshay.manytomany.repositories.CategoryProductRepository;
import com.akshay.manytomany.repositories.CategoryRepository;
import com.akshay.manytomany.repositories.ProductRepository;

@Service
public class ManyToManyService {
	
	@Autowired 
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private CategoryProductRepository catProdRepo;
	

//	-----------------------------   PRODUCT METHODS   ----------------------------
	
	
//	Get All Products
	public List <Product> getAllProducts () {
		return productRepository.findAll();
	}
	
	
// 	Add New Product
	public Product newProduct(Product product) {
		return productRepository.save(product);
	}
	
	
//	Get a Single Product
	public Product getProduct(Long id) {
		Product product = new Product();
		Optional <Product> optionalProduct = productRepository.findById(id);
		if (optionalProduct.isPresent()) {
			product = optionalProduct.get();
			return product;
		}
		else {
			System.out.println("No such Product Found...");
			return null;
		}
	}
	

//	Adding Category to the Product
	public void addCategoryToProduct(CategoryProduct cp) {
		catProdRepo.save(cp);
	}
	
	
//	Function to put the categories not belonging to the product in the select box... 
	public List <Category> getNonCategories (Product product) {
		List<Category> currentProductCategories = product.getCategories();
		List<String> currentCategoryNames = new ArrayList<String>();
		
		if (currentProductCategories.size() == 0) {
			currentCategoryNames.add("");
		}
		else {
			for (Category category : currentProductCategories) {
				currentCategoryNames.add(category.getName());
			}
		}
		return categoryRepository.findByNameNotIn(currentCategoryNames);
	}
	
	
//	-----------------------------   CATEGORY METHODS   ----------------------------
	
	
//	Get All Categories
	public List <Category> getAllCategories () {
		return categoryRepository.findAll();
	}
	
	
// 	Add New Category
	public Category newCategory(Category category) {
		return categoryRepository.save(category);
	}

	
//	Get a Single Category
	public Category getCategory(Long id) {
		Category category = new Category();
		Optional <Category> optionalCategory = categoryRepository.findById(id);
		if (optionalCategory.isPresent()) {
			category = optionalCategory.get();
			return category;
		}
		else {
			System.out.println("No such Category Found...");
			return null;
		}
	}

	
	
//	Adding Product to the Category
	public void addProductToCategory(CategoryProduct cp) {
		catProdRepo.save(cp);
	}

	
//	Function to put the products not belonging to the category in the select box... 
	public List <Product> getProductsNotInCategory (Category category) {
		List<Product> currentCategoryProducts = category.getProducts();
		List<String> currentProductNames = new ArrayList<String>();
		
		if (currentCategoryProducts.size() == 0) {
			currentProductNames.add("");
			System.out.println("if condition executed");
		}
		else {
			for (Product product : currentCategoryProducts) {
				currentProductNames.add(product.getName());
				System.out.println("got the product names in else's for loop...");
			}
		}
		System.out.println(productRepository.findByNameNotIn(currentProductNames));
		return productRepository.findByNameNotIn(currentProductNames);
	}

}
