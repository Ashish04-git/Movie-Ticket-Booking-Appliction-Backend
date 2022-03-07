package com.cg.mtb.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.mtb.model.ShowBean;

@Repository
public interface IShowRepository extends JpaRepository<ShowBean, Integer>{
	
	@Query("Select s from ShowBean s where s.movie.theatre.theatreId=:p1")
	public List<ShowBean> viewShowList(@Param("p1") int theatreId);
	
	@Query("Select s from ShowBean s where s.showStartTime=:p1")
	public List<ShowBean> viewShowList(@Param("p1") LocalDateTime Date);

}
