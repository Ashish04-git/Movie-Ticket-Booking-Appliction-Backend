package com.cg.mtb.service;

import java.util.List;

import com.cg.mtb.exception.MovieException;
import com.cg.mtb.model.MovieBean;

public interface IMovieService {
	
	
	public MovieBean addMovie(MovieBean movie) throws MovieException;
	
	public MovieBean deleteMovie(int movieId) throws MovieException;
	
	public MovieBean updateMovie(MovieBean movie) throws MovieException;
	
	
	public MovieBean viewMovie(int movieid) throws MovieException;
	
	public List<MovieBean> viewMovieList();
	
	public List<MovieBean> vieMovieList(int theatreId) throws MovieException;
	
	
	

}
