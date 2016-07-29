package io.amritanshu.api.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import io.amritanshu.api.entity.Review;

public class ReviewRepositoryImpl implements ReviewRepository{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Review> findByMovieTitle(String movie) {
		TypedQuery<Review> query = em.createNamedQuery("Review.findByMovieTitle", Review.class);
		return query.getResultList();
	}

	@Override
	public Review create(Review review) {
		em.persist(review);
		return review;
	}

}
