package com.java.wherego.user.dao;

import com.java.wherego.user.domain.User;

public interface UserDao {
	public void add(User user);
	public User get(String userId);
	public User get(int id);
}
