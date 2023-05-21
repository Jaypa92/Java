package com.justin.SaveTravels.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.justin.SaveTravels.models.Expense;
import com.justin.SaveTravels.services.SaveTravelsService;

import jakarta.validation.Valid;

@Controller
public class SaveTravelController {
	@Autowired
	SaveTravelsService travelService;
	
	@RequestMapping("/")
	public String index(@ModelAttribute("newExpense")Expense newExpense,Model model) {
		List<Expense> expenses = travelService.allExpenses();
		model.addAttribute("newExpenses",expenses);
		return "index.jsp";
	}
	
	@PostMapping("/addExpense")
	public String index(@Valid @ModelAttribute("newExpense")Expense newExpense, BindingResult result,Model model) {
		if(result.hasErrors()) {
			List<Expense> expenses = travelService.allExpenses();
			model.addAttribute("newExpenses",expenses);
			return "index.jsp";
		}
		travelService.addExpense(newExpense);
		return "redirect:/";
	}
	
	@RequestMapping("/{id}")
	public String edit(@PathVariable("id")Long id,@ModelAttribute("newExpense")Expense newExpense,Model model) {
		
		model.addAttribute("newExpense",travelService.findExpense(id));
		
		return "edit.jsp";
	}
	
	@PutMapping("/edit/{id}")
	public String editting(@Valid @ModelAttribute("newExpense")Expense newExpense,BindingResult result,@PathVariable("id")Long id) {
		if(result.hasErrors()) {
			return "edit.jsp";
		}
		travelService.updateExpense(newExpense);
		return "redirect:/";
	}
	
	@RequestMapping("/expenses/{id}")
	public String singleOne(@PathVariable("id")Long id,Model model) {
		model.addAttribute("expense",travelService.findExpense(id));
		return "singleOne.jsp";
	}
	
	@DeleteMapping("/expenses/delete/{id}")
	public String delete(@PathVariable("id")Long id) {
		travelService.delete(id);
		return "redirect:/";
	}
	
	
	
	
	
	
	
	
}
