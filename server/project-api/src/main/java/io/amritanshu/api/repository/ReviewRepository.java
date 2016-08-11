package io.amritanshu.api.repository;

import java.util.List;

import io.amritanshu.api.entity.Movie;
import io.amritanshu.api.entity.Review;

public interface ReviewRepository {

	public List<Review> findByMovie(Movie movie);
	
	public Double getAverageRating(Movie movie);

	public Review create(Review review);
}
