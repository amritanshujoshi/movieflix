package io.amritanshu.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.amritanshu.api.entity.Review;
import io.amritanshu.api.service.ReviewService;

@RestController
@RequestMapping(path = "reviews")
public class ReviewController {
	
	@Autowired
	ReviewService reviewService;
	
	@RequestMapping(method = RequestMethod.GET, path = "{title}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Review> findByMovieTitle(@PathVariable("title") String movie) {
		return reviewService.findByMovieTitle(movie);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "averageRating/{title}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Double getAverageRating(@PathVariable("title") String movie) {
		return reviewService.getAverageRating(movie);
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "{movie_id}/{user_id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Review create(@PathVariable("movie_id") String movie_Id, @PathVariable("user_id") String user_Id, @RequestBody Review review) {
		return reviewService.create(movie_Id, user_Id, review);
	}

}
