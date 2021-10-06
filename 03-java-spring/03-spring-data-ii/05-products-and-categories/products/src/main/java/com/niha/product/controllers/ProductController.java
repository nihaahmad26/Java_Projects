package com.niha.product.controllers;

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
import org.springframework.web.bind.annotation.RequestParam;

import com.niha.product.models.Category;
import com.niha.product.models.Product;
import com.niha.product.services.CategoryService;
import com.niha.product.services.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService pService;
	
	@Autowired
	private CategoryService cService;

	@GetMapping("/products/new")
	public String index(@ModelAttribute("product") Product product, Model viewModel) {
		viewModel.addAttribute("allProducts", this.pService.getAllProducts());
		return "createProduct.jsp";
	}
	
	@PostMapping("/createProduct")
	public String addNew(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if(result.hasErrors()) {
			return "createProduct.jsp";
		}
		this.pService.createProduct(product);
		return "redirect:/products";
}
	
	@GetMapping("/products")
	public String Products(@ModelAttribute("product") Product product, Model viewModel) {
		List<Product> allProducts = this.pService.getAllProducts();
		viewModel.addAttribute("allProducts", allProducts);
		return "products.jsp";
	}
	
	@GetMapping("/products/{id}")
	public String view(@PathVariable("id") Long id, Model viewModel) {
        Product product = pService.getOneProduct(id);
        viewModel.addAttribute("notInProd", this.cService.findCatNotProd(product));
		viewModel.addAttribute("product", product);
        return "viewProduct.jsp";
	}
	
	@PostMapping("/products/addCategories/{id}")
	public String addCategory(@RequestParam("cats") Long id, @PathVariable("id") Long productId) {
		Product productToAddCatTo = this.pService.getOneProduct(productId);
		Category categoryToAdd = this.cService.getOneCategory(id);
		this.pService.addCategoryToProduct(productToAddCatTo, categoryToAdd);
		return "redirect:/products/{id}";
	}
}
	

