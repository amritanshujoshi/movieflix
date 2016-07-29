package io.amritanshu.api.repository;

import java.util.List;

import io.amritanshu.api.entity.Review;

public interface ReviewRepository {

	public List<Review> findByMovieTitle(String movie);

	public Review create(Review review);
}
