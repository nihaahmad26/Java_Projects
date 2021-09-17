package com.niha.date.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DateController {
	
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@PostMapping("/findDate")
	public String findDate() {
		return "redirect:/date";
	}
	
	@PostMapping("/findTime")
	public String findTime() {
		return "redirect:/time";
	}
	
	@GetMapping("/date")
	public String date(Model model) {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE,dd MMMM, yyyy");
		String date = formatter.format(now);
		model.addAttribute("date", date);
		return "date.jsp";
	}
	
	@GetMapping("/time")
	public String time(Model model) {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
		String time = formatter.format(now);
		model.addAttribute("time", time);
		return "time.jsp";
	}
}
