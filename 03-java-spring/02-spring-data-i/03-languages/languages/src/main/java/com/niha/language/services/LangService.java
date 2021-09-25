package com.niha.language.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niha.language.models.Language;
import com.niha.language.repositories.LangRepository;

@Service
public class LangService {
	@Autowired
	private LangRepository lRepo;
	
	// Get Every Single Language From Database And Return In ArrayList
	public List<Language> getAllLanguages() {
		return this.lRepo.findAll();
	}
	
	//Get One Language
	public Language getOneLang(Long id) {
		return this.lRepo.findById(id).orElse(null);
	}
	
	//Create a Language
	public Language createLang(Language language) {
		return this.lRepo.save(language);
	}
	
	//Update Language
	public Language editLang(Language language) {
		return this.lRepo.save(language);
	}
	
	//Delete Language
	public String deleteLang(Long id) {
		this.lRepo.deleteById(id);
		return "Language has been deleted";
	}
}

