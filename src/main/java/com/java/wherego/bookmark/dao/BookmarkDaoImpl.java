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
			return new Bookmark(rs.getInt("id"), rs.getInt("user_id"), rs.getInt("event_id"));
		}
	};

	public void add(Bookmark bookmark) {
		jdbcTemplate.update("insert into bookmark (user_id, event_id) values (?,?)", bookmark.getUserId(),
				bookmark.getEventId());
	}

	public List<Bookmark> getAll(int userId) {
		return jdbcTemplate.query(
				"select a.*, e.title, e.codename, e.date, e.use_trgt, e.is_free from bookmark a "
				+ "join events e on a.event_id = e.id where a.user_id= ?",
				mapper, userId);
	}
}
