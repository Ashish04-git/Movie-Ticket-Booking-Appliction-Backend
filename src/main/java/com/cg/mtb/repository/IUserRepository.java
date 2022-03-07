package com.cg.mtb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.mtb.model.UserBean;

@Repository
public interface IUserRepository extends JpaRepository<UserBean, Integer>{

}
