package io.amritanshu.api.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.amritanshu.api.entity.Movie;

@Repository
public class MovieRepositoryImpl implements MovieRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Movie> findAll() {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findAll", Movie.class);
		return query.getResultList();
	}
	
	@Override
	public Movie findOne(String id) {
		return em.find(Movie.class, id);
	}

	@Override
	public Movie findByTitle(String title) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findByTitle", Movie.class);
		query.setParameter("pTitle", title);
		List<Movie> movies = query.getResultList();
		if (movies != null && movies.size() == 1) {
			return movies.get(0);
		}
		return null;
	}
	
	@Override
	public List<Movie> findByYear(int year) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findByYear", Movie.class);
		query.setParameter("pYear", year);
		return query.getResultList();
	}
	
	@Override
	public List<Movie> findByType(String type) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findByType", Movie.class);
		query.setParameter("pType", type);
		return query.getResultList();
	}
	
	@Override
	public List<Movie> findTopRated(String type) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findTopRated", Movie.class);
		query.setParameter("pType", type);
		return query.getResultList();
	}
	
	@Override
	public List<Movie> findTopVoted(String type) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findTopVoted", Movie.class);
		query.setParameter("pType", type);
		return query.getResultList();
	}

	@Override
	public Movie create(Movie movie) {
		em.persist(movie);
		return movie;
	}

	@Override
	public Movie update(Movie movie) {
		return em.merge(movie);
	}

	@Override
	public void delete(Movie movie) {
		em.remove(movie);
	}		

}
