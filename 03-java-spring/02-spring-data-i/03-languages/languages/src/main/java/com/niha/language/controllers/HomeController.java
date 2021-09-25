package com.niha.language.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niha.language.models.Language;
import com.niha.language.services.LangService;

@Controller
public class HomeController {
	@Autowired
	private LangService lService;
	
	@GetMapping("/language")
	//if uncomment do viewModel
	public String index(@ModelAttribute("language")Language language, Model viewModel) {
	viewModel.addAttribute("allLangs", this.lService.getAllLanguages());
		return "index.jsp";
	}
	
	@PostMapping("/language")
	public String addLanguage(@Valid @ModelAttribute("language") Language language, BindingResult result) {
		if(result.hasErrors()) {
			return "index.jsp";
		}
		this.lService.createLang(language);
		return"redirect:/language";
	}
	
	@GetMapping("/language/{id}")
	public String view(@PathVariable("id") Long id, Model model) {
        Language language = lService.getOneLang(id);
        model.addAttribute("language", language);
		return "view.jsp";
	}
	
    @GetMapping("/language/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        Language language = lService.getOneLang(id);
        model.addAttribute("language", language);
        return "edit.jsp";
    }
    
    @PostMapping("/language/edit")
    public String editLang(@Valid @ModelAttribute("language") Language language, BindingResult result) {
        if (result.hasErrors()) {
            return "edit.jsp";
        } 
        else {
            lService.editLang(language);
            return "redirect:/language";
        }
    }
    
        @GetMapping("/delete/{id}")
        public String destroy(@PathVariable("id") Long id) {
            lService.deleteLang(id);
            return "redirect:/language";
        }
}

