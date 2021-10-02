package com.niha.dojo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niha.dojo.models.Dojo;
import com.niha.dojo.models.Ninja;
import com.niha.dojo.services.DojoService;

@Controller
@RequestMapping("/ninjas")
public class NinjaController {
	@Autowired
	private DojoService dService;
	
	@GetMapping("/new")
	public String addNinja(@ModelAttribute("ninja") Ninja ninja, Model viewModel) {
		List<Dojo> allDojos = this.dService.getAllDojos();
		viewModel.addAttribute("allDojos", allDojos);
		return "newninja.jsp";
}
	@PostMapping("/createNinja")
	public String createNinja(@ModelAttribute("ninja") Ninja ninja, Model viewModel) {
		this.dService.createdNinja(ninja);
		return "redirect:/dojo" + ninja.getDojo().getId();
		}
	
}
