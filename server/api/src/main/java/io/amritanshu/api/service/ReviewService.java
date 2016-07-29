package io.amritanshu.api.service;

import java.util.List;

import io.amritanshu.api.entity.Review;

public interface ReviewService {

	public List<Review> findByMovieTitle(String movie);

	public Review create(Review review);
}
