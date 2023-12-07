package com.java.wherego.event.dao;

import java.util.List;

import com.java.wherego.event.domain.Event;


public interface EventDao {
	public void add(Event event);
	public Event getUsingId(int id);
	public List<Event> getUsingCodename(String codename);
}
