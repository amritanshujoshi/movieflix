package io.amritanshu.api.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
@NamedQueries({ @NamedQuery(name = "Genre.findByName", query = "SELECT g FROM Genre g WHERE g.name=:pName") })
public class Genre {

	@Id
	@GenericGenerator(name = "customUUID", strategy = "uuid2")
	@GeneratedValue(generator = "customUUID")
	private String id;

	private String name;

	@ManyToMany(mappedBy = "genres")
	@LazyCollection(LazyCollectionOption.FALSE)
	@JsonIgnore
	private Set<Movie> movies;

	public Genre() {

	}

	public Genre(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Movie> getMovies() {
		return movies;
	}

	public void addMovie(Movie movie) {
		if (!getMovies().contains(movie)) {
			getMovies().add(movie);
		}
		if (!movie.getGenres().contains(this)) {
			movie.getGenres().add(this);
		}
	}

}
