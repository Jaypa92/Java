package com.justin.DojosAndNinjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.justin.DojosAndNinjas.models.Ninja;
import com.justin.DojosAndNinjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	@Autowired
	private NinjaRepository ninjaRepo;
	
	public List<Ninja> getAll(){
		return ninjaRepo.findAll();
	}
	
	public Ninja addNinja(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}
	
	public Ninja findNinja(Long id) {
		Optional<Ninja> ninja = ninjaRepo.findById(id);
		if(ninja.isPresent()) {
			return ninja.get();
		}
		return null;
	}
}
