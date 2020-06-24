package org.sync.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.sync.model.PageVisit;
import org.sync.serviceimpl.PageVisitServiceImpl;
@Controller
public class CardController{
	
@Autowired
PageVisitServiceImpl recentCardService;

	@ResponseBody
    @RequestMapping(value="/AddRecentCard",method=RequestMethod.POST)
	public String saverecentPageVisit(@RequestBody PageVisit visit,HttpSession session) {
	String output=null;
	Integer userId=(Integer)session.getAttribute("userid");
	System.out.println("userid: "+userId);
	visit.setUserId(userId);
	output=recentCardService.saveRecentPageVisit(visit);
	System.out.println("recent page output: " +output);
	return output;
		
	}
	
	@ResponseBody
    @RequestMapping(value="/getRecentCards/{userId}",method=RequestMethod.GET)
	public List<PageVisit> getRecentPageVisit(HttpSession session, @PathVariable("userId")Integer userId) {
   List<PageVisit> recentCardData=new ArrayList<PageVisit>();
	System.out.println("userid: "+userId);
	recentCardData=recentCardService.getRecentCards(userId);
	return recentCardData;
		
	}
	
}



