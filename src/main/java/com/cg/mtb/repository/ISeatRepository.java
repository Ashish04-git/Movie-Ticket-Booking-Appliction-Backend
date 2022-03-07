package com.cg.mtb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.mtb.model.SeatBean;

@Repository
public interface ISeatRepository extends JpaRepository<SeatBean, Integer>{
	
	
	@Query("select s from SeatBean s where s.seatId not in :p1")
	public  List<SeatBean> blockseat(@Param("p1") int sid); 
	

}
