package com.cg.mtb.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="ticketbook_tbl")
public class TicketBookingBean {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="transid")
	private Integer transactionId;
	
	@Column(name="transmode", length=20)
	private String transactionMode;
		
	@Column(name="transstatus", length=20)
	private String transactionStatus;
	
	@Column(name="transcost")
	private Double totalCost;
	
	@Column(name="bdate")
	private LocalDate bookingDate;
	
	@OneToOne
	private TicketBean ticket;
	
	@OneToOne
	private ShowBean show;
	
	@ManyToOne
	private CustomerBean customer;
	
	public TicketBookingBean() {
		super();
	}
	
	
	public TicketBookingBean(Integer transactionId , String transactionMode,
			String transactionStatus, Double totalCost, LocalDate bookingDate,TicketBean ticket,CustomerBean customer, ShowBean show) {
		super();
		this.ticket = ticket;
		this.transactionId = transactionId;
		this.transactionMode = transactionMode;
		this.show = show;
		this.transactionStatus = transactionStatus;
		this.totalCost = totalCost;
		this.bookingDate = bookingDate;
		this.customer = customer;
	}





	public TicketBean getTicket() {
		return ticket;
	}
	
	public void setTicket(TicketBean ticket) {
		this.ticket = ticket;
	}
	
	public Integer getTransactionId() {
		return transactionId;
	}
	
	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}
	
	public String getTransactionMode() {
		return transactionMode;
	}
	
	public void setTransactionMode(String transactionMode) {
		this.transactionMode = transactionMode;
	}
	
	public String getTransactionStatus() {
		return transactionStatus;
	}
	
	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}
	
	public Double getTotalCost() {
		return totalCost;
	}
	
	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}
	
	public LocalDate getBookingDate() {
		return bookingDate;
	}
	
	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}


	public ShowBean getShowId() {
		return show;
	}


	public void setShowId(ShowBean show) {
		this.show = show;
	}

	public CustomerBean getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerBean customer) {
		this.customer = customer;
	}



	
	
	
	
	
}
