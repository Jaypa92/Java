package com.justin.SaveTravels.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.justin.SaveTravels.models.Expense;

public interface SaveTravelRepository extends CrudRepository<Expense,Long> {
	List<Expense> findAll();
}
