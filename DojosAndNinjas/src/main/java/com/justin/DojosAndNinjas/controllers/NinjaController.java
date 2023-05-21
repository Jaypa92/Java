package com.justin.DojosAndNinjas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.justin.DojosAndNinjas.models.Dojo;
import com.justin.DojosAndNinjas.models.Ninja;
import com.justin.DojosAndNinjas.services.DojoService;
import com.justin.DojosAndNinjas.services.NinjaService;

import jakarta.validation.Valid;

@Controller
public class NinjaController {
	@Autowired
	NinjaService ninjaServ;
	
	@Autowired
	DojoService dojoServ;
	
	@RequestMapping("/ninja")
	public String createNinja(Model model,@ModelAttribute("newNinja")Ninja newNinja) {
		List<Dojo> dojos = dojoServ.getDojos();
		model.addAttribute("dojos",dojos);
		return "CreateNinja.jsp";
	}
	
	@PostMapping("/ninja/process")
	public String ninjaProcess(@Valid @ModelAttribute("newNinja")Ninja newNinja,BindingResult result,Model model){
		if(result.hasErrors()) {
			List<Dojo> dojos = dojoServ.getDojos();
			model.addAttribute("dojos",dojos);
			return "CreateNinja.jsp";
		}
		ninjaServ.addNinja(newNinja);
		return "redirect:/ninja";
	}
}
