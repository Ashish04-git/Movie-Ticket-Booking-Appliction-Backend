package com.cg.mtb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="admin_tbl")
public class AdminBean {
	@Id
	Integer adminId;
	
	@Column(name="adname", length=20)
	String adminName;
	
	@Column(name="adcontact", length=20)
	String adminContact;
	
	@Column(length=20)
	String password;
	
//	@OneToOne
//	private UserBean user;
	
	public AdminBean() {
		super();
	}
	


	public AdminBean(Integer adminId, String adminName, String adminContact, String password) {
	super();
	this.adminId = adminId;
	this.adminName = adminName;
	this.adminContact = adminContact;
	this.password = password;
}



	public Integer getAdminId() {
		return adminId;
	}
	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminContact() {
		return adminContact;
	}
	public void setAdminContact(String adminContact) {
		this.adminContact = adminContact;
		
	}
	
	
//	public UserBean getUser() {
//		return user;
//	}
//
//	public void setUser(UserBean user) {
//		this.user = user;
//	}

	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	@Override
	public String toString() {
		return "AdminBean [adminId=" + adminId + ", adminName=" + adminName + ", adminContact=" + adminContact + "]";
	}

	

	
	
	

}
