package com.cg.mtb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.cg.mtb.exception.SeatException;
import com.cg.mtb.model.SeatBean;
import com.cg.mtb.repository.ISeatRepository;

@Service
public class ISeatServiceImpl implements ISeatService{
	
	@Autowired
	ISeatRepository dao;
	SeatBean set;

	public SeatBean addBooking(SeatBean seat) throws SeatException {
		if(dao.existsById(seat.getSeatId())) {
			throw new SeatException("Seat already exist");
		}
		set= dao.save(seat);
		return set;
		
	}
	
//	public SeatBean cancelSeatBooking(SeatBean seat) throws SeatException {
//		if(dao.existsById(seat.getSeatId())) {
//			set= dao.findById(seat.getSeatId()).get();
//			dao.deleteById(seat.getSeatId());
//			return set;
//		}
//		throw new SeatException("Seat "+seat.getSeatId()+" not found");
//		
//	}
	
	public SeatBean cancelSeatBooking(int id) throws SeatException {
		if(dao.existsById(id)) {
			set= dao.findById(id).get();
			dao.deleteById(id);
			return set;
		}else{
			throw new SeatException("Seat not found");
		}
	}
	
	public List<SeatBean> getAllSeats(){
		
		List<SeatBean> lis= dao.findAll();
		return lis;
	}
	
	public SeatBean blockSeat(SeatBean seat) throws SeatException{
		if(dao.existsById(seat.getSeatId())) {
			Optional<SeatBean> opt= dao.findById(seat.getSeatId()) ;
			SeatBean set= opt.get();
			return set;
		}
		throw new SeatException("Seat not found");
	}
	
	public  List<SeatBean> blockseat(int sid) throws SeatException{
		
		List<SeatBean> lis= dao.blockseat(sid);
		if(lis.size()>0)
			return lis;
		throw new SeatException("Seats not found");
	}
	
	public SeatBean getSeatById(int id) throws SeatException {
		if(dao.existsById(id)){
			set= dao.findById(id).get();
			return set;
		}
		throw new SeatException("Seat not found");
	}
}
