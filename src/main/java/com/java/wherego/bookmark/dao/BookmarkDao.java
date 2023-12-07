package com.java.wherego.bookmark.dao;

import java.util.List;

import com.java.wherego.bookmark.domain.Bookmark;

public interface BookmarkDao{
	public void add(Bookmark bookmark);
	public List<Bookmark> getAll(int userId);
}
