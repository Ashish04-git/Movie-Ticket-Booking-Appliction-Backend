package com.cg.mtb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="seat_tbl")
public class SeatBean {
	@Id
	@Column(name="sid")
	private Integer seatId;
	
	@Column(name="sno", length=20)
	private String seatNumber;
	
	@Column(name="stype", length=20)
	private String type;
	
	@Column(name="sprice")
	private Double price;
	
	@ManyToOne
	private TicketBean ticket;
	
	
	public SeatBean(Integer seatId, String seatNumber, String type, Double price, TicketBean ticket) {
		super();
		this.seatId = seatId;
		this.seatNumber = seatNumber;
		this.type = type;
		this.price = price;
		this.ticket = ticket;
	}
	
	public SeatBean() {
		super();
	}
	
	public Integer getSeatId() {
		return seatId;
	}
	
	public void setSeatId(Integer seatId) {
		this.seatId = seatId;
	}
	
	public String getSeatNumber() {
		return seatNumber;
	}
	
	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public Double getPrice() {
		return price;
	}
	
	public void setPrice(Double price) {
		this.price = price;
	}
	
	
	public TicketBean getTicket() {
		return ticket;
	}

	public void setTicket(TicketBean ticket) {
		this.ticket = ticket;
	}

	@Override
	public String toString() {
		return "SeatBean [seatId=" + seatId + ", seatNumber=" + seatNumber + ", type=" + type + ", price=" + price
				+ ", ticket=" + ticket + "]";
	}
}
