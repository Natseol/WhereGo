package com.java.wherego.map.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MapContorller {
	
	@GetMapping("/map")
	public String mainPage(Model model) {
		model.addAttribute("path", "/map/map"); 
		model.addAttribute("content", "mapFragment"); 
		model.addAttribute("contentHead", "mapFragmentHead");
				
		return "basic/layout";
	}
}
