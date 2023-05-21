package com.justin.BookClub.controllers;

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

import com.justin.BookClub.models.Book;
import com.justin.BookClub.models.LogInUser;
import com.justin.BookClub.models.User;
import com.justin.BookClub.services.BookService;
import com.justin.BookClub.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserController {
	@Autowired
	UserService userServ;
	@Autowired
	BookService bookServ;
	
	@GetMapping("/")
	public String index(Model model,@ModelAttribute("newUser")User user) {
		model.addAttribute("prevUser", new LogInUser());
		return "index.jsp";
	}
	
	@PostMapping("/process/new")
	public String processNew(@Valid @ModelAttribute("newUser")User user,BindingResult result, HttpSession session,Model model) {
		if(userServ.getUser(user.getEmail())!= null) {
			result.rejectValue("email", "Unique","Email already in use!");
		}
		if(!user.getPassword().equals(user.getConfirmPassword())) {
			result.rejectValue("password","Match", "Passwords must match!");
		}
		if(result.hasErrors()) {
			model.addAttribute("prevUser", new LogInUser());
			return "index.jsp";
		}
		User Newuser = userServ.create(user);
		session.setAttribute("user_id", Newuser.getId());
		return "redirect:/display";
	}
	
	@PostMapping("/process/user")
	public String logIn(@Valid @ModelAttribute("prevUser")LogInUser logInUser,BindingResult result,HttpSession session,Model model) {
		User logIn= userServ.login(logInUser, result);
		if(result.hasErrors()) {
			model.addAttribute("newUser",new User());
			return "index.jsp";
		}
		session.setAttribute("user_id", logIn.getId());
		return "redirect:/display";	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/display")
	public String display(HttpSession session,Model model) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		model.addAttribute("user",userServ.getUserId((Long)session.getAttribute("user_id")));
		List<Book> books = bookServ.findAll();
		model.addAttribute("books", books);
		return "display.jsp";
	}
	
	@GetMapping("/books")
	public String addBook(@ModelAttribute("newBook")Book book ) {
		return "createBook.jsp";
	}
	
	@PostMapping("/book/add")
	public String add(@Valid @ModelAttribute("newBook")Book book,BindingResult result,Model model,HttpSession session) {
		Long userID = (Long) session.getAttribute("user_id");
		if(result.hasErrors()) {
			return "createBook.jsp";
		}
		User loggedIn = userServ.getUserId(userID);
		model.addAttribute("loggedIn", loggedIn);
		book.setUser(loggedIn);
		bookServ.create(book);
		return "redirect:/display";
	}
	
	@GetMapping("/books/{id}")
	public String edit(@PathVariable("id")Long id,Model model,HttpSession session) {
		Book book = bookServ.find(id);
		Long loggedInUser = (Long)session.getAttribute("user_id");
		model.addAttribute("book", book);
		User loggedUser = userServ.getUserId(loggedInUser);
		model.addAttribute("loggedUser",loggedUser);
		
		return "edit.jsp";
	}
	
	@GetMapping("/edit/{id}")
	public String editBook(@PathVariable("id")Long id,Model model) {
		model.addAttribute("book",bookServ.find(id));
		
		
		return "editBook.jsp";
	}
	
	@PutMapping("/book/edit/{id}")
	public String editting(@Valid @ModelAttribute("book")Book book,BindingResult result){
		if(result.hasErrors()) {
			return "editBook.jsp";
		}
		bookServ.update(book);
		return "redirect:/display";
	}
	
	
	@DeleteMapping("/book/delete/{id}")
	public String delete(@PathVariable("id")Long id) {
		bookServ.delete(id);
		return "redirect:/display";
	}
}
