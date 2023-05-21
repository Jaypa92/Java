package com.justin.DaikichiPath.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/daikichi")
public class DiakichiController {
	@RequestMapping(value="",method=RequestMethod.GET)
	public String index() {
		return "Welcome!";
	}
	
	@RequestMapping(value="/today",method=RequestMethod.GET)
	public String today() {
		return "Today you will find luck in all your endeavors";
	}
	
	@RequestMapping(value="/tomorrow",method=RequestMethod.GET)
	public String tomorrow() {
		return "Tomorrow, an opportunity will arise, so be sure to be open to new ideas";
	}
	
	@RequestMapping("/travel/{city}")
	public String travel(@PathVariable("city") String city) {
		return "Congratulations!! You will soon travel to " + city+"!!!";
	}
	
	@RequestMapping("/lotto/{number}")
	public String lotto(@PathVariable("number") int number) {
		if(number%2 == 0) {
			return "You will take a grand journey in the near future, but be weary of tempting offers";
		}
		return "You have enjoyed the fruits of your labor but now is a time to spend time with family and friends!";
	}
}
