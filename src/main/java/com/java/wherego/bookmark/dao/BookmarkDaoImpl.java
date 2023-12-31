package com.java.wherego.bookmark.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.java.wherego.bookmark.domain.Bookmark;

@Repository
public class BookmarkDaoImpl implements BookmarkDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private RowMapper<Bookmark> mapper = new RowMapper<Bookmark>() {

		@Override
		public Bookmark mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			return new Bookmark(rs.getInt("id"),
					rs.getInt("user_id"),
					rs.getInt("event_id"),
					rs.getString("title"),
					rs.getString("codename"),
					rs.getString("place"),
					rs.getString("date"),
					rs.getString("use_trgt"),
					rs.getString("is_free"),
					rs.getString("main_img")
					);
		}
	};

	public void add(Bookmark bookmark) {
		jdbcTemplate.update("insert into bookmark (user_id, event_id) values (?,?)", bookmark.getUserId(),
				bookmark.getEventId());
	}
	
	public void del(int id) {
		jdbcTemplate.update("delete from bookmark where id=?", id);
	}

	public List<Bookmark> getAll(int userId) {
		return jdbcTemplate.query(
				"select a.*, e.title, e.codename, e.place, e.date, e.use_trgt, e.is_free, e.main_img from bookmark a "
				+ "join events e on a.event_id = e.id where a.user_id= ?",
				mapper, userId);
	}
}
