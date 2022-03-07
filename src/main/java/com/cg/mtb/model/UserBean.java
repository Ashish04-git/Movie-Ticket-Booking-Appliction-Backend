package com.cg.mtb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="users")
public class UserBean {
	@Id
	@Column(name="userid")
	Integer userId;
	
	@Column(name="password", length=20)
	String password;
	
	@Column(name="role", length=20)
	String role;
	
	@OneToOne(mappedBy = "user")
	@JsonIgnore
	private CustomerBean customer;
	
	public UserBean() {
		super();
	}

	public UserBean(Integer userId, String password, String role) {
		super();
		this.userId = userId;
		this.password = password;
		this.role = role;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserModel [userId=" + userId + ", password=" + password + ", role=" + role + ", customer=" + customer
				+ "]";
	}

	
	
	
	
	
	

}
