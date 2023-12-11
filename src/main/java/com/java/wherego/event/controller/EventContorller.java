package com.java.wherego.event.controller;

import java.io.IOException;
import java.util.HashMap;
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
import com.java.wherego.event.service.EventServiceForList;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class EventContorller {
	@Autowired
	EventService eventService;
	@Autowired
	EventServiceForList eventServiceForList;

	@GetMapping("/map")
	public String mapPage(@RequestParam Map<String, String> data, Model model) {
		model.addAttribute("path", "/map/map");
		model.addAttribute("content", "mapFragment");
		model.addAttribute("contentHead", "mapFragmentHead");
		if (data.get("id") != null) {
			int id = Integer.parseInt(data.get("id"));
			model.addAttribute("lot", eventService.get(id).getLot());
			model.addAttribute("lat", eventService.get(id).getLat());
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
		String date = data.get("date");

		return eventService.getUsingDateAndBearing(date, latN, latS, lotW, lotE);
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

	@ResponseBody
	@PostMapping("/event")
	public Event getEvent(@RequestBody Map<String, String> data) {
		int id = Integer.parseInt(data.get("eventId"));
		return eventService.get(id);
	}

	@ResponseBody
	@GetMapping("/add")
	public Map<String, String> addCheck(HttpServletRequest request) {
		Map<String, String> response = new HashMap<>();		
		try {
			String DBday = eventServiceForList.getLastEvent().getRgsdate();
			List<Event> list = eventServiceForList.newList(1, 350, DBday);
			int count = eventService.getCount();
			response.put("count", String.valueOf(count));
			if (list.size() > 0) {				
				response.put("message", "업데이트 필요");
			} else {
				response.put("message", "업데이트 완료");				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.put("message", "에러");
		}
		
		return response;
	}
	
	@ResponseBody
	@PostMapping("/add")
	public String addEvent(@RequestBody Map<String, String> data) {
		try {
			String DBday = eventServiceForList.getLastEvent().getRgsdate();
			List<Event> list = eventServiceForList.newList(1, 350, DBday);
			if (list.size() > 0) {
				for (Event event : list) {
					eventService.add(event);
				}				
			}
			return String.valueOf(list.size());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "에러";
		}
	}
	
	@PostMapping("/addlist")
	public String addList(@RequestParam Map<String, String> data, HttpSession session) {
		try {
			if (session.getAttribute("userId").equals("admin")) {
				int start = Integer.parseInt(data.get("start"));
				int end = Integer.parseInt(data.get("end"));
				List<Event> list = eventServiceForList.newList(start, end, "2021-01-01");
				for (Event event : list) {
					eventService.add(event);
				}				
			}				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return "redirect:/bookmark";
		}
		return "redirect:/bookmark";
	}
}
