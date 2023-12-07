package com.java.wherego.event.service;

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
}
