package com.model;

public class Games {
	private int gameID;
	private double price;
	private String gameName;
	public Games(int gameID, double price, String gameName) {
		super();
		this.gameID = gameID;
		this.price = price;
		this.gameName = gameName;
	}
	public int getGameID() {
		return gameID;
	}
	public void setGameID(int gameID) {
		this.gameID = gameID;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getGameName() {
		return gameName;
	}
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
	
}
