package com.cg.mtb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.mtb.exception.UserException;
import com.cg.mtb.model.AdminBean;
import com.cg.mtb.model.UserBean;
import com.cg.mtb.repository.IAdminRepository;
import com.cg.mtb.repository.IUserRepository;

@Service
public class IUserServiceImpl implements IUserService{
	
	@Autowired
	IUserRepository dao;
	
	@Autowired
	IAdminRepository admindao;
	
	public List<UserBean> getusers() throws UserException{
		List<UserBean> lis= dao.findAll();
		
		if(lis.size()>0) {
			return lis;
		}
		throw new UserException("List not found");
		
	}
	
	public UserBean getUser(int id) throws UserException{
		if(dao.existsById(id)) {
			Optional<UserBean> opt= dao.findById(id);
			UserBean u= opt.get();
			return u;
		}
		throw new UserException("User "+id+" not found");
	}
	
	public UserBean addUser(UserBean u) throws UserException {
		if(dao.existsById(u.getUserId())) {
			throw new UserException("User "+u.getUserId()+" already exist");
		}
		UserBean usr= dao.save(u);
		return usr;
		
	}
	
	public UserBean removeUser(int id) throws UserException {
		if(dao.existsById(id)) {
			UserBean usr= dao.findById(id).get();
			dao.deleteById(id);
			return usr;
		}else {
			throw new UserException("User "+id+" not found");	
		}
		

	}
	
	public boolean validate(int userid, String pass) {
		List<UserBean> usr= dao.findAll();
		for(UserBean u: usr) {
			if(u.getUserId().equals(userid)&& u.getPassword().equals(pass)) {
				return true;
			}
			
		}
		return false;
	}
	
	public boolean validateadmin(int adminid, String pass) {
		List<AdminBean> admin= admindao.findAll();
		for(AdminBean a: admin) {
			if(a.getAdminId().equals(adminid)&& a.getPassword().equals(pass)){
				return true;
			}
		}
		return false;
	}
	
	   public boolean checkUser(int id){
		   if(dao.existsById(id)) {
			   return true;
		   }
		   return false;
	   }
}
