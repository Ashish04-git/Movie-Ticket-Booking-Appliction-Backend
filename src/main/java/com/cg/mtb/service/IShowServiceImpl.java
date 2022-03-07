package com.cg.mtb.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.cg.mtb.exception.ShowException;
import com.cg.mtb.model.ShowBean;
import com.cg.mtb.repository.IShowRepository;

@Service
public class IShowServiceImpl implements IShowService{
	
	@Autowired
	IShowRepository dao;
	ShowBean sho;
	
	public ShowBean addShow(ShowBean show) throws ShowException {
		
		if(dao.existsById(show.getShowId()))
			throw new ShowException("Show already exist");
		 sho = dao.save(show);
		return sho;
	}

	public ShowBean deleteShow(int id) throws ShowException {
		
		if(dao.existsById(id)) {
			sho = dao.findById(id).get();
			dao.deleteById(sho.getShowId());
			return sho;
		}
		throw new ShowException("Show not found");
	
}

	public ShowBean updateShow(ShowBean show) throws ShowException {
		
		if(dao.existsById(show.getShowId())) {
			sho= dao.save(show);
			return sho;
		}
		throw new ShowException("Show not found");
	}
	
	public List<ShowBean> viewAllShows(){
		
		List<ShowBean> lis= dao.findAll();
		return lis;
	}

	public List<ShowBean> viewShowList(int theatreId) throws ShowException{
		
		List<ShowBean> lis= dao.viewShowList(theatreId);
		if(lis.size()>0)
			return lis;
		throw new ShowException("No record found");
	}
	
	public ShowBean viewShowById(int id){
		Optional<ShowBean> opt= dao.findById(id);
		sho=opt.get();
		return sho;
	}
	
	public ShowBean viewShow(ShowBean show) throws ShowException{
		
		if(dao.existsById(show.getShowId())) {
			sho= dao.findById(show.getShowId()).get();
			return sho;
			
		}
		throw new ShowException("Show not found");
		
	}
	
	public List<ShowBean> viewShowList(LocalDateTime Date) throws ShowException{
		
		List<ShowBean> lis= dao.viewShowList(Date);
		if(lis.size()>0)
			return lis;
		throw new ShowException("No record found");
	}

}
