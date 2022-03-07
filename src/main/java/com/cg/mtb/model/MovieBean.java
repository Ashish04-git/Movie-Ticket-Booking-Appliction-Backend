package com.cg.mtb.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="movie")
public class MovieBean {
	
	@Id
	private Integer movieId;
	
	private String movieName;
	
	@Column(name="movie_gen", length=20)
	private String movieGenre;
	
	@Column(name="movie_hrs", length=20)
	private String movieHours;
	
	@Column(name="movie_lang", length=20)
	private String language;
	
	@Column(name="movie_des", length=20)
	private String description;
	
	@ManyToOne
	private TheatreBean theatre;
	
	@OneToMany(mappedBy = "movie")
	@JsonIgnore
	private List<CustomerBean> customer= new ArrayList<CustomerBean>();
	
	
	@OneToOne(mappedBy = "movie")
	private ShowBean showbean;
	
	public MovieBean() {
		super();
	}
	
	public MovieBean(Integer movieId, String movieName, String movieGenre, String movieHours, String language,
			String description, TheatreBean theatre) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.movieGenre = movieGenre;
		this.movieHours = movieHours;
		this.language = language;
		this.description = description;
		this.theatre = theatre;
	}

	public Integer getMovieId() {
		return movieId;
	}
	
	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}
	
	public String getMovieName() {
		return movieName;
	}
	
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	
	public String getMovieGenre() {
		return movieGenre;
	}
	
	public void setMovieGenre(String movieGenre) {
		this.movieGenre = movieGenre;
	}
	
	public String getMovieHours() {
		return movieHours;
	}
	
	public void setMovieHours(String movieHours) {
		this.movieHours = movieHours;
	}
	
	public String getLanguage() {
		return language;
	}
	
	public void setLanguage(String language) {
		this.language = language;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
		
	}
	
	public TheatreBean getTheatre() {
		return theatre;
	}

	public void setTheatre(TheatreBean theatre) {
		this.theatre = theatre;
	}
	
}
