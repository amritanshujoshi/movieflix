package io.amritanshu.api.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import io.amritanshu.api.entity.Movie;
import io.amritanshu.api.entity.Review;

@Repository
public class ReviewRepositoryImpl implements ReviewRepository{
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	MovieRepository movieRepository;
	
	@Autowired
	UserRepository userRepository;

	@Override
	public List<Review> findByMovie(Movie movie) {
		TypedQuery<Review> query = em.createNamedQuery("Review.findByMovieTitle", Review.class);
		query.setParameter("pMovie", movie);
		return query.getResultList();
	}
	
	@Override
	public Double getAverageRating(Movie movie) {
		Query query = em.createQuery("SELECT AVG(r.rating) from Review r WHERE r.movie=:pMovie");
		query.setParameter("pMovie", movie);
		return (Double)query.getSingleResult();
	}

	@Override
	public Review create(Review review) {
		em.persist(review);
		return review;
	}	

}
