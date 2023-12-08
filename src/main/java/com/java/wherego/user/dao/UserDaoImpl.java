package com.java.wherego.user.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.java.wherego.user.domain.User;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private RowMapper<User> mapper = new RowMapper<User>() {
		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new User(rs.getInt("id"),
					rs.getString("user_id"),
					rs.getString("password"));
		}
	};
	
	public void add(User user) {
		jdbcTemplate.update("insert into users (user_id, password) values (?, ?)",
				user.getUserId(),user.getPassword());
	}
	
	public User get(String userId) {
		return jdbcTemplate.queryForObject("select * from users where user_id=?", mapper, userId);
	}
	
	public User get(int id) {
		return jdbcTemplate.queryForObject("select * from users where id=?", mapper, id);
	}
}
