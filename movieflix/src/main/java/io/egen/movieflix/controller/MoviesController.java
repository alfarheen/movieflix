package io.egen.movieflix.controller;


import io.egen.movieflix.entity.Movies;
import io.egen.movieflix.service.MoviesService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController      
@RequestMapping(path="movies")
public class MoviesController {

	@Autowired
	MoviesService service;
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movies> findAll(){
		return service.findAll();
	}
	
	@RequestMapping(method = RequestMethod.GET,path="/findByGenre/{genre}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movies> findByGenre(@PathVariable("genre") String genre) {
		return service.findByGenre(genre);
	}
	
	@RequestMapping(method = RequestMethod.GET,path="/findByYear/{year}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movies> findByYear(@PathVariable("year") int year) {
		return service.findByYear(year);
	}
	
	@RequestMapping(method = RequestMethod.GET,path="/findByType/{type}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movies> findByType(@PathVariable("type") String type) {
		return service.findByType(type);
	}
	
	@RequestMapping(method = RequestMethod.GET,path="/findTopRated/{type}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movies> findTopRated(@PathVariable("type") String type) {
		return service.findTopRated(type);
	}
	
	
	@RequestMapping(method = RequestMethod.GET,path="/sortByYear",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movies> sortByYear() {
		return service.sortByYear();
	}
	
	@RequestMapping(method = RequestMethod.GET,path="/sortByImdbRating",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movies> sortByImdbRating() {
		return service.sortByImdbRating();
	}
	
	@RequestMapping(method = RequestMethod.GET,path="/sortByImdbVotes",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movies> sortByImdbVotes() {
		return service.sortByImdbVotes();
	}
	
	
	

	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movies create(@RequestBody Movies movie){
		return service.create(movie);
	}
	
	@RequestMapping(method = RequestMethod.PUT, path="{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movies update(@PathVariable("id") String movId, @RequestBody Movies movie){
		return service.update(movId, movie);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, path="{id}")
	public void delete(@PathVariable("id") String movId){
		service.delete(movId);
	}
}

