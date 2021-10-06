package com.niha.dojo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niha.dojo.models.Dojo;
import com.niha.dojo.models.Ninja;
import com.niha.dojo.services.DojoService;

@Controller
public class NinjaController {
	@Autowired
	private DojoService dService;
	
	@GetMapping("/ninjas/new")
	public String addNinja(@ModelAttribute("ninja") Ninja ninja, Model viewModel) {
		List<Dojo> allDojos = this.dService.getAllDojos();
		viewModel.addAttribute("allDojos", allDojos);
		return "newninja.jsp";
}
	@PostMapping("/createNinja")
	public String createNinja(@ModelAttribute("ninja") Ninja ninja, BindingResult result) {
		this.dService.createNinja(ninja);
		return "redirect:/ninjas";
		}
	
	@GetMapping("/ninjas")
	public String Ninjas(@ModelAttribute("ninja") Ninja ninja, Model viewModel) {
		List<Ninja> allNinjas = this.dService.getAllNinjas();
		viewModel.addAttribute("allNinjas", allNinjas);
		return "ninjas.jsp";
	}
	
}
