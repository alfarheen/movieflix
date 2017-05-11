package io.egen.movieflix.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table
@NamedQueries({ @NamedQuery(name = "Movies.findAll", query = "SELECT m FROM Movies m ORDER BY m.title ASC"),
		@NamedQuery(name = "Movies.findByYear", query = "SELECT m FROM Movies m WHERE m.year=:pYear"),
		@NamedQuery(name = "Movies.findById", query = "SELECT m FROM Movies m WHERE m.id=:pId"),
	    @NamedQuery(name = "Movies.findByType", query = "SELECT m FROM Movies m WHERE m.type=:pType"),
		@NamedQuery(name = "Movies.findByGenre", query = "SELECT m FROM Movies m WHERE m.genre=:pGenre"),
		@NamedQuery(name = "Movies.findTopRated", query = "SELECT m FROM Movies m WHERE m.type=:pType and m.imdbRating > 4"),
		@NamedQuery(name = "Movies.sortByYear", query = "Select m from Movies m order by m.year DESC"),
		@NamedQuery(name = "Movies.sortByImdbRating", query = "SELECT m FROM Movies m order by m.imdbRating DESC"),
        @NamedQuery(name = "Movies.sortByImdbVotes", query = "SELECT m FROM Movies m order by m.imdbVotes DESC"),
		 })
public class Movies {

	@Id
	@GenericGenerator(name = "customUUID", strategy = "uuid2")
	@GeneratedValue(generator = "customUUID")
	private String movieId;

	private String title;
	private String rated;
	private String released;
	private String runTime;
	private String plot;
	private String language;
	private String poster;
	private String genre;
	private String director;
	private String writer;
	private String actors;
	private String country;
	private String awards;
	private String type;
	private String imdbID;
    private int metaScore;	
	private int imdbRating;
	private int imdbVotes;
	private int year;

/*	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private Ratings ratings;
	
	@OneToMany(cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Comments> comments;
*/
	
	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRated() {
		return rated;
	}

	public void setRated(String rated) {
		this.rated = rated;
	}

	public String getRunTime() {
		return runTime;
	}

	public void setRunTime(String runTime) {
		this.runTime = runTime;
	}

	public String getPlot() {
		return plot;
	}

	public void setPlot(String plot) {
		this.plot = plot;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getActors() {
		return actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAwards() {
		return awards;
	}

	public void setAwards(String awards) {
		this.awards = awards;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getImdbID() {
		return imdbID;
	}

	public void setImdbID(String imdbID) {
		this.imdbID = imdbID;
	}

	public int getMetaScore() {
		return metaScore;
	}

	public void setMetaScore(int metaScore) {
		this.metaScore = metaScore;
	}

	public int getImdbRating() {
		return imdbRating;
	}

	public void setImdbRating(int imdbRating) {
		this.imdbRating = imdbRating;
	}

	public int getImdbVotes() {
		return imdbVotes;
	}

	public void setImdbVotes(int imdbVotes) {
		this.imdbVotes = imdbVotes;
	}
	
	@Override
	public String toString() {
		return "Movies [movieId=" + movieId + ", title=" + title + ", rated=" + rated + ", runTime=" + runTime
				+ ", plot=" + plot + ", language=" + language + ", poster=" + poster + ", genre="+ genre + ", director" + director +
	             ", writer"+ director + ", writer"+ writer +", actors" + actors + ", country" + country +", awards"+ awards+ ", type"+type
				+ ", imdbRating"+ imdbRating+ ", imdbVotes"+ imdbVotes +", year=" + year + "]";
	}

}
