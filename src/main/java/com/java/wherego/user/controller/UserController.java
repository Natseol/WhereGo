package com.java.wherego.user.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.wherego.user.domain.User;
import com.java.wherego.user.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	@Autowired
	UserService userService;
	
	@GetMapping("/")
	public String mainPage() {
				
		return "/index";
	}
	
	@PostMapping("/login")
	public String loginUser(@RequestParam Map<String, String> data, HttpSession session) {
		try {
			User tempUser = new User(data.get("loginId"), data.get("loginPw"));
			tempUser = userService.login(tempUser);
			if (tempUser != null) {
				session.setAttribute("Id", tempUser.getId());
				session.setAttribute("userId", tempUser.getUserId());
				return "redirect:/map";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/";
	}	
	
	@PostMapping("/regist")
	public String registUser(@RequestParam Map<String, String> data, Model model) {
		try {
			User user = new User(data.get("registId"), data.get("registPw"));
			userService.add(user);			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			model.addAttribute("error","회원가입실패");
		}
		return "redirect:/";
	}
	
	@GetMapping("/a")
	public String boardMainPage(@RequestParam(defaultValue = "1") int page, Model model) {
		return null;
	}
	
}
