package com.framework.controller;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.framework.daoImplement.SheduleCampaignDaoImplement;
import com.framework.model.SheduleCampaign;

@Controller
public class SheduleCampaignControler {

	
	@Autowired
	SheduleCampaignDaoImplement shedulecampaign;
	
	
@RequestMapping (value="sheduleCampaign",method=RequestMethod.GET)
public ModelAndView shedule()

{
	List<SheduleCampaign> shedule= new ArrayList<SheduleCampaign>();

	shedule=shedulecampaign.shedule();
	System.out.println("shedule details"+shedule);	
	ModelAndView mv= new ModelAndView();
	mv.addObject("schedule", shedule);
	mv.setViewName("sheduleCampaign");
	return mv;
	
}

@RequestMapping (value="addShedule",method=RequestMethod.GET)
public ModelAndView addShedule()

{
	List<SheduleCampaign> chanel= new ArrayList<SheduleCampaign>();
	List<SheduleCampaign> campaign= new ArrayList<SheduleCampaign>();
	chanel=shedulecampaign.fetchChannel();
	campaign=shedulecampaign.fetchCampaign();
	ModelAndView mv= new ModelAndView();
	
	mv.setViewName("AddSchedule");
	mv.addObject("channel", chanel);
	mv.addObject("campaign", campaign);
	return mv;
	
}

@RequestMapping (value="fetchSchedule",method=RequestMethod.POST)
public @ResponseBody List<SheduleCampaign> fetchCampaignSchedule()

{
	
	System.out.println("fetch channel ");
	List<SheduleCampaign> chanel= new ArrayList<SheduleCampaign>();
	//List<SheduleCampaign> campaign= new ArrayList<SheduleCampaign>();
	chanel=shedulecampaign.fetchChannel();
	
	return chanel;
	
}

@RequestMapping (value="fetchcampaign",method=RequestMethod.POST)
public @ResponseBody List<SheduleCampaign> fetchCampaign()

{
	
	System.out.println("fetch channel ");
	List<SheduleCampaign> campaign= new ArrayList<SheduleCampaign>();
	//List<SheduleCampaign> campaign= new ArrayList<SheduleCampaign>();
	campaign=shedulecampaign.fetchCampaign();
	
	return campaign;
	
}

@RequestMapping (value="addSheduleCampaign",method=RequestMethod.POST)
public @ResponseBody int addShedulecampaign(@RequestBody SheduleCampaign newcampaign  )

{

	int add=shedulecampaign.addsheduleCampaign(newcampaign);
	System.out.println("update return="+add);
	return add;
	
}

@RequestMapping (value="editSchedule/{sheduleid}",method=RequestMethod.GET)
public @ResponseBody ModelAndView editShedulecampaign(@PathVariable ("sheduleid")int  sheduleid )


{
	SheduleCampaign shedule= new SheduleCampaign();
	shedule=shedulecampaign.sheduleById(sheduleid);
	System.out.println("update return="+shedule);
	
	ModelAndView mv =new ModelAndView();
	mv.setViewName("editSchedule");
	mv.addObject("shedule", shedule);
	return mv;
	
}

@RequestMapping (value="updateSchedule",method=RequestMethod.POST)
public @ResponseBody int updateShedulecampaign(@RequestBody SheduleCampaign newcampaign)


{
	System.out.println("data for updatte="+newcampaign);
	int schedule=shedulecampaign.updateSchedule(newcampaign);
	System.out.println("update return="+schedule);
	
	
	return schedule;
	
}


@RequestMapping (value="fetchChannel",method=RequestMethod.POST)
public ModelAndView fetchChannel()

{
	List<SheduleCampaign> chanel= new ArrayList<SheduleCampaign>();
	
	chanel=shedulecampaign.fetchChannel();

	System.out.println("allll channel list=="+chanel);
	ModelAndView mv=new ModelAndView();
	mv.setViewName("redirect:/AddSchedule");
	
	return mv;
	
}



@RequestMapping (value="deleteSchedule",method=RequestMethod.POST)
public ModelAndView deleteSchedule(SheduleCampaign schedule)

{
	int delete=shedulecampaign.deleteSchedule(schedule);
	if(delete==1)
	{
		System.out.println("schedule deleteion  sucessfull");
	}
	else{
		
		{
			System.out.println("schedule deleteion  failed");
		}
	}
	ModelAndView mv=new ModelAndView();
	
	mv.setViewName("redirect:/sheduleCampaign");
	return mv;
	
}

}