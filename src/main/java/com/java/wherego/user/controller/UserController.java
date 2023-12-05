package com.java.wherego.user.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
	
	@GetMapping("/")
	public String mainPage() {
				
		return "index";
	}
	
	
	
	@GetMapping("/a")
	public String boardMainPage(@RequestParam(defaultValue = "1") int page, Model model) {
		return null;
	}
	
	@PostMapping("regist")
	public String registUser(@RequestParam Map<String, String> data, Model model) {
		return "";
	}
}
