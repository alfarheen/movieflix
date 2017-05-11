package io.egen.movieflix.repository;

import java.util.List;

import io.egen.movieflix.entity.Movies;

public interface MoviesRepository {
	
	public List<Movies> findAll();
	public Movies findOne(String id);
	public Movies create(Movies movie);
	public Movies update(Movies movie);
	public void delete(Movies movie);
	public List<Movies> findByGenre(String genre);
	public List<Movies> findByYear(int year);
	public List<Movies> findByType(String type);
	public List<Movies> findTopRated(String type);
	public List<Movies> sortByYear();
	public List<Movies> sortByImdbRating();
	public List<Movies> sortByImdbVotes();
}
