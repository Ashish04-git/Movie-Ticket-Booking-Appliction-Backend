package com.cg.mtb.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="ticket_tbl")
public class TicketBean {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="tid")
	private Integer ticketId;
	
	@Column(name="tseat")
	private Integer noOfSeats;
	
	@OneToMany(mappedBy = "ticket")
	@ElementCollection
	@JsonIgnore
	private List<SeatBean> seatNumber= new ArrayList<SeatBean>();

	
	@Column(name="tstatus")
	private Boolean ticketStatus;
	
	@OneToOne(mappedBy = "ticket")
	private TicketBookingBean ticketbook;
	

	public TicketBean(Integer ticketId, Integer noOfSeats,
			Boolean ticketStatus) {
		super();
		this.ticketId = ticketId;
		this.noOfSeats = noOfSeats;
		this.ticketStatus = ticketStatus;

	}


	public TicketBean() {
		super();
	}


	public Integer getTicketId() {
		return ticketId;
	}


	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}


	public Integer getNoOfSeats() {
		return noOfSeats;
	}


	public void setNoOfSeats(Integer noOfSeats) {
		this.noOfSeats = noOfSeats;
	}


	public Boolean getTicketStatus() {
		return ticketStatus;
	}


	public void setTicketStatus(Boolean ticketStatus) {
		this.ticketStatus = ticketStatus;
	}

}
