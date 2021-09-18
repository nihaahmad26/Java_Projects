package com.niha.survey.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SurveyController {

	private String[] Languages() {
		return new String[] {
				"python", "java", "mern"
		};
	}	
	private String[] Locations() {
		return new String[] {
				"Chicago", "Seattle", "San Jose"
		};
	}
		
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("language", Languages());
		model.addAttribute("location", Locations());	
		return "index.jsp";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam(value="name") String name,@RequestParam(value="location") String location,@RequestParam(value="language") String language,@RequestParam(value="comment") String comment, Model model) {
		model.addAttribute("name", name);
		model.addAttribute("location", location);
		model.addAttribute("language", language);
		model.addAttribute("comment", comment);
	return "result.jsp";
	}
	
}
