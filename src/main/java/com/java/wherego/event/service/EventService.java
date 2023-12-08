package com.java.wherego.event.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.wherego.event.dao.EventDao;
import com.java.wherego.event.dao.EventDaoImpl;
import com.java.wherego.event.domain.Event;

@Service
public class EventService {
	@Autowired
	EventDao eventDao;
	
	public void add(Event event) {
		eventDao.add(event);
	}
	public Event get(int id) {
		return eventDao.get(id);
	}
	
	public List<Event> getUsingCodename(String codename) {
		return eventDao.getUsingCodename(codename);
	}
	
	private List<Event> getUsingDate(String date) {
		return eventDao.getUsingDate(date);
	}
	
	public List<Event> getUsingCodenameAndDate(String codename, String date) {
		if (codename.equals("분류")) return getUsingDate(date);
		return eventDao.getUsingCodenameAndDate(codename, date);
	}	
	
	public List<Event> getUsingBearing(double latN, double latS, double lotW, double lotE) {
		return eventDao.getUsingBearing(latN, latS, lotW, lotE);
	}
	
	public List<Event> getUsingDateAndBearing(String date, double latN, double latS, double lotW, double lotE) {
		return eventDao.getUsingDateAndBearing(date, latN, latS, lotW, lotE);
	}
}
