package com.justin.SaveTravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.justin.SaveTravels.models.Expense;
import com.justin.SaveTravels.repositories.SaveTravelRepository;

@Service
public class SaveTravelsService {
	private final SaveTravelRepository saveTravelRepo;
	
	public SaveTravelsService(SaveTravelRepository saveTravelRepo) {
		this.saveTravelRepo=saveTravelRepo;
	}
	
	public List<Expense> allExpenses(){
		return saveTravelRepo.findAll();
		}
	
	public Expense addExpense(Expense expense) {
		return saveTravelRepo.save(expense);
	}
	
	public Expense findExpense(Long id) {
		Optional<Expense> optionalExpense = saveTravelRepo.findById(id);
		if(optionalExpense.isPresent()) {
			return optionalExpense.get();
		}
		return null;
	}
	
	public Expense updateExpense(Expense expense) {
		return saveTravelRepo.save(expense);
	}
	
	public void delete(Long id) {
		saveTravelRepo.deleteById(id);
	}
	
	
	
	
}
