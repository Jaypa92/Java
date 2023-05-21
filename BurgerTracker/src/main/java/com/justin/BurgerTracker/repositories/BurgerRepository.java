package com.justin.BurgerTracker.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.justin.BurgerTracker.models.Burger;

public interface BurgerRepository extends CrudRepository<Burger,Long> {
	List<Burger> findAll();
}
