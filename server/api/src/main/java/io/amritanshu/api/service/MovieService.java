package io.amritanshu.api.service;

import java.util.List;

import io.amritanshu.api.entity.Movie;

public interface MovieService {
	
	public List<Movie> findAll();
	
	public Movie findByTitle(String movie);
	
	public Movie create(Movie movie);
	
	public Movie update(String title, Movie movie);
	
	public void delete(String movie);

}