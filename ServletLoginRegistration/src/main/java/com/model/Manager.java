package com.model;

public class Manager {
	private int mid;
	private String fname;
	private String lname;
	private String email;//unique
	private String password;
	public Manager(int mid, String fname, String lname, String email, String password) {
		super();
		this.mid=mid;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.password = password;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
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
