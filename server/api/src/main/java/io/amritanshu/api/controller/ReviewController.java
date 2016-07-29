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
	
	@RequestMapping(method = RequestMethod.GET, path = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Review> findByMovieId(@PathVariable("id") String movieId) {
		return reviewService.findByMovieId(movieId);
	}
	
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Review create(@RequestBody Review review) {
		return reviewService.create(review);
	}

}
