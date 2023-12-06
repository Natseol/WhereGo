package com.java.wherego.map.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MapContorller {
	
	@GetMapping("/map")
	public String mapPage(Model model) {
		model.addAttribute("path", "/map/map"); 
		model.addAttribute("content", "mapFragment"); 
		model.addAttribute("contentHead", "mapFragmentHead");
				
		return "basic/layout";
	}
	
	@GetMapping("/calendar")
	public String calendarPage(Model model) {
		model.addAttribute("path", "/calendar/calendar"); 
		model.addAttribute("content", "calendarFragment"); 
		model.addAttribute("contentHead", "calendarFragmentHead");
				
		return "basic/layout";
	}
}
