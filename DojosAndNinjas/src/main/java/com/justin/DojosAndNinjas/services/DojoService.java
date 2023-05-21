package com.justin.DojosAndNinjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.justin.DojosAndNinjas.models.Dojo;
import com.justin.DojosAndNinjas.repositories.DojoRepository;

@Service
public class DojoService {
	@Autowired
	private DojoRepository dojoRepo;
	
	public List<Dojo> getDojos(){
		return dojoRepo.findAll();
	}
	
	public Dojo create(Dojo dojo) {
		return dojoRepo.save(dojo);
	}
	
	public Dojo findDojo(Long id) {
		Optional<Dojo> dojo = dojoRepo.findById(id);
		if(dojo.isPresent()) {
			return dojo.get();
		}
		return null;
	}
	
	public Dojo updateDojo(Dojo dojo) {
		Optional<Dojo> optionalDojo = dojoRepo.findById(dojo.getId());
		if(optionalDojo.isPresent()) {
			return dojoRepo.save(dojo);
		}
		return null;
	}
	
}
