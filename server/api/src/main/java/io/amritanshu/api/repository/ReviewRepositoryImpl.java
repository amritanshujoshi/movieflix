package io.amritanshu.api.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import io.amritanshu.api.entity.Movie;
import io.amritanshu.api.entity.Review;
import io.amritanshu.api.entity.User;
import io.amritanshu.api.exception.MovieNotFoundException;
import io.amritanshu.api.exception.UserNotFoundException;

@Repository
public class ReviewRepositoryImpl implements ReviewRepository{
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	MovieRepository movieRepository;
	
	@Autowired
	UserRepository userRepository;

	@Override
	public List<Review> findByMovieId(String movieId) {
		TypedQuery<Review> query = em.createNamedQuery("Review.findByMovieId", Review.class);
		query.setParameter("pMovieId", movieId);
		List<Review> reviews = query.getResultList();
		if(reviews != null) {
			return reviews;
		}
		return null;
	}

	@Override
	public Review create(String movie_id, String user_id, Review review) {
		Movie mExisting = movieRepository.findOne(movie_id);
		User uExisting = userRepository.findOne(user_id);
		if(mExisting == null) {
			throw new MovieNotFoundException("");
		}
		if(uExisting == null) {
			throw new UserNotFoundException("");
		}
		mExisting.getReviews().add(review);
		uExisting.getReviews().add(review);
		review.setUser(uExisting);
		review.setMovie(mExisting);
		em.persist(review);
		return review;
	}

}
