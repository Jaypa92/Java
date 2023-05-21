package com.justin.BookClub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.justin.BookClub.models.Book;
import com.justin.BookClub.repositories.BookRepository;

@Service
public class BookService {
	@Autowired
	BookRepository bookRepo;
	
	public List<Book> findAll(){
		return bookRepo.findAll();
	}
	
	public Book create(Book book) {
		return bookRepo.save(book);
	}
	
	public Book find(Long id) {
		Optional<Book> potential = bookRepo.findById(id);
		if(potential.isPresent()) {
			return potential.get();
		}
		return null;
	}
	
	public Book update(Book book) {
		Optional<Book> potential = bookRepo.findById(book.getId());
		if(potential.isPresent()) {
			return bookRepo.save(book);
		}
		return null;
	}
	
	public void delete(Long id) {
		bookRepo.deleteById(id);
	}
	
	
	
	
}
