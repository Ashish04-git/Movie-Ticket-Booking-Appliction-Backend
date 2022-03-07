package com.cg.mtb.service;

import java.time.LocalDateTime;
import java.util.List;

import com.cg.mtb.exception.ShowException;
import com.cg.mtb.model.ShowBean;

public interface IShowService {
	
	public ShowBean addShow(ShowBean show) throws ShowException;
	
	public ShowBean deleteShow(int id) throws ShowException;
	
	public ShowBean updateShow(ShowBean show) throws ShowException;
	
	public List<ShowBean> viewAllShows();
	
	public List<ShowBean> viewShowList(int theatreId) throws ShowException;
	
	public ShowBean viewShow(ShowBean show) throws ShowException;
	
	public List<ShowBean> viewShowList(LocalDateTime Date) throws ShowException;

}
