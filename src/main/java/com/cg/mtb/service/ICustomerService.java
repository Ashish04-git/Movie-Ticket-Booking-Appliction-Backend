package com.cg.mtb.service;

import java.util.List;

import com.cg.mtb.exception.CustomerException;
import com.cg.mtb.model.CustomerBean;

public interface ICustomerService {
	
	public CustomerBean addCustomer(CustomerBean customer) throws CustomerException;
	
	public CustomerBean deleteCustomer(int id) throws CustomerException;
	
	public CustomerBean updateCustomer(CustomerBean customer) throws CustomerException;
	
	public CustomerBean viewCustomer(int id) throws CustomerException;
	
	public List<CustomerBean> getAllCustomer() throws CustomerException;
	
	public List<CustomerBean> viewAllCustomers(int movieid) throws CustomerException;

}
