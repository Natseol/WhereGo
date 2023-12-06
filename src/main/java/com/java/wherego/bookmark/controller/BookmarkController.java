package com.java.wherego.bookmark.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookmarkController {

	@GetMapping("/bookmark")
	public String bookmarkPage(Model model) {
		model.addAttribute("path", "/bookmark/bookmark"); 
		model.addAttribute("content", "bookmarkFragment"); 
		model.addAttribute("contentHead", "bookmarkFragmentHead");
				
		return "basic/layout";
	}
}
