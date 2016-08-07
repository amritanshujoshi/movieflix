package io.amritanshu.api.service;

import java.util.List;

import io.amritanshu.api.entity.Movie;

public interface MovieService {

	public List<Movie> findAll();

	public Movie findOne(String id);

	public Movie findByTitle(String movie);
	
	public List<Movie> findByYear(int year);
	
	public List<Movie> findByType(String type);
	
	public List<Movie> findByGenre(String name);
	
	public List<Movie> findTopRated(String type);
	
	public List<Movie> findTopVoted(String type);
	
	public Movie create(Movie movie);

	public Movie update(String title, Movie movie);

	public void delete(String movie);

}