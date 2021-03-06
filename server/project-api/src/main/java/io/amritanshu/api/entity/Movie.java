package io.amritanshu.api.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table
@NamedQueries({ @NamedQuery(name = "Movie.findAll", query = "SELECT m FROM Movie m ORDER BY m.title ASC"),
		@NamedQuery(name = "Movie.findByTitle", query = "SELECT m FROM Movie m WHERE m.title=:pTitle"),
		@NamedQuery(name = "Movie.findByYear", query = "SELECT m FROM Movie m WHERE m.year=:pYear"),
		@NamedQuery(name = "Movie.findByType", query = "SELECT m FROM Movie m WHERE m.type=:pType"),
		@NamedQuery(name = "Movie.findByGenre", query = "SELECT m FROM Movie m JOIN m.genres g WHERE g.name=:pGenreName"),
		@NamedQuery(name = "Movie.findTopRated", query = "SELECT m FROM Movie m WHERE type=:pType ORDER BY imdbRating desc"),
		@NamedQuery(name = "Movie.findTopVoted", query = "SELECT m FROM Movie m WHERE type=:pType ORDER BY imdbVotes desc") })
public class Movie {

	@Id
	@GenericGenerator(name = "customUUID", strategy = "uuid2")
	@GeneratedValue(generator = "customUUID")
	private String id;

	private String title;
	private int year;

	private String rated;

	private String released;
	private String runtime;

	@Transient
	private Set<String> genreList;

	@ManyToMany(cascade=CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private Set<Genre> genres;

	private String director;

	@Column(length = 1000)
	private String writer;

	@Column(length = 1000)
	private String actor;

	@Column(length = 1000)
	private String plot;

	private String awards;
	private float imdbRating;
	private int imdbVotes;
	private String imdbID;
	private String type;

	public String getId() {
		return id;
	}

	public void setId(String movieId) {
		this.id = movieId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getRated() {
		return rated;
	}

	public void setRated(String rated) {
		this.rated = rated;
	}

	public String getReleased() {
		return released;
	}

	public void setReleased(String released) {
		this.released = released;
	}

	public String getRuntime() {
		return runtime;
	}

	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}

	public Set<String> getGenreList() {
		return genreList;
	}

	public Set<Genre> getGenres() {
		return genres;
	}

	public void addGenres(Genre genre) {
		if (!getGenres().contains(genre)) {
			getGenres().add(genre);
		}
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public String getPlot() {
		return plot;
	}

	public void setPlot(String plot) {
		this.plot = plot;
	}

	public String getAwards() {
		return awards;
	}

	public void setAwards(String awards) {
		this.awards = awards;
	}

	public float getImdbRating() {
		return imdbRating;
	}

	public void setImdbRating(float imdbRating) {
		this.imdbRating = imdbRating;
	}

	public int getImdbVotes() {
		return imdbVotes;
	}

	public void setImdbVotes(int imdbVotes) {
		this.imdbVotes = imdbVotes;
	}

	public String getImdbID() {
		return imdbID;
	}

	public void setImdbID(String imdbID) {
		this.imdbID = imdbID;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", Title=" + title + ", year=" + year + ", released=" + released + ", runtime="
				+ runtime + ", Director=" + director + ", Writer=" + writer + ", Actors=" + actor + ", Plot:" + plot
				+ ", Awards & Nominations:" + awards + ", IMDB Rating:" + imdbRating + ", IMDB ID:" + imdbID
				+ ", IMDB Votes:" + imdbVotes + ", Type:" + type + "]";
	}
}