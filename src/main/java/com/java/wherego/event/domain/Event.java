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
	private String orgName;
	private String useTrgt;
	private String useFee;
	private String player;
	private String program;
	private String eteDesc;
	private String orgLink;
	private String mainImg;
	private String rgsdate;
	private String ticket;
	private String strdate;
	private String endDate;
	private String themecode;
	private double lot;
	private double lat;
	private String isFee;
	private String hmpgAddr;
}
