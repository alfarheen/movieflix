 	package io.egen.movieflix.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table
@NamedQueries({
	@NamedQuery(name="Ratings.findMovieRatings",query = "select r from Ratings r join r.movies m where m.movieId = :pMovieId"),
	@NamedQuery(name = "Ratings.AverageMovieRatings", query = "select AVG(r.rating) from Ratings r join r.movies m group by m ")
})
public class Ratings {
	
	@Id
	@GenericGenerator(name="customUUID" , strategy = "uuid2")
	@GeneratedValue(generator = "customUUID")
	private String id;
	
	private int rating; // Rating is out of 5 stars given for each movie
	
	//private String movieId;
	
	//private String userId;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToOne
	@JoinColumn(name = "userId")
	private Users users;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToOne
	@JoinColumn(name = "movieId")
	private Movies movies;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	public Movies getMovies() {
		return movies;
	}
	public void setMovies(Movies movies) {
		this.movies = movies;
	}
	
	@Override
	public String toString() {
		return "Ratings [id=" + id + ", rating=" + rating + ", users=" + users + ", movies=" + movies + "]";
	}
//	public String getMovieId() {
//		return movieId;
//	}
//	public void setMovieId(String movieId) {
//		this.movieId = movieId;
//	}
//	public String getUserId() {
//		return userId;
//	}
//	public void setUserId(String userId) {
//		this.userId = userId;
//	}

}