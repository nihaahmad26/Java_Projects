package com.niha.dojo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niha.dojo.models.Dojo;
import com.niha.dojo.models.Ninja;
import com.niha.dojo.repositories.DojoRepository;
import com.niha.dojo.repositories.NinjaRepository;

@Service

public class DojoService {
	@Autowired
	private DojoRepository dRepo;
	private NinjaRepository nRepo;
	
	public List<Dojo> getAllDojos(){
		return this.dRepo.findAll();
	}
	
	public Dojo getOneDojo(Long id) {
		return this.dRepo.findById(id).orElse(null);
	}
	
	public Dojo createDojo(Dojo dojo){
	       return this.dRepo.save(dojo);
	}
	
	public Dojo editDojo(Dojo dojo) {
        return this.dRepo.save(dojo);
}
	public String deleteDojo(Long id) {
		this.dRepo.deleteById(id);
		return "Dojo has been deleted";
	}
	
	public Ninja createdNinja(Ninja ninja) {
		return this.nRepo.save(ninja);
	}
	
	}
	
