package com.justin.Cars.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.justin.Cars.Models.Cars;

public interface CarsRepository extends CrudRepository<Cars, Long>{
	List<Cars> findAll();
}
