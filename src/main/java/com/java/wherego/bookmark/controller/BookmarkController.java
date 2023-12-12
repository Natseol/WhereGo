package com.java.wherego.bookmark.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.wherego.bookmark.domain.Bookmark;
import com.java.wherego.bookmark.service.BookmarkSerivce;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class BookmarkController {
	@Autowired
	BookmarkSerivce bookmarkService;

	@GetMapping("/bookmark")
	public String bookmarkPage(HttpSession session, Model model, HttpServletRequest request) {
		model.addAttribute("path", "/bookmark/bookmark"); 
		model.addAttribute("content", "bookmarkFragment"); 
		model.addAttribute("contentHead", "bookmarkFragmentHead");
		
		if (session.getAttribute("Id")!=null) {
			int id = (int) session.getAttribute("Id");		
			List<Bookmark> list = bookmarkService.getAll(id);
			model.addAttribute("list", list);
		}
		return "basic/layout";
	}
	
	@ResponseBody
	@PostMapping("/bookmark/add")
	public String addBookmark(@RequestBody Map<String, String> data, Model model) throws SQLException {		
		try {
			int userId = Integer.parseInt(data.get("userId"));
			int eventId = Integer.parseInt(data.get("eventId"));		
			bookmarkService.add(new Bookmark(userId, eventId));
			return "add";
		} catch (Exception e) {
			// TODO Auto-generated catch block					
			return "failed";
		}		
	}
		
	@PostMapping("/bookmark/del")
	public String delBookmark(@RequestParam Map<String, String> data, Model model) throws SQLException {	
		try {
			int eventId = Integer.parseInt(data.get("event-id"));		
			bookmarkService.del(eventId);		
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();		
		}
		return "redirect:/bookmark";
	}
}
