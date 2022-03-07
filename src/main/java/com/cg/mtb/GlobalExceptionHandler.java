package com.cg.mtb;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cg.mtb.exception.BookingException;
import com.cg.mtb.exception.CustomerException;
import com.cg.mtb.exception.ErrorInfo;
import com.cg.mtb.exception.MovieException;
import com.cg.mtb.exception.SeatException;
import com.cg.mtb.exception.ShowException;
import com.cg.mtb.exception.UserException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(UserException.class)
	public @ResponseBody ErrorInfo userException(UserException usr, HttpServletRequest req) {
		ErrorInfo error= new ErrorInfo(LocalDateTime.now(), usr.getMessage(), req.getRequestURI());
		return error;
		
	}
	
	
	@ExceptionHandler(CustomerException.class)
	public @ResponseBody ErrorInfo customerException(CustomerException cust, HttpServletRequest req) {
		
		ErrorInfo error= new ErrorInfo(LocalDateTime.now(), cust.getMessage(), req.getRequestURI());
		return error;
		
	}
	
	
	@ExceptionHandler(MovieException.class)
	public @ResponseBody ErrorInfo movieException(MovieException mov, HttpServletRequest req) {
		
		ErrorInfo error= new ErrorInfo(LocalDateTime.now(), mov.getMessage(), req.getRequestURI());
		return error;
	}
	
	@ExceptionHandler(ShowException.class)
	public @ResponseBody ErrorInfo showException(ShowException show, HttpServletRequest req) {
		
		ErrorInfo error= new ErrorInfo(LocalDateTime.now(), show.getMessage(), req.getRequestURI());
		return error;
	}
	
	
	@ExceptionHandler(BookingException.class)
	public @ResponseBody ErrorInfo bookingException(BookingException book, HttpServletRequest req) {
		
		ErrorInfo error= new ErrorInfo(LocalDateTime.now(), book.getMessage(), req.getRequestURI());
		return error;
	}
	
	
	@ExceptionHandler(SeatException.class)
	public @ResponseBody ErrorInfo seatException(SeatException seat, HttpServletRequest req) {
		
		ErrorInfo error= new ErrorInfo(LocalDateTime.now(), seat.getMessage(), req.getRequestURI());
		return error;
	}

}
