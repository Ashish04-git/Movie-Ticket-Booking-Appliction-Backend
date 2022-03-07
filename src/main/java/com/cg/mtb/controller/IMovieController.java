package com.cg.mtb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.mtb.exception.MovieException;
import com.cg.mtb.model.MovieBean;
import com.cg.mtb.service.IMovieServiceImpl;

@CrossOrigin("*")
@RestController
@RequestMapping("/movie")
public class IMovieController {
	@Autowired
	IMovieServiceImpl service;
	
	@PostMapping("/add")
	public MovieBean addMovie(@RequestBody MovieBean movie) throws MovieException {
		MovieBean movi= service.addMovie(movie);
		return movi;
	}

	@DeleteMapping("/delete/{id}")
	public MovieBean deleteMovie(@PathVariable("id") int movieId) throws MovieException {
		
		MovieBean movi= service.deleteMovie(movieId);
		return movi;
	}
	
	@PutMapping("/update")
	public MovieBean updateMovie(@RequestBody MovieBean movie) throws MovieException{
		

			MovieBean movi= service.updateMovie(movie);
			return movi;
	}
	

	@GetMapping("/movieby/{id}")
	public MovieBean viewMovie(@PathVariable("id") int id) throws MovieException{
		

			MovieBean movi= service.viewMovie(id);
			return movi;

	}

	@GetMapping("/list")
	public List<MovieBean> getAllMovies(){
		List<MovieBean> lis= service.viewMovieList();
		return lis;
	}
	
	@GetMapping("/movietheid/{id}")
	public List<MovieBean> viewMovieList(@PathVariable("id") int theatreId) throws MovieException{
		
		List<MovieBean> lis= service.vieMovieList(theatreId);
		return lis;
	}

}
