package com.cg.mtb.controller;

import java.time.LocalDateTime;
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
import org.springframework.web.bind.annotation.RestController;

import com.cg.mtb.exception.ShowException;
import com.cg.mtb.model.ShowBean;
import com.cg.mtb.service.IShowServiceImpl;

@CrossOrigin("*")
@RestController
@RequestMapping("/show")
public class IShowController {
	
	@Autowired
	IShowServiceImpl service;
	ShowBean sho;

	
	@PostMapping("/add")
	public ShowBean addShow(@RequestBody ShowBean show) throws ShowException {
		sho= service.addShow(show);
		return sho;
	}
	
	@DeleteMapping("/delete/{id}")
	public ShowBean deleteShow(@PathVariable("id") int id) throws ShowException {
		
		sho= service.deleteShow(id);
		return sho;
	}
	
	@PutMapping("/update")
	public ShowBean updateShow(@RequestBody ShowBean show) throws ShowException{
		
			sho= service.updateShow(show);
			return sho;
	}

	@GetMapping("/list")
	public List<ShowBean> getAllShows(){
		List<ShowBean> lis= service.viewAllShows();
		return lis;
	}
	
	@GetMapping("/viewshow")
	public ShowBean viewShow(@RequestBody ShowBean show) throws ShowException{
		
		sho= service.viewShow(show);
		return sho;
	}
	
	@GetMapping("/showtheid/{id}")
	public List<ShowBean> viewShowList(@PathVariable("id") int theatreId) throws ShowException{
		
		List<ShowBean> lis= service.viewShowList(theatreId);
		return lis;
	}
	
	@GetMapping("/showdate/{id}")
	public List<ShowBean> viewShowList(@PathVariable("id") @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime Date) throws ShowException{
		
		List<ShowBean> lis= service.viewShowList(Date);
		return lis;
	}
	
	@GetMapping("/showbyid/{id}")
	public ShowBean viewShowById(@PathVariable("id") int id) {
		
		sho=service.viewShowById(id);
		return sho;
	}
}
