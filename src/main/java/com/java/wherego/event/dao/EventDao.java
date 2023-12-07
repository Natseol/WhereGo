package com.java.wherego.event.dao;

import java.util.List;

import com.java.wherego.event.domain.Event;


public interface EventDao {
	public void add(Event event);
	public Event get(int id);
	public List<Event> getUsingCodename(String codename);
	public List<Event> getUsingCodenameAndDate(String codename, String date);
	public List<Event> getUsingDate(String date);
	public List<Event> getUsingBearing(Double latN, Double latS, Double lotW, Double lotE);
	public List<Event> getUsingBearing(String date, Double latN, Double latS, Double lotW, Double lotE);
}
