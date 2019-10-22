package com.akshay.manytomany.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.akshay.manytomany.models.Category;

@Repository
public interface CategoryRepository extends CrudRepository <Category, Long> {

	List<Category> findAll();
	List<Category> findByNameNotIn(List<String> names);
}
