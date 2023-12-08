package com.java.wherego.event.dao;

import java.util.List;

import com.java.wherego.event.domain.Event;


public interface EventDao {
	public void add(Event event);
	public Event get(int id);
	public List<Event> getUsingCodename(String codename);
	public List<Event> getUsingCodenameAndDate(String codename, String date);
	public List<Event> getUsingDate(String date);
	public List<Event> getUsingBearing(double latN, double latS, double lotW, double lotE);
	public List<Event> getUsingDateAndBearing(String date, double latN, double latS, double lotW, double lotE);
}
