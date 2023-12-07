package com.java.wherego.bookmark.service;

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
	
}
