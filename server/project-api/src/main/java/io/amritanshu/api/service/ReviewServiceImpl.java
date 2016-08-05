package io.amritanshu.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.amritanshu.api.entity.Review;
import io.amritanshu.api.repository.ReviewRepository;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	ReviewRepository reviewRepository;
	
	@Override
	public List<Review> findByMovieId(String movieId) {
		return reviewRepository.findByMovieId(movieId);
	}

	@Override
	@Transactional
	public Review create(String movie_id, String user_id, Review review) {
		return reviewRepository.create(movie_id, user_id, review);
	}

}
