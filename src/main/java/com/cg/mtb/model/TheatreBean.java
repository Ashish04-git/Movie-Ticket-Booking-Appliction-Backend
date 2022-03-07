package com.cg.mtb.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="theatre_tbl")
public class TheatreBean {
	
	@Id
	@Column(name="the_id")
	private Integer theatreId;
	
	@Column(name="thename", length=20)
	private String theatreName;
	
	@Column(name="thecity", length=20)
	private String theatreCity;
	
	@OneToMany(mappedBy = "theatre")
	@JsonIgnore
	private List<MovieBean> listOfMovies= new ArrayList<MovieBean>();
	
	@OneToMany(mappedBy = "theatre")
	@JsonIgnore
	private List<ScreenBean> listOfScreens= new ArrayList<ScreenBean>();
	
	@Column(name="man_name", length=20)
	private String managerName;
	
	@Column(name="man_con")
	private String managerContact;
	
	
	public TheatreBean() {
		super();
	}

	public TheatreBean(Integer theatreId, String theatreName,
		String managerName, String managerContact) {
	super();
	this.theatreId = theatreId;
	this.theatreName = theatreName;
	this.managerName = managerName;
	this.managerContact = managerContact;
	}
	

	public Integer getTheatreId() {
		return theatreId;
	}
	

	public void setTheatreId(Integer theatreId) {
		this.theatreId = theatreId;
	}

	public String getTheatreName() {
		return theatreName;
	}

	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getManagerContact() {
		return managerContact;
	}

	public void setManagerContact(String managerContact) {
		this.managerContact = managerContact;
	}
	
}
