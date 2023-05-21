package com.justin.BookClub.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.justin.BookClub.models.LogInUser;
import com.justin.BookClub.models.User;
import com.justin.BookClub.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepo;
	
	public User create(User user) {
		String hashPW = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hashPW);
		return userRepo.save(user);
	}
	
	public User getUser(String email) {
		Optional<User> user = userRepo.findByEmail(email);
		if(user.isPresent()) {
			return user.get();
		}
		return null;
	}
	
	public User getUserId(Long id) {
		Optional<User> user = userRepo.findById(id);
		if(user.isPresent()) {
			return user.get();
		}
		return null;
	}
	
	public User login(LogInUser loginuser, BindingResult result) {
		if(result.hasErrors()) {
			return null;
		}
		User loginUser = getUser(loginuser.getEmail());
		if(loginUser==null) {
			result.rejectValue("email","Unique","Bad credentials!");
		}
		if(!BCrypt.checkpw(loginuser.getPassword(), loginUser.getPassword())) {
			result.rejectValue("password", "Matches","Invalid password!");
		}
		return loginUser;
	}
	
	
	
	
}
