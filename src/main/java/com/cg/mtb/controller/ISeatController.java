package com.cg.mtb.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.mtb.exception.SeatException;
import com.cg.mtb.model.SeatBean;
import com.cg.mtb.service.ISeatServiceImpl;

@CrossOrigin("*")
@RestController
@RequestMapping("/seat")
public class ISeatController {
	
	@Autowired
	ISeatServiceImpl service;
	SeatBean set;
	
	@PostMapping("/bookseat")
	public SeatBean addBooking(@RequestBody SeatBean seat) throws SeatException {
		
		set= service.addBooking(seat);
		return set;
	}
	
	@DeleteMapping("/cancelseat/{id}")
	public SeatBean cancelSeatBooking(@PathVariable("id") int id) throws SeatException {
		
		set= service.cancelSeatBooking(id);
		return set;
		
	}
	
	@GetMapping("/list")
	public List<SeatBean> getAllSeats(){
		
		List<SeatBean> lis= service.getAllSeats();
		return lis;
		
	}
	
	
	public SeatBean blockSeat(@RequestBody SeatBean seat) throws SeatException {
		
		SeatBean sea= service.blockSeat(seat);
		return sea;
	}
	
	@GetMapping("/seatbyid/{id}")
	public SeatBean getSeatById(@PathVariable("id") int id) throws SeatException {
		
		set= service.getSeatById(id);
		return set;
	}
	
	@GetMapping("/blockseat/{sid}")
	public  List<SeatBean> blockseat(@PathVariable("sid") int sid) throws SeatException{
		
		List<SeatBean> lis= service.blockseat(sid);
		return lis;
	}

}
