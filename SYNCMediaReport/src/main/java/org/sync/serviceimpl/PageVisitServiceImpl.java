package org.sync.serviceimpl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.sync.daoimpl.PageVisitDaoImpl;
import org.sync.model.PageVisit;
import org.sync.service.PageVisitService;

public class PageVisitServiceImpl implements PageVisitService{
	@Autowired
	PageVisitDaoImpl recentCardDao;
	@Override
	public String saveRecentPageVisit(PageVisit pv) {
		try{
			int i=recentCardDao.saveRecentPageVisit(pv);
			if(i>0) {
				return "Card created sucessfully!";
			} 
			else {
				return "Card name already exist"; 
			} 
		}
		catch(Exception e){
			System.out.println(e);
			return "Oops! an error occured";
		}
	}
	@Override
	public List<PageVisit> getRecentCards(Integer userId) {
		return recentCardDao.getRecentCards(userId);
	}
}
