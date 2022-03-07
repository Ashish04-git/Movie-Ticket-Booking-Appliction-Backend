package com.cg.mtb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.mtb.model.AdminBean;

@Repository
public interface IAdminRepository extends JpaRepository<AdminBean, Integer>{

}
