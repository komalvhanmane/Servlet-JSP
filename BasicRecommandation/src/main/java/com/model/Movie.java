package com.model;

public class Movie {
	private String id;
	private  String name;
	private String popularity;
	private String genres;
	private String cast;
	public Movie(String id, String name, String popularity, String genres, String cast) {
		super();
		this.id = id;
		this.name = name;
		this.popularity = popularity;
		this.genres = genres;
		this.cast = cast;
	}
	public Movie(String id,String name) {
		this.id = id;
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPopularity() {
		return popularity;
	}
	public void setPopularity(String popularity) {
		this.popularity = popularity;
	}
	public String getGenres() {
		return genres;
	}
	public void setGenres(String genres) {
		this.genres = genres;
	}
	public String getCast() {
		return cast;
	}
	public void setCast(String cast) {
		this.cast = cast;
	}
	
	
	
}
