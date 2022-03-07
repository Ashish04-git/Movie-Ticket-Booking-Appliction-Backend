package com.cg.mtb.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class CustomerBean {
	
	@Id
	@Column(name="custid")
	private Integer customerId;
	
	@Column(name="custname", length=20)
	private String customerName;
	
	@Column(name="address", length=20)
	private String address;
	
	@Column(name="email", length=20)
	private String email;
	
	@Column(name="pass", length=20)
	private String password;
	
	@OneToOne
	private UserBean user;
	
	@ManyToOne
	private MovieBean movie;
	
	public CustomerBean() {
		super();
	}
	
	
	
public CustomerBean(Integer customerId, String customerName, String address, String email, String password,
			UserBean user, MovieBean movie) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.address = address;
		this.email = email;
		this.password = password;
		this.user = user;
		this.movie = movie;
	}


	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public UserBean getUser() {
		return user;
	}


	public void setUser(UserBean user) {
		this.user = user;
	}



	public MovieBean getMovie() {
		return movie;
	}



	public void setMovie(MovieBean movie) {
		this.movie = movie;
	}
	





	


	
	
	
	
}
