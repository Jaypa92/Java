package com.justin.NinjaGold.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class NinjaGoldController {
	@RequestMapping("")
	public String index() {
		return "NinjaGold.jsp";
	}
	
	@RequestMapping(value="/processing",method=RequestMethod.POST)
		public String processing(HttpSession session,
				@RequestParam(value="farm",required=false)String farm,
				@RequestParam(value="cave",required=false)String cave,
				@RequestParam(value="house",required=false)String house,
				@RequestParam(value="quest",required=false)String quest
				) {
		int gold=0;
		ArrayList<String> activities= new ArrayList<String>();
		SimpleDateFormat simpleFormat = new SimpleDateFormat("MMMM d Y h: mm a");
		
		if(session.getAttribute("gold") == null) {
			session.setAttribute("gold", gold);
			session.setAttribute("activities", activities);
		}else {
			gold = (int) session.getAttribute("gold");
			activities = (ArrayList<String>) session.getAttribute("activities");
			
		}
		if(farm != null) {
			int amount = new Random().nextInt(11)+10;
			gold+=amount;
			activities.add("You have enetered a farm and earned "+amount+" gold. ("+simpleFormat.format(new Date())+")");
			session.setAttribute("activities", activities);
			session.setAttribute("gold", gold);	
			return "redirect:/";
		}
		if(cave != null) {
			int amount = new Random().nextInt(6)+5;
			gold+=amount;
			activities.add("You have enetered a cave and earned "+amount+" gold. ("+simpleFormat.format(new Date())+")");
			session.setAttribute("activities", activities);
			session.setAttribute("gold", gold);	
			return "redirect:/";
		}
		if(house != null) {
			int amount = new Random().nextInt(4)+2;
			gold+=amount;
			activities.add("You have enetered a house and earned "+amount+" gold. ("+simpleFormat.format(new Date())+")");
			session.setAttribute("activities", activities);
			session.setAttribute("gold", gold);	
			return "redirect:/";
		}
		if(quest != null) {
			int amount = new Random().nextInt(101)-50;
			gold+=amount;
			if(amount >= 0) {				
				activities.add("You have completed a quest and earned "+amount+" gold. ("+simpleFormat.format(new Date())+")");
			}else {
				activities.add("You have failed a quest and lost "+amount*-1+" gold. ("+simpleFormat.format(new Date())+")");
			}
			session.setAttribute("activities", activities);
			session.setAttribute("gold", gold);	
			return "redirect:/";
		}
		session.setAttribute("activities", activities);
		session.setAttribute("gold", gold);
		return "redirect:/";
		
		}
}
