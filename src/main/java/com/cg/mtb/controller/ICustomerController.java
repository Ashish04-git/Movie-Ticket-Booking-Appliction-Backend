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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.mtb.exception.CustomerException;
import com.cg.mtb.model.CustomerBean;
import com.cg.mtb.model.MovieBean;
import com.cg.mtb.model.UserBean;
import com.cg.mtb.service.ICustomerServiceImpl;

@CrossOrigin("*")
@RestController
@RequestMapping("/cust")
public class ICustomerController {
	
	@Autowired
	ICustomerServiceImpl service;
	CustomerBean cust;
	
	@PostMapping("/add")
	public CustomerBean addCustomer(@RequestBody CustomerBean customer) throws CustomerException {
		cust= service.addCustomer(customer);
		return cust;
	}
	
	@DeleteMapping("/delete/{id}")
	public CustomerBean deleteCustomer(@PathVariable("id") int id) throws CustomerException {
		
		cust= service.deleteCustomer(id);
		return cust;
	}
	
	@PutMapping("/update")
	public CustomerBean updateCustomer(@RequestBody CustomerBean customer) throws CustomerException{
		
			cust= service.updateCustomer(customer);
			return cust;
	}
	
	@GetMapping("/custby/{id}")
	public CustomerBean viewCustomer(@PathVariable("id") int id) throws CustomerException{
		
			cust= service.viewCustomer(id);
			return cust;
	}
	
	
	@GetMapping("/list")
	public List<CustomerBean> getAllCustomers() throws CustomerException{
		List<CustomerBean> lis= service.getAllCustomer();
		return lis;
	}
	
	
	@GetMapping("/custmovieid/{id}")
	public List<CustomerBean> viewAllCustomer(@PathVariable("id") int movieId) throws CustomerException {
		
		List<CustomerBean> lis= service.viewAllCustomers(movieId);
		return lis;
	}
	
}
