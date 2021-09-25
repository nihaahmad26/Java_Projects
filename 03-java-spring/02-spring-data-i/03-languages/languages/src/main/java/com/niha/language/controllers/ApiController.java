package com.niha.language.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niha.language.models.Language;
import com.niha.language.services.LangService;

@RestController
@RequestMapping("/api")
public class ApiController {
	@Autowired
	private LangService lService;

	@GetMapping("")
	public List<Language> index(){
		return this.lService.getAllLanguages();
	}
	
	@GetMapping("/{id}")
	public Language getOne(@PathVariable("id") Long id) {
		return this.lService.getOneLang(id);
	}
	
}
