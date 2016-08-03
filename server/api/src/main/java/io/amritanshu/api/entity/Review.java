package io.amritanshu.api.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
@NamedQueries({
	@NamedQuery(name = "Review.findByMovieId", query = "SELECT r from Review r WHERE r.movie.id=:pMovieId")
})
public class Review {

	@Id
	@GenericGenerator(name = "customUUID", strategy = "uuid2")
	@GeneratedValue(generator = "customUUID")
	private String id;

	@ManyToOne
	@JoinColumn(name="user_id", referencedColumnName="id")
	private User user;

	@ManyToOne
	@JoinColumn(name="movie_id", referencedColumnName="id")
	private Movie movie;

	private int rating;
	private String comment;

	public String getReviewId() {
		return id;
	}

	public void setReviewId(String reviewId) {
		this.id = reviewId;
	}

	public User getuser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
