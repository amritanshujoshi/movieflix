package io.amritanshu.api.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.amritanshu.api.entity.Genre;

@Repository
public class GenreRepositoryImpl implements GenreRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Genre findByName(String genreName) {
		TypedQuery<Genre> query = em.createNamedQuery("Genre.findByName", Genre.class);
		query.setParameter("pName", genreName);
		List<Genre> genres = query.getResultList();
		if (genres != null && genres.size() == 1) {
			return genres.get(0);
		}
		return null;
	}

	@Override
	public Genre create(Genre genre) {
		em.persist(genre);
		return genre;
	}

}
