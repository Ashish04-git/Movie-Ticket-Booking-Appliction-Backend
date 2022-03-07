package com.cg.mtb.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="shows_tbl")
public class ShowBean {
	@Id
	private Integer showId;
	
	@Column(name="show_st")
	private LocalDateTime showStartTime;
	
	@Column(name="show_end")
	private LocalDateTime showEndTime;
	
	@OneToOne	
	private MovieBean movie;
	
	@OneToOne(mappedBy = "show")
	@JsonIgnore
	private TicketBookingBean ticketbook;

	@ManyToOne
	private ScreenBean screen;
	
	public ShowBean() {
		super();
	}

	
	public ShowBean(Integer showId, LocalDateTime showStartTime, LocalDateTime showEndTime, MovieBean movie,
			ScreenBean screen) {
		super();
		this.showId = showId;
		this.showStartTime = showStartTime;
		this.showEndTime = showEndTime;
		this.movie = movie;
		this.screen = screen;
	}

	public Integer getShowId() {
		return showId;
	}


	public void setShowId(Integer showId) {
		this.showId = showId;
	}


	public LocalDateTime getShowStartTime() {
		return showStartTime;
	}


	public void setShowStartTime(LocalDateTime showStartTime) {
		this.showStartTime = showStartTime;
	}


	public LocalDateTime getShowEndTime() {
		return showEndTime;
	}


	public void setShowEndTime(LocalDateTime showEndTime) {
		this.showEndTime = showEndTime;
	}


	public MovieBean getMovie() {
		return movie;
	}


	public void setMovie(MovieBean movie) {
		this.movie = movie;
	}


	public ScreenBean getScreens() {
		return screen;
	}

	public void setScreens(ScreenBean screens) {
		this.screen = screens;
	}


}
