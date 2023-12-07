package com.java.wherego.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.wherego.user.dao.UserDao;
import com.java.wherego.user.domain.User;

@Service
public class UserService {
	@Autowired
	UserDao userDao;
	
	public void add(User user) {
		userDao.add(user);
	}
}
