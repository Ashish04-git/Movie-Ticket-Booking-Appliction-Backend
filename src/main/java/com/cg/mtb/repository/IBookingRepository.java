package com.cg.mtb.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.mtb.model.TicketBookingBean;

@Repository
public interface IBookingRepository extends JpaRepository<TicketBookingBean, Integer>{

	
	@Query("Select t from TicketBookingBean t where t.customer.movie.movieId=:p1")
	public List<TicketBookingBean> showAllBooking(@Param("p1") int movieId);
	
	
	@Query("Select t.totalCost from TicketBookingBean t where t.transactionId=:p1")
	public double calculateTotalCost(@Param("p1") int bookingid);
	
	@Query("Select t from TicketBookingBean t where t.bookingDate=:p1")
	public List<TicketBookingBean> showAllBooking(@Param("p1") LocalDate date);
	
	@Query("Select t from TicketBookingBean t where t.show.showId=:p1")
	public List<TicketBookingBean> showAllBokking(@Param("p1") int showId);
	
	
}
