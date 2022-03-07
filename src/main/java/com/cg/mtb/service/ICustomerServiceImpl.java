package com.cg.mtb.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.cg.mtb.exception.CustomerException;
import com.cg.mtb.model.CustomerBean;
import com.cg.mtb.model.MovieBean;
import com.cg.mtb.model.ShowBean;
import com.cg.mtb.repository.ICustomerRepository;

@Service
public class ICustomerServiceImpl implements ICustomerService{
	
	@Autowired
	ICustomerRepository dao;
	CustomerBean cust;
	
	public CustomerBean addCustomer(CustomerBean customer) throws CustomerException {
		
		if(dao.existsById(customer.getCustomerId())) {
			throw new CustomerException("Customer already exist");
		}
		cust= dao.save(customer);
		return cust;
		
	}
	
//	public CustomerBean deleteCustomer(CustomerBean customer) throws CustomerException {
//		
//		if(dao.existsById(customer.getCustomerId())) {
//			cust= dao.findById(customer.getCustomerId()).get();
//			dao.deleteById(customer.getCustomerId());
//			return cust;
//		}
//		return null;
//	}
	
	public CustomerBean deleteCustomer(int id) throws CustomerException{
		if(dao.existsById(id)) {
			cust= dao.findById(id).get();
			dao.deleteById(id);
			return cust;
		}else {
			throw new CustomerException("Customer not found");
		}
	}
	
	public CustomerBean updateCustomer(CustomerBean customer) throws CustomerException {
		
		if(dao.existsById(customer.getCustomerId())) {
			cust= dao.save(customer);
			return cust;
		}
		throw new CustomerException("Customer not found");
	}
	
	public CustomerBean viewCustomer(int custid) throws CustomerException{
		
		if(dao.existsById(custid)){
			Optional<CustomerBean> opt= dao.findById(custid);
			cust= opt.get();
			return cust;
		}
		throw new CustomerException("Customer not found");
	}
	
	public List<CustomerBean> getAllCustomer() throws CustomerException{
		
		List<CustomerBean> lis= dao.findAll();
		if(lis.size()>0) {
			return lis;
		}
		throw new CustomerException("List does not exist");
	}
	
	public List<CustomerBean> viewAllCustomers(int movieid) throws CustomerException{
		
		List<CustomerBean> lis= dao.viewAllCustomers(movieid);
		
		if(lis.size()>0)
			return lis;
		throw new CustomerException("List does not exist");
	}
		
	
}
