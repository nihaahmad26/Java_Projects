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
public class CategoryController {
	@Autowired
	private ProductService pService;
	
	@Autowired
	private CategoryService cService;
	
	@GetMapping("/categories/new")
	public String index(@ModelAttribute("category") Category category, Model viewModel) {
		viewModel.addAttribute("allCategories", this.cService.getAllCategories());
		return "createCategory.jsp";
	}
	
	@PostMapping("/createCategory")
	public String addNew(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if(result.hasErrors()) {
			return "createCategory.jsp";
		}
		this.cService.createCategory(category);
		return "redirect:/categories";
}
	@GetMapping("/categories")
	public String Categories(@ModelAttribute("category") Category category, Model viewModel) {
		List<Category> allCategories = this.cService.getAllCategories();
		viewModel.addAttribute("allCategories", allCategories);
		return "categories.jsp";
	}
	
	@GetMapping("/categories/{id}")
	public String view(@PathVariable("id") Long id, Model viewModel) {
        Category category = cService.getOneCategory(id);
        viewModel.addAttribute("notInCat", this.pService.findProdNotCat(category));
		viewModel.addAttribute("category", category);
        return "viewCategory.jsp";
	}
	
	@PostMapping("/categories/addProducts/{id}")
	public String addProducts(@RequestParam("prods") Long id, @PathVariable("id") Long productId) {
		Category catToAddProdTo = this.cService.getOneCategory(productId);
		Product productToAdd = this.pService.getOneProduct(id);
		this.cService.addProductToCategory(productToAdd, catToAddProdTo);
		return "redirect:/categories/{id}";
	}
}
