package com.java.wherego.event.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Event {
	private int id;
	@NonNull
	private String codename;
	@NonNull
	private String guname;
	@NonNull
	private String title;
	@NonNull
	private String date;
	@NonNull
	private String place;
	@NonNull
	private String orgName;
	@NonNull
	private String useTrgt;
	@NonNull
	private String useFree;
	@NonNull
	private String player;
	@NonNull
	private String program;
	@NonNull
	private String etcDesc;
	@NonNull
	private String orgLink;
	@NonNull
	private String mainImg;
	@NonNull
	private String rgsdate;
	@NonNull
	private String ticket;
	@NonNull
	private String strdate;
	@NonNull
	private String endDate;
	@NonNull
	private String themecode;
	@NonNull
	private double lot;
	@NonNull
	private double lat;
	@NonNull
	private String isFree;
	@NonNull
	private String hmpgAddr;
}
