package com.cg.mtb.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.mtb.exception.BookingException;
import com.cg.mtb.model.TicketBookingBean;
import com.cg.mtb.service.IBookingServiceImpl;

@CrossOrigin("*")
@RestController
@RequestMapping("/booking")
public class IBookingController {
	
	@Autowired
	IBookingServiceImpl service;
	TicketBookingBean bookseat;
	
	
	
	@PostMapping("/add")
	public TicketBookingBean addBooking(@RequestBody TicketBookingBean booking) throws BookingException {
		
		bookseat= service.addBooking(booking);
		return bookseat;
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<TicketBookingBean> cancelBooking(@PathVariable("id") int id) throws BookingException{
		
		bookseat= service.cancelBooking(id);
		if(bookseat==null)
			return new ResponseEntity("Booking Not Found", HttpStatus.NOT_FOUND);
		return new ResponseEntity<TicketBookingBean>(bookseat, HttpStatus.OK);
	}
	
	
	@PutMapping("/update")
	public TicketBookingBean updateBooking(@RequestBody TicketBookingBean booking) throws BookingException{
		
		bookseat= service.updateBooking(booking);
		return bookseat;
	}
	
	
	@GetMapping("/list")
	public List<TicketBookingBean> getAllBookings(){
			
			List<TicketBookingBean> lis= service.getAllBookings();
			return lis;
		}
	
	
	@GetMapping("/bookmovieid/{id}")
	public List<TicketBookingBean> showAllBooking(@PathVariable("id") int movieId) throws BookingException{
		
		List<TicketBookingBean> lis= service.showAllBookings(movieId);
		return lis;
	}
	
	@GetMapping("/bookcost/{id}")
	public double calculateTotalCost(@PathVariable("id") int bookingid) throws BookingException {
	
		double cost= service.calculateTotalCost(bookingid);
		return cost;
	}
	
	@GetMapping("/bookdate/{id}")
	public List<TicketBookingBean> showAllBooking(@PathVariable("id") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws BookingException{
		
		List<TicketBookingBean> lis= service.showAllBooking(date);
		return lis;
	}
	
	@GetMapping("/bookshowid/{id}")
	public List<TicketBookingBean> showAllBooking1(@PathVariable("id") int showId) throws BookingException{
		
		List<TicketBookingBean> lis= service.showAllBooking(showId);
		return lis;
	}
	
	@GetMapping("/bookbyid/{id}")
	public TicketBookingBean getBookingById(@PathVariable("id") int id) throws BookingException {
		
		bookseat= service.getBookingById(id);
		return bookseat;
	}

}
