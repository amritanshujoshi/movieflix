package io.amritanshu.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.amritanshu.api.entity.Movie;
import io.amritanshu.api.service.MovieService;

@RestController
@RequestMapping(path = "movies")
public class MovieController {

	@Autowired
	MovieService movieService;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> findAll() {
		return movieService.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, path = "{title}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movie findByTitle(@PathVariable("title") String movie) {
		return movieService.findByTitle(movie);
	}

	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movie create(@RequestBody Movie movie) {
		return movieService.create(movie);
	}

	@RequestMapping(method = RequestMethod.PUT, path = "{title}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movie update(@PathVariable("title") String title, @RequestBody Movie movie) {
		return movieService.update(title, movie);
	}

	@RequestMapping(method = RequestMethod.DELETE, path = "{title}")
	public void delete(@PathVariable("title") String title) {
		movieService.delete(title);
	}
}