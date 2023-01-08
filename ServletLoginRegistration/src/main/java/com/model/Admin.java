package com.model;

public class Admin {
	private int aid;
	private String fname;
	private String lname;
	private String email;//unique
	private String password;
	public Admin(int aid, String fname, String lname, String email, String password) {
		super();
		this.aid = aid;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.password = password;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
