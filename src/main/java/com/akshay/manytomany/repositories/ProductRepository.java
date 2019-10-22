package com.akshay.manytomany.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.akshay.manytomany.models.Product;

@Repository
public interface ProductRepository extends CrudRepository <Product, Long> {
	
	List <Product> findAll();
	List<Product> findByNameNotIn(List<String> names);
}
