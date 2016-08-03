package io.amritanshu.api.service;

import java.util.List;

import io.amritanshu.api.entity.Review;

public interface ReviewService {

	public List<Review> findByMovieId(String movieId);

	public Review create(String movie_id, String user_id, Review review);
}
