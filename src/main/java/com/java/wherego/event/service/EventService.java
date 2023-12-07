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
	
	public List<Event> getUsingCodenameAndDate(String codename, String date) {
		return eventDao.getUsingCodenameAndDate(codename, date);
	}
	
	public List<Event> getUsingDate(String date) {
		return eventDao.getUsingDate(date);
	}
	
	public List<Event> getUsingBearing(Double latN, Double latS, Double lotW, Double lotE) {
		return eventDao.getUsingBearing(latN, latS, lotW, lotE);
	}
	
	public List<Event> getUsingBearing(String date, Double latN, Double latS, Double lotW, Double lotE) {
		return eventDao.getUsingBearing(date, latN, latS, lotW, lotE);
	}
}
