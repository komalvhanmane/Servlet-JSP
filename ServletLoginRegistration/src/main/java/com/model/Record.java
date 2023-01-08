package com.model;

import java.util.Date;

public class Record {
	private String email;
	private int gameID;
	private double amount;
	private Date date2;
	private int Category;
	private int pcNo;
	private int sectionNo;
	public Record(String email, int gameID, int category, int pcNo) {
		super();
		this.email = email;
		this.setGameID(gameID);
		Category = category;
		this.pcNo = pcNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Date getDate2() {
		return date2;
	}
	public void setDate2(Date date2) {
		this.date2 = date2;
	}
	public int getCategory() {
		return Category;
	}
	public void setCategory(int category) {
		Category = category;
	}
	public int getPcNo() {
		return pcNo;
	}
	public void setPcNo(int pcNo) {
		this.pcNo = pcNo;
	}
	public int getSectionNo() {
		return sectionNo;
	}
	public void setSectionNo(int sectionNo) {
		this.sectionNo = sectionNo;
	}
	public int getGameID() {
		return gameID;
	}
	public void setGameID(int gameID) {
		this.gameID = gameID;
	}
	
	
}
