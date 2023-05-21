package com.justin.Cars.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.justin.Cars.Models.Cars;
import com.justin.Cars.Repositories.CarsRepository;

@Service
public class CarsService {
	@Autowired
	CarsRepository carsRepo;;
	
	public List<Cars> findAll(){
		return carsRepo.findAll();
	}
	
	public Cars create(Cars cars) {
		return carsRepo.save(cars);
	}
	
	public Cars findById(Long id) {
		Optional<Cars> car = carsRepo.findById(id);
		if(car.isPresent()) {
			return car.get();		}
		return null;
	}
	
	public Cars update(Cars cars) {
		Optional<Cars> car = carsRepo.findById(cars.getId());
		if(car.isPresent()) {
			return carsRepo.save(cars);		}
		return null;
	}
	
	public void delete(Long id) {
		carsRepo.deleteById(id);
	}
}
