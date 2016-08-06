package io.amritanshu.api.repository;

import java.util.List;

import io.amritanshu.api.entity.Movie;

public interface MovieRepository {

	public List<Movie> findAll();
	
	public Movie findOne(String id);

	public Movie findByTitle(String title);
	
	public List<Movie> findByYear(int year);
	
	public List<Movie> findByType(String type);
	
	public List<Movie> findTopRated(String type);
	
	public List<Movie> findTopVoted(String type);

	public Movie create(Movie movie);

	public Movie update(Movie movie);

	public void delete(Movie movie);				
}