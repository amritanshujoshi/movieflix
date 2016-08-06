package io.amritanshu.api.service;

import java.util.List;

import io.amritanshu.api.entity.Review;

public interface ReviewService {

	public List<Review> findByMovieTitle(String movie);
	
	public Double getAverageRating(String title);

	public Review create(String mId, String uId, Review review);	
}
