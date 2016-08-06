package io.amritanshu.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.amritanshu.api.entity.Movie;
import io.amritanshu.api.entity.Review;
import io.amritanshu.api.entity.User;
import io.amritanshu.api.repository.ReviewRepository;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	ReviewRepository reviewRepository;
	
	@Autowired
	MovieService movieService;
	
	@Autowired
	UserService userService;
	
	@Override
	public List<Review> findByMovieTitle(String title) {
		Movie movie = movieService.findByTitle(title);
		return reviewRepository.findByMovie(movie);
	}
	
	@Override
	public Double getAverageRating(String title) {
		Movie movie = movieService.findByTitle(title);
		return reviewRepository.getAverageRating(movie);
	}

	@Override
	@Transactional
	public Review create(String mId, String uId, Review review) {
		Movie m = movieService.findOne(mId);
		User u = userService.findOne(uId);
		
		review.setMovie(m);
		review.setUser(u);
		return reviewRepository.create(review);
	}	

}
