package com.justin.DojosAndNinjas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.justin.DojosAndNinjas.models.Dojo;
import com.justin.DojosAndNinjas.services.DojoService;

import jakarta.validation.Valid;

@Controller
public class DojoController {
	
	@Autowired
	DojoService dojoServ;
	
	@RequestMapping("/")
	public String index(Model model,@ModelAttribute("newDojo")Dojo newDojo) {
		List<Dojo> allDojos= dojoServ.getDojos();
		model.addAttribute("dojos",allDojos);
		return "CreateDojo.jsp";
	}
	
	@PostMapping("/processDojo")
	public String processDojo(@Valid @ModelAttribute("newDojo")Dojo newDojo,BindingResult result,Model model) {
		if(result.hasErrors()) {
			model.addAttribute("dojos",dojoServ.getDojos());
			return "CreateDojo.jsp";
		}
		dojoServ.create(newDojo);
		return "redirect:/";
	} 
	
	@RequestMapping("/{dojoId}")
	public String dojoWithNinjas(@PathVariable("dojoId")Long id,@ModelAttribute("dojo")Dojo dojo, Model model) {
		model.addAttribute("dojo",dojoServ.findDojo(id));
		return "DojoAndNinjas.jsp";
	}
	
}
