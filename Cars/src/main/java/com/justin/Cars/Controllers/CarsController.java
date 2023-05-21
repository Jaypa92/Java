package com.justin.Cars.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.justin.Cars.Models.Cars;
import com.justin.Cars.Models.User;
import com.justin.Cars.Services.CarsService;
import com.justin.Cars.Services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class CarsController {
	@Autowired
	UserService userServ;
	
	@Autowired
	CarsService carsServ;
	
	@GetMapping("/display")
	public String display(HttpSession session,Model model) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		model.addAttribute("user",userServ.findByID((Long)session.getAttribute("user_id")));
		List<Cars> cars = carsServ.findAll();
		model.addAttribute("cars",cars);
		return "display.jsp";
	}
	
	@GetMapping("/add/car")
	public String add(@ModelAttribute("car")Cars car) {
		
		return "addCar.jsp";
	}
	
	@PostMapping("/new/process")
	public String carProcess(@Valid @ModelAttribute("car")Cars car,BindingResult result,Model model,HttpSession session) {
		Long userId = (Long) session.getAttribute("user_id");
		if(result.hasErrors()) {
			return "addCar.jsp";
		}
		User loggedIn = userServ.findByID(userId);
		model.addAttribute("prevUser",loggedIn);
		car.setUser(loggedIn);
		carsServ.create(car);
		return "redirect:/display";
	}
	
	@GetMapping("/car/{id}")
	public String getOne(@PathVariable("id")Long id,Model model,HttpSession session) {
		Cars car = carsServ.findById(id);
		model.addAttribute("Car",car);
		Long userId = (Long) session.getAttribute("user_id");
		User user = userServ.findByID(userId);
		model.addAttribute("user",user);
		return "viewCar.jsp";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id")Long id,Model model) {
		model.addAttribute("edittedCar",carsServ.findById(id));
		return "edit.jsp";
	}
	
	@PutMapping("/edit/car/{id}")
	public String editProcess(@Valid @ModelAttribute("edittedCar")Cars car,BindingResult result) {
		if(result.hasErrors()) {
			return "edit.jsp";
		}
		carsServ.update(car);
		return "redirect:/display";
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable("id")Long id) {
		carsServ.delete(id);
		return "redirect:/display";
	}
	
	
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
		}
}
