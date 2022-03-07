package com.cg.mtb.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.mtb.exception.BookingException;
import com.cg.mtb.model.TicketBookingBean;

public interface IBookingService {
	
	public TicketBookingBean addBooking(TicketBookingBean booking) throws BookingException;
	
	public TicketBookingBean updateBooking(TicketBookingBean booking) throws BookingException;

	public TicketBookingBean cancelBooking(int id) throws BookingException;
	
	public List<TicketBookingBean> getAllBookings();
	
	public List<TicketBookingBean> showAllBookings(int movieid) throws BookingException;
	
	public double calculateTotalCost(int bookingid) throws BookingException;
	
	
	public List<TicketBookingBean> showAllBooking(LocalDate date) throws BookingException;
	
	
}
