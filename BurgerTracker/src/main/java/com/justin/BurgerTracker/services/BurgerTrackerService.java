package com.justin.BurgerTracker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.justin.BurgerTracker.models.Burger;
import com.justin.BurgerTracker.repositories.BurgerRepository;

@Service
public class BurgerTrackerService {
	private final BurgerRepository burgerRepository;
	
	public BurgerTrackerService(BurgerRepository burgerRepository) {
		this.burgerRepository=burgerRepository;
	}
	
	public List<Burger> allBurgers(){
		return burgerRepository.findAll();
	}
	
	public Burger addBurger(Burger burger) {
		return burgerRepository.save(burger);
	}
	
	public Burger findBurger(Long id) {
		Optional<Burger> optionalBurger = burgerRepository.findById(id);
		if(optionalBurger.isPresent()) {
			return optionalBurger.get();
		}
		return null;
	}
	
	public Burger updateBurger(Burger burger) {
		return burgerRepository.save(burger);
	}
}
