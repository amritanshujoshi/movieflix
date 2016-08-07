package io.amritanshu.api.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.amritanshu.api.entity.Genre;
import io.amritanshu.api.entity.Movie;
import io.amritanshu.api.exception.MovieExistsException;
import io.amritanshu.api.exception.MovieNotFoundException;
import io.amritanshu.api.repository.GenreRepository;
import io.amritanshu.api.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	MovieRepository movieRepository;

	@Autowired
	GenreRepository genreRepository;

	@Override
	public List<Movie> findAll() {
		return movieRepository.findAll();
	}

	@Override
	public Movie findOne(String id) {
		Movie existing = movieRepository.findOne(id);
		if (existing == null) {
			throw new MovieNotFoundException("User with id:" + id + " not found.");
		}
		return existing;
	}

	@Override
	public Movie findByTitle(String movie) {
		Movie existing = movieRepository.findByTitle(movie);
		if (existing == null) {
			throw new MovieNotFoundException("Movie with name: " + movie + " not found");
		}
		return existing;
	}

	@Override
	public List<Movie> findByYear(int year) {
		return movieRepository.findByYear(year);
	}

	@Override
	public List<Movie> findByType(String type) {
		return movieRepository.findByType(type);
	}
	
	@Override
	public List<Movie> findByGenre(String name) {
		return movieRepository.findByGenre(name);
	}

	@Override
	public List<Movie> findTopRated(String type) {
		return movieRepository.findTopRated(type);
	}

	@Override
	public List<Movie> findTopVoted(String type) {
		return movieRepository.findTopVoted(type);
	}

	@Override
	@Transactional
	public Movie create(Movie movie) {
		Movie existingMovie = movieRepository.findByTitle(movie.getTitle());
		if (existingMovie != null) {
			throw new MovieExistsException("Movie already exists: " + movie.getTitle());
		}
		Set<Genre> genres = movie.getGenres();
		for (Genre genre: genres) {
			Genre existingGenre = genreRepository.findByName(genre.getName());
			if (existingGenre == null) {
				genreRepository.create(genre);
			}
		}
		return movieRepository.create(movie);
	}

	@Override
	@Transactional
	public Movie update(String title, Movie movie) {
		Movie existing = movieRepository.findByTitle(title);
		if (existing == null) {
			throw new MovieNotFoundException("Movie with title: " + title + " not found");
		}
		return movieRepository.update(movie);
	}

	@Override
	@Transactional
	public void delete(String movie) {
		Movie existing = movieRepository.findByTitle(movie);
		if (existing == null) {
			throw new MovieNotFoundException("Movie with title: " + movie + " not found");
		}
		movieRepository.delete(existing);
	}

}
