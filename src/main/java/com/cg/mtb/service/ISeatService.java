package com.cg.mtb.service;

import java.util.List;

import com.cg.mtb.exception.SeatException;
import com.cg.mtb.model.SeatBean;

public interface ISeatService {
	
	public SeatBean addBooking(SeatBean seat) throws SeatException;
	
	public SeatBean cancelSeatBooking(int id) throws SeatException ;
	
	public List<SeatBean> getAllSeats();
	
	public SeatBean blockSeat(SeatBean seat) throws SeatException;

}
