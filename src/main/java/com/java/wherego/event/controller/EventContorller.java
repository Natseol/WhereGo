package com.java.wherego.event.controller;

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

import com.java.wherego.event.domain.Event;
import com.java.wherego.event.service.EventService;

@Controller
public class EventContorller {
	@Autowired
	EventService eventService;
	
	@GetMapping("/map")
	public String mapPage(@RequestParam Map<String, String> data, Model model) {
		model.addAttribute("path", "/map/map"); 
		model.addAttribute("content", "mapFragment"); 
		model.addAttribute("contentHead", "mapFragmentHead");
		if (data.get("id")!=null) {
			int id = Integer.parseInt(data.get("id"));		
			model.addAttribute("lot",eventService.get(id).getLot());
			model.addAttribute("lat",eventService.get(id).getLat());
		}				
		return "basic/layout";
	}
	
	@ResponseBody
	@PostMapping("/map")
	public List<Event> eventsList(@RequestBody Map<String, String> data, Model model) {
		double latN = Double.parseDouble(data.get("latN"));
		double latS = Double.parseDouble(data.get("latS"));
		double lotW = Double.parseDouble(data.get("lotW"));
		double lotE = Double.parseDouble(data.get("lotE"));
		
		return eventService.getUsingDateAndBearing("2023-12-09", latN, latS, lotW, lotE);
	}
	
	@GetMapping("/calendar")
	public String calendarPage(Model model) {
		model.addAttribute("path", "/calendar/calendar"); 
		model.addAttribute("content", "calendarFragment"); 
		model.addAttribute("contentHead", "calendarFragmentHead");
				
		return "basic/layout";
	}
	
	@ResponseBody
	@PostMapping("/calendar")
	public List<Event> eventsListCalendar(@RequestBody Map<String, String> data) {
		String codename = data.get("codename");
		String date = data.get("date");

		return eventService.getUsingCodenameAndDate(codename, date);
	}
}
