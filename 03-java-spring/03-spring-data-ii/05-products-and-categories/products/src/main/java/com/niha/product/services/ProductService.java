package com.niha.product.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niha.product.models.Category;
import com.niha.product.models.Product;
import com.niha.product.repositories.ProductRepo;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepo pRepo;
	
	public List<Product> getAllProducts(){
	    return this.pRepo.findAll();
	}
	
	public List<Product> findProdNotCat(Category category){
		return this.pRepo.findByCategoriesNotContains(category);
	}
	
	public void addCategoryToProduct(Product product, Category category) {
		List<Category> existingCats = product.getCategories();
		existingCats.add(category);
		this.pRepo.save(product);
		}
	

	
	public Product getOneProduct(Long id){
	     return this.pRepo.findById(id).orElse(null);
	}

	public Product createProduct(Product product){
	       return this.pRepo.save(product);
	}
	
	public Product editProduct(Product product) {
	        return this.pRepo.save(product);
	}
	
	public String deleteProduct(Long id) {
			this.pRepo.deleteById(id);
			return "Product has been deleted";
	}	

}
