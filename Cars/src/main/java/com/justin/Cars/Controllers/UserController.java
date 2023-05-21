package com.justin.Cars.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.justin.Cars.Models.LogInUser;
import com.justin.Cars.Models.User;
import com.justin.Cars.Services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserController {
	@Autowired
	UserService userServ;
	
	@GetMapping("/")
	public String login(@ModelAttribute("newUser")User user,Model model) {
		model.addAttribute("oldUser",new LogInUser());
		return "login.jsp";
	}
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser")User user,BindingResult result,Model model,HttpSession session) {
		if(userServ.findByEmail(user.getEmail())!= null) {
			result.rejectValue("email", "Unique","Email already in use!");
		}
		if(!user.getPassword().equals(user.getConfirmPassword())) {
			result.rejectValue("password", "Matches","Password doesn't match!");
		}
		if(result.hasErrors()) {
			model.addAttribute("oldUser",new LogInUser());
			return "login.jsp";
		}
		User newUser = userServ.create(user);
		session.setAttribute("user_id", newUser.getId());
		return "redirect:/display";
	}
	
	@PostMapping("/login")
	public String loginProcess(@Valid @ModelAttribute("oldUser")LogInUser logInUser,BindingResult result,Model model,HttpSession session) {
		User login = userServ.login(logInUser, result);
		if(result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "login.jsp";
		}
		session.setAttribute("user_id", login.getId());
		return "redirect:/display";
	}
}
