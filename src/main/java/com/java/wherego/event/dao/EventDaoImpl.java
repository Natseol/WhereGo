package com.java.wherego.event.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.java.wherego.event.domain.Event;

@Repository
public class EventDaoImpl implements EventDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private RowMapper<Event> mapper = new RowMapper<Event>() {
		@Override
		public Event mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Event(rs.getInt("id"), rs.getString("codename"), rs.getString("guname"), rs.getString("title"),
					rs.getString("date"), rs.getString("place"), rs.getString("org_name"), rs.getString("use_trgt"),
					rs.getString("use_fee"), rs.getString("player"), rs.getString("program"), rs.getString("etc_desc"),
					rs.getString("org_link"), rs.getString("main_img"), rs.getString("rgsdate"), rs.getString("ticket"),
					rs.getString("strdate"), rs.getString("end_date"), rs.getString("themecode"), rs.getDouble("lot"),
					rs.getDouble("lat"), rs.getString("is_free"), rs.getString("hmpg_addr"));
		}
	};

	public void add(Event event) {
		jdbcTemplate.update("insert into events (codename, guname, title, date, place, org_name, use_trgt, use_fee, player, "
				+ "program, etc_desc, org_link, main_img, rgsdate, ticket, strdate, end_date, themecode, lot, lat, is_free, hmpg_addr) "
				+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", event.getCodename(), event.getGuname(),
				event.getTitle(), event.getDate(), event.getPlace(), event.getOrgName(), event.getUseTrgt(),
				event.getUseFee(), event.getPlayer(), event.getProgram(), event.getEtcDesc(), event.getOrgLink(), event.getMainImg(),
				event.getRgsdate(), event.getTicket(), event.getStrdate(), event.getEndDate(), event.getThemecode(),
				event.getLot(), event.getLat(), event.getIsFree(), event.getHmpgAddr());
	}
			
	public Event get(int id) {
		return jdbcTemplate.queryForObject("select * from events where id= ?", mapper, id);
	}
	
	public List<Event> getUsingCodename(String codename) {
		return jdbcTemplate.query("select * from events where codename= ?", mapper, codename);
	}
	
	public List<Event> getUsingCodenameAndDate(String codename, String date) {
		return jdbcTemplate.query("select * from events where codename= ? and strdate<= ? and end_date>= ?", mapper, codename, date, date);
	}
	
	public List<Event> getUsingDate(String date) {
		return jdbcTemplate.query("select * from events where strdate<= ? and end_date>= ?", mapper, date, date);
	}
	
	public List<Event> getUsingBearing(Double latN, Double latS, Double lotW, Double lotE) {
		return jdbcTemplate.query("select * from events where lat<= ? and lat>= ? and lot>= ? and lot<= ?",
				mapper, latN, latS, lotW, lotE);
	}
	
	public List<Event> getUsingBearing(String date, Double latN, Double latS, Double lotW, Double lotE) {
		return jdbcTemplate.query("select * from events where strdate<= ? and end_date>= ? and lat<= ? and lat>= ? and lot>= ? and lot<= ?",
				mapper, date, latN, latS, lotW, lotE);
	}
}
