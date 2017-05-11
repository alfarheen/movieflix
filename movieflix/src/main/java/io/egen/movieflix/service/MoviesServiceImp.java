package io.egen.movieflix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.movieflix.entity.Movies;
import io.egen.movieflix.exception.MovieNotFoundException;
import io.egen.movieflix.repository.MoviesRepository;

@Service
public class MoviesServiceImp implements MoviesService {

	@Autowired
	MoviesRepository repository;
	
	@Override
	public List<Movies> findAll() {
		return repository.findAll();
	}

	@Override
	public Movies findOne(String id) {
		Movies existing = repository.findOne(id);
		if (existing == null) {
			throw new MovieNotFoundException("Movie not found");
		}
		return existing;
	}

	@Override
	@Transactional
	public Movies create(Movies movie) {
		return repository.create(movie);
	}

	@Override
	@Transactional
	public Movies update(String id, Movies movie) {
		Movies existing = repository.findOne(id);
		if (existing == null) {
			throw new MovieNotFoundException("Movie not found");
		}
		return repository.update(movie);
	}

	@Override
	@Transactional
	public void delete(String id) {
		Movies existing = repository.findOne(id);
		if (existing == null) {
			throw new MovieNotFoundException("Movie not found");
		}
		repository.delete(existing);
	}

	@Override
	public List<Movies> findByGenre(String genre) {
		return repository.findByGenre(genre);
	}

	@Override
	public List<Movies> findByYear(int year) {
		return repository.findByYear(year);
	}

	@Override
	public List<Movies> findByType(String type) {
		return repository.findByType(type);
	}
	
	@Override
	public List<Movies> findTopRated(String type) {
		return repository.findTopRated(type);
	}

	@Override
	public List<Movies> sortByYear() {
		return repository.sortByYear();
	}

	@Override
	public List<Movies> sortByImdbRating() {
		return repository.sortByImdbRating();
	}
	
	@Override
	public List<Movies> sortByImdbVotes() {
		return repository.sortByImdbVotes();
	}

}
