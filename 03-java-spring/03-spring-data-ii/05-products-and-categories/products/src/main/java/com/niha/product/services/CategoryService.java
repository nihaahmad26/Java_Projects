package com.niha.product.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niha.product.models.Category;
import com.niha.product.models.Product;
import com.niha.product.repositories.CategoryRepo;



@Service

public class CategoryService {
	
	@Autowired
	private CategoryRepo cRepo;
	
	public List<Category> getAllCategories(){
	    return this.cRepo.findAll();
	}
	
	
	public List<Category> findCatNotProd(Product product){
		return this.cRepo.findByProductsNotContains(product);
	}
	
	public void addProductToCategory(Product product, Category category) {
		List<Product> existingProds = category.getProducts();
		existingProds.add(product);
		this.cRepo.save(category);
	}
	
	public Category getOneCategory(Long id) {
		 return this.cRepo.findById(id).orElse(null);
	}
	
	public Category createCategory(Category category){
	       return this.cRepo.save(category);
	}
	
	public Category editCategory(Category category) {
       return this.cRepo.save(category);
}

public String deleteCategory(Long id) {
		this.cRepo.deleteById(id);
		return "Category has been deleted";
}



}
