package io.egen.movieflix.service;

import java.util.List;

import javax.transaction.Transactional;

import io.egen.movieflix.entity.Comments;
import io.egen.movieflix.entity.Movies;
import io.egen.movieflix.entity.Users;
import io.egen.movieflix.exception.MovieNotFoundException;
import io.egen.movieflix.repository.CommentRepository;
import io.egen.movieflix.repository.MoviesRepository;
import io.egen.movieflix.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImp implements CommentService{
	
	@Autowired
	CommentRepository repository;
	@Autowired
	MoviesRepository mRepo;
	@Autowired
	UserRepository uRepo;

	@Override
	@Transactional
	public Comments add(String movieId,String userId, Comments comments) {
		Movies movie = mRepo.findOne(movieId);
		Users user = uRepo.findById(userId);
		comments.setMovies(movie);
		comments.setUsers(user);
		return repository.add(comments);
	}

	@Override
	public List<Comments> findByMovie(String movieId) {
		return (List<Comments>) repository.findByMovie(movieId);
	}
	
	@Override
	public Comments findById(String id) {
		return repository.findById(id);
	}

	@Override
	@Transactional
	public Comments update(String movieId, Comments comment) {
		Movies movie = mRepo.findOne(movieId);
		Users user = uRepo.findById(comment.getUsers().getUserId());
		if(movie == null){
			throw new MovieNotFoundException("Movie not found");
		}
		comment.setMovies(movie);
		comment.setUsers(user);
		return repository.update(comment);
	}

	@Override
	@Transactional
	public void delete(String id) {
		Comments comment = repository.findById(id);
		repository.delete(comment);
		
	}

}

