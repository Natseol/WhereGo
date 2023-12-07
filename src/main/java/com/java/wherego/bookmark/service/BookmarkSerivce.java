package com.java.wherego.bookmark.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.wherego.bookmark.dao.BookmarkDao;
import com.java.wherego.bookmark.domain.Bookmark;

@Service
public class BookmarkSerivce {
	@Autowired
	BookmarkDao bookmarkDao;
	
	public void add(Bookmark bookmark) {
		bookmarkDao.add(bookmark);
	}
	
	public void del(int id) {
		bookmarkDao.del(id);
	}
	
	public List<Bookmark> getAll(int userId) {
		return bookmarkDao.getAll(userId);
	}
	
}
