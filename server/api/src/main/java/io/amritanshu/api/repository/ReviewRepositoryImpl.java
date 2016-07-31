package io.amritanshu.api.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.amritanshu.api.entity.Review;

@Repository
public class ReviewRepositoryImpl implements ReviewRepository{
	
	@PersistenceContext
	private EntityManager em;

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
	public Review create(Review review) {
		em.persist(review);
		return review;
	}

}
