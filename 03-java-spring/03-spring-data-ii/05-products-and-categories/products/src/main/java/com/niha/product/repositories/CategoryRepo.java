package com.niha.product.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.niha.product.models.Category;
import com.niha.product.models.Product;


@Repository
public interface CategoryRepo extends CrudRepository<Category, Long>{
	List<Category> findAll();
    List<Category> findAllByProducts(Product product);
   
    List<Category> findByProductsNotContains(Product product);

}
