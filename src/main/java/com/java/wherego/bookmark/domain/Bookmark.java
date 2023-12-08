package com.java.wherego.bookmark.domain;

import com.java.wherego.user.domain.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Bookmark {
	private int id;
	@NonNull
	private int userId;
	@NonNull
	private int eventId;
	private String title;
	private String codename;
	private String place;
	private String date;
	private String useTrgt;
	private String isFree;
	private String mainImg;
}
