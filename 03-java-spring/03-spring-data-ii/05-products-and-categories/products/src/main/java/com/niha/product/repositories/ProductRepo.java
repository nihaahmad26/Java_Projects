package com.niha.product.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.niha.product.models.Category;
import com.niha.product.models.Product;

@Repository
public interface ProductRepo extends CrudRepository <Product, Long>{
	List<Product> findAll();
	List<Product> findByCategoriesNotContains(Category category);
}
