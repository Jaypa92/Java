package com.justin.DojosAndNinjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.justin.DojosAndNinjas.models.Ninja;

public interface NinjaRepository extends CrudRepository<Ninja, Long> {
	List<Ninja> findAll();
}
