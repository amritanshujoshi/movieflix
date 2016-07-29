package io.amritanshu.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import io.amritanshu.api.entity.Review;
import io.amritanshu.api.repository.ReviewRepository;

public class ReviewServiceImpl implements ReviewService {

	@Autowired
	ReviewRepository reviewRepository;
	
	@Override
	public List<Review> findByMovieTitle(String movie) {
		return reviewRepository.findByMovieTitle(movie);
	}

	@Override
	public Review create(Review review) {
		return reviewRepository.create(review);
	}

}
