package com.cg.mtb.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.mtb.exception.BookingException;
import com.cg.mtb.model.TicketBookingBean;
import com.cg.mtb.repository.IBookingRepository;

@Service
public class IBookingServiceImpl implements IBookingService{
	
	@Autowired
	IBookingRepository dao;
	TicketBookingBean bookseat;
	
	

	public TicketBookingBean addBooking(TicketBookingBean booking) throws BookingException {
		if(dao.existsById(booking.getTransactionId()))
			throw new BookingException("Booking already exist");
		else
			bookseat= dao.save(booking);
			return bookseat;
	}
	
	public TicketBookingBean cancelBooking(int id) throws BookingException {
		if(dao.existsById(id)) {
			bookseat=dao.findById(id).get();
			dao.deleteById(id);
			return bookseat;
			
		}
		throw new BookingException("Booking not found");
	}
	
	
	public TicketBookingBean updateBooking(TicketBookingBean booking) throws BookingException {
		if(dao.existsById(booking.getTransactionId())) {
		bookseat= dao.save(booking);
		return bookseat;
		}
		throw new BookingException("Booking not found");
	}
	
	
	public List<TicketBookingBean> getAllBookings(){
		
		List<TicketBookingBean> lis= dao.findAll();
		return lis;
	}
	
	
	public List<TicketBookingBean> showAllBookings(int movieId) throws BookingException{
		
		List<TicketBookingBean> lis= dao.showAllBooking(movieId);
		if(lis.size()>0)
			return lis;
		throw new BookingException("Bookings not found");
	}
	
	public double calculateTotalCost(int bookingid) throws BookingException {
		if(dao.existsById(bookingid)) {
			double cost= dao.calculateTotalCost(bookingid);
			return cost;
		}else {
			throw new BookingException("Invalid ID");
		}
	}
	
	
	public List<TicketBookingBean> showAllBooking(LocalDate date) throws BookingException{
		List<TicketBookingBean> lis= dao.showAllBooking(date);
		if(lis.size()>0)
			return lis;
		throw new BookingException("Bookings not found");
	}
	
	public List<TicketBookingBean> showAllBooking(int showId) throws BookingException{
		List<TicketBookingBean> lis= dao.showAllBokking(showId);
		if(lis.size()>0)
			return lis;
		throw new BookingException("Bookings not found");
	}
	
	public TicketBookingBean getBookingById(int id) throws BookingException {
		if(dao.existsById(id)) {
			bookseat= dao.findById(id).get();
			return bookseat;
		}
		throw new BookingException("Booking not found");
	}
	
	
	
}
