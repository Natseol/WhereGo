package com.java.wherego.bookmark.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Bookmark {
	private int id;
	private final int userId;
	private final int eventId;
	private String title;
	private String codename;
	private String place;
	private String date;
	private String useTrgt;
	private String isFree;
	private String mainImg;
}
