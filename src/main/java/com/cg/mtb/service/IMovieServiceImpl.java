package com.cg.mtb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.cg.mtb.exception.MovieException;
import com.cg.mtb.model.MovieBean;
import com.cg.mtb.repository.IMovieRepository;

@Service
public class IMovieServiceImpl implements IMovieService{
	
	@Autowired
	IMovieRepository dao;
	
	public MovieBean addMovie(MovieBean movie) throws MovieException {
		
		if(dao.existsById(movie.getMovieId())) {
			throw new MovieException("Movie already exist");}
		else {
		MovieBean movi = dao.save(movie);
		return movi;}
	}

	public MovieBean deleteMovie(int movieId) throws MovieException {
		if(dao.existsById(movieId)) {
			MovieBean movi = dao.findById(movieId).get();
			dao.deleteById(movi.getMovieId());
			return movi;
		}
		throw new MovieException("Movie not found");
		
	}

	public MovieBean updateMovie(MovieBean movie) throws MovieException {
		if(dao.existsById(movie.getMovieId())) {
			MovieBean movi= dao.save(movie);
			return movi;
		}
		throw new MovieException("Movie not found");
	}

	public MovieBean viewMovie(int movieid) throws MovieException {
		if(dao.existsById(movieid)) {
			Optional<MovieBean> opt= dao.findById(movieid);
			MovieBean movi = opt.get();
			return movi;
		}
		throw new MovieException("Movie not found");
	}
	
	public List<MovieBean> viewMovieList(){
		
		List<MovieBean> lis= dao.findAll();
		return lis;
	}
	
	public List<MovieBean> vieMovieList(int theatreId) throws MovieException{
		List<MovieBean> lis= dao.vieMovieList(theatreId);
		if(lis.size()>0)
			return lis;
		throw new MovieException("Movies not found");
		
	}



}
