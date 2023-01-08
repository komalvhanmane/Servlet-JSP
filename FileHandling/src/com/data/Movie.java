package com.data;

public class Movie {
	String id;
	String name;
	String description;
	String popularity;
	String genres;
	String cast;
	public Movie(String id, String name, String popularity, String genres, String cast) {
		super();
		this.id = id;
		this.name = name;
		this.popularity = popularity;
		this.genres = genres;
		this.cast = cast;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
