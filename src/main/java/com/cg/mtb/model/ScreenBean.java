
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
@Table(name="screen_tabel")
public class ScreenBean {
	
	@Id
	@Column(name="screen_Id")
	private Integer screenId;
	
	@ManyToOne
	private TheatreBean theatre;
	
	@Column(name="screen_Name",length=25)
	private String screenName;
	
	@Column(name = "theaterrows")
	private Integer rows;
	
	@Column(name = "theatrecolumns")
	private Integer columns;
	
	@OneToMany(mappedBy = "screen")
	@JsonIgnore
	private List<ShowBean> showList= new ArrayList<ShowBean>();

	public ScreenBean(Integer screenId, TheatreBean theatre, String screenName, Integer rows, Integer columns) {
		super();
		this.screenId = screenId;
		this.theatre = theatre;
		this.screenName = screenName;
		this.rows = rows;
		this.columns = columns;
	}

	public ScreenBean() {
		super();
	}

	public Integer getScreenId() {
		return screenId;
	}

	public void setScreenId(Integer screenId) {
		this.screenId = screenId;
	}

	public TheatreBean getTheatre() {
		return theatre;
	}

	public void setTheatre(TheatreBean theatre) {
		this.theatre = theatre;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public Integer getColumns() {
		return columns;
	}

	public void setColumns(Integer columns) {
		this.columns = columns;
	}

	
}
