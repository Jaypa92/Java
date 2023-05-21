package com.justin.Omikuji.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/omikuji")
public class OmikujiController {
	@RequestMapping("")
	public String index() {
		return "NewFile.jsp";
	}
	
	@RequestMapping(value="/processing",method=RequestMethod.POST)
		public String fortune(HttpSession session,
				@RequestParam(value="number",required=false)Integer number,
				@RequestParam(value="city",required=false)String city,
				@RequestParam(value="person",required=false) String person,
				@RequestParam(value="hobby",required=false) String hobby,
				@RequestParam(value="thing",required=false) String thing,
				@RequestParam(value="message",required=false) String message
				) {
		
		session.setAttribute("number", number);
		session.setAttribute("city", city);
		session.setAttribute("person", person);
		session.setAttribute("hobby", hobby);
		session.setAttribute("thing", thing);
		session.setAttribute("message", message);
			
		return "redirect:/omikuji/show";
	}
	
	@RequestMapping("/show")
	public String show(){
		return "Show.jsp";
	}
		
}
