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

import com.cg.mtb.exception.UserException;
import com.cg.mtb.model.UserBean;
import com.cg.mtb.service.IUserServiceImpl;

@CrossOrigin("*")
@RestController
@RequestMapping("/user")
public class IUserController {
	
	@Autowired
	IUserServiceImpl service;
	UserBean usr;
	
	@GetMapping("/userlist")
	public List<UserBean> getAllUser() throws UserException{
		List<UserBean> lis= service.getusers();
		return lis;
		
	}
	
	@GetMapping("/userby/{id}")
	public UserBean getUser(@PathVariable("id") int id) throws UserException{
		UserBean usr= service.getUser(id);
		return usr;
		
	}
	
	@PostMapping("/adduser")
	public UserBean addUser(@RequestBody UserBean u) throws UserException {
		usr= service.addUser(u);
		return usr;
		
	}
	
	@DeleteMapping("/deluser/{id}")
	public UserBean delUser(@PathVariable("id") int id) throws UserException {

			usr= service.removeUser(id);
			return usr;
	}
	
	@GetMapping("/validate/{userid}/{pass}")
	public boolean validate(@PathVariable("userid") int userid, @PathVariable("pass") String pass) {
		
		boolean flag= service.validate(userid, pass);
		return flag;
	}
	
	@GetMapping("/validateadmin/{adminid}/{pass}")
	public boolean validateadmin(@PathVariable("adminid") int adminid, @PathVariable("pass") String pass) {
		
		boolean flag= service.validateadmin(adminid, pass);
		return flag;
	}
	
}
