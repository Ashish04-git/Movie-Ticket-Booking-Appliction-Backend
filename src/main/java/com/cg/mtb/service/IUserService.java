package com.cg.mtb.service;

import java.util.List;

import com.cg.mtb.exception.UserException;
import com.cg.mtb.model.UserBean;

public interface IUserService {
	
	public List<UserBean> getusers() throws UserException;
	
	public UserBean getUser(int id) throws UserException;
	
	public UserBean addUser(UserBean u) throws UserException;
	
	public UserBean removeUser(int id) throws UserException;

}
