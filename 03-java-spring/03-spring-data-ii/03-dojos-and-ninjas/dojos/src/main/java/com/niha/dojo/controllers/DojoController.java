package com.niha.dojo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.niha.dojo.models.Dojo;
import com.niha.dojo.services.DojoService;

@Controller
public class DojoController {
	
	@Autowired
	private DojoService dService;
	
	@GetMapping("/dojos/new")
	public String index(@ModelAttribute("dojo") Dojo dojo, Model viewModel) {
		viewModel.addAttribute("allDojos", this.dService.getAllDojos());
		return "createdojo.jsp";
	}
	
	@PostMapping("/dojo/createDojo")
	public String addNew(@ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		this.dService.createDojo(dojo);
		return "redirect:/ninjas/new";
	}
}
	


	
	

	
