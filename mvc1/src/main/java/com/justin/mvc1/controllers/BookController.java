package com.justin.mvc1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.justin.mvc1.models.Book;
import com.justin.mvc1.services.BookService;

@Controller
public class BookController {
	@Autowired
	BookService bookService;
	
	@GetMapping("/books/{id}")
	public String index(Model model,@PathVariable("id")Long id) {

		model.addAttribute("book",bookService.findBook(id));
		
		return "show.jsp";
	}
	
	@GetMapping("/books")
	public String Index(Model model) {
		List<Book> books = bookService.allBooks();
		model.addAttribute("books", books);
		return "index.jsp";
	}
}
