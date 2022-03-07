package com.cg.mtb;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import com.cg.mtb.model.CustomerBean;
import com.cg.mtb.model.MovieBean;
import com.cg.mtb.model.SeatBean;
import com.cg.mtb.model.ShowBean;
import com.cg.mtb.model.UserBean;
import com.cg.mtb.repository.ICustomerRepository;
import com.cg.mtb.repository.IMovieRepository;
import com.cg.mtb.repository.ISeatRepository;
import com.cg.mtb.repository.IShowRepository;
import com.cg.mtb.repository.IUserRepository;
import com.cg.mtb.service.ICustomerServiceImpl;
import com.cg.mtb.service.IMovieServiceImpl;
import com.cg.mtb.service.ISeatServiceImpl;
import com.cg.mtb.service.IShowServiceImpl;
import com.cg.mtb.service.IUserServiceImpl;

@SpringBootTest
class MobileTicketBookingApplicationTests {

	@Test
	void contextLoads() {
	}
	
	
	static ICustomerServiceImpl custservice;
	static CustomerBean cust;
	static ISeatServiceImpl seatservice;
	static SeatBean seat;
	static IShowServiceImpl showservice;
	static ShowBean show;
	static IMovieServiceImpl movieservice;
	static MovieBean movie;
	static IUserServiceImpl userservice;
	static UserBean user;
	
	
	@Autowired
	private ICustomerRepository custrepo;
	
	@Autowired
	private ISeatRepository seatrepo;
	
	@Autowired
	private IShowRepository showrepo;
	
	@Autowired
	private IMovieRepository movierepo;
	
	@Autowired
	private IUserRepository userrepo;
	
	@BeforeTestClass
	public static void initialize() {
	custservice= new ICustomerServiceImpl();
	cust=new CustomerBean();
	seatservice= new ISeatServiceImpl();
	seat= new SeatBean();
	showservice= new IShowServiceImpl();
	show= new ShowBean();
	movieservice=new IMovieServiceImpl();
	movie= new MovieBean();
	userservice= new IUserServiceImpl();
	user= new UserBean();
	}
	
	@Test
	public void viewCustomerById() {
		
		assertEquals("Ashsih", custrepo.findById(1).get().getCustomerName());
	}
	
//	@Test
//	public void viewSeatNumber() {
//	
//		assertEquals("D-301", seatrepo.findById(1001).get().getSeatNumber());	
//	}
	
//	@Test
//	public void showMovie() {
//		assertEquals("ZNMD", showrepo.findById(20).get().getMovie().getMovieName());
//		
//	}
	
//	@Test
//	public void wrongMovie() {
//		
//		assertNotEquals("Horror", movierepo.findById(2).get().getMovieGenre());
//	}
	
//	@Test
//	public void addUser() {
//		user=new UserBean(3, "Ashutosh", "developer");
//		userrepo.save(user);
//		assertNotNull(user);
//		
//	}
	
	
//	@Test
//	public void absentUser() {
//		user=new UserBean(8,"Ashish", "Mumbai");
//		userrepo.save(user);
//		assertNotNull(user);
//		
//	}
	
	
	
	
	
	
	
	
	
	
}	

