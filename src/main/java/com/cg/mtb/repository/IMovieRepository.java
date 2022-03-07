package com.cg.mtb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.mtb.model.MovieBean;

@Repository
public interface IMovieRepository extends JpaRepository<MovieBean, Integer>{
	
	
	@Query("Select m from MovieBean m where m.theatre.theatreId=:p1")
	public List<MovieBean> vieMovieList(@Param("p1") int theatreId);

}
