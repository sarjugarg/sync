package org.sync.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.poi.util.SystemOutLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.sync.model.AllDashboard;
import org.sync.model.Channel;
import org.sync.model.Filter;
import org.sync.serviceimpl.ChannelServiceImpl;
import org.sync.serviceimpl.ProductServiceImpl;

@Controller
public class ChannelController {
	@Autowired ChannelServiceImpl channelService;
	@Autowired ProductServiceImpl productService;
	@Value("${channelUrl}")
	String channelLogoUrl;  
	@RequestMapping(value= "/ChannelDashboard",method=RequestMethod.GET)
	public ModelAndView channelDashboard() {  
		ModelAndView view=new ModelAndView("ChannelDashboard");
        List<String> genreList=new ArrayList<String>();
        List<Channel> channelList=new ArrayList<Channel>();
        List<String> languages=new ArrayList<String>();
        languages=channelService.totalLanguages();
        genreList=productService.getAllGenres();
        channelList=productService.getAllChannels();
        view.addObject("genres",genreList);
		view.addObject("channels",channelList); 
		view.addObject("languages",languages);
		return view;
	}
    	
	@ResponseBody
	@RequestMapping(value= "/channelsCount",method=RequestMethod.GET)
	public List<AllDashboard> channelsCount() {
    List<AllDashboard> channelscount=new ArrayList<AllDashboard>();
    channelscount=channelService.channelsDatacount();
	return channelscount;
	} 

	@ResponseBody
	@RequestMapping(value= "/AllGenre",method=RequestMethod.GET)
	public List<String> genreList() {
        List<String> genreList=new ArrayList<String>();
        genreList=productService.getAllGenres();
	return genreList;
	}
	  
	@ResponseBody
	@RequestMapping(value= "/AllChannels",method=RequestMethod.GET)
	public List<Channel> channelList() {
        List<Channel> channelList=new ArrayList<Channel>();
        channelList=productService.getAllChannels();
	return channelList;
	}
	
	@ResponseBody
	@RequestMapping(value= "/AllLanguage",method=RequestMethod.GET)
	public List<String> languageList() {
        List<String> languageList=new ArrayList<String>();
        languageList=channelService.totalLanguages();
	    return languageList;
	} 
	@ResponseBody
	@RequestMapping(value="/SingleChannel",method=RequestMethod.POST)
	public ModelAndView singleChannelDashboard(@RequestBody Channel channel,HttpSession session) { 
		ModelAndView view=new ModelAndView("SingleChannelDashboard");
		System.out.println("channel data:" +channel); 
	    List<AllDashboard> singleChannelData=new ArrayList<AllDashboard>();
        singleChannelData=channelService.DataBySingleChannel(channel.getCid(),channel.getStartdate(),channel.getEnddate());
        Channel channelData=new Channel(); 
        channelData=channelService.channelLogo(channel.getCid());
        System.out.println("channelData from query" +channelData);
	    view.addObject("Logo",channelData.getLogo());
	    session.setAttribute("logoUrl", channelLogoUrl);
	    session.setAttribute("channelData2", channelData);
	    session.setAttribute("Logo", channelData.getLogo());
	    session.setAttribute("streamname", channelData.getStreamname());
	    session.setAttribute("channeldata", singleChannelData);
	    session.setAttribute("startdate", channel.getStartdate());
	    session.setAttribute("enddate", channel.getEnddate());
	    session.setAttribute("cid", channel.getCid());
	    session.setAttribute("datetext", channel.getDatetext());
	    session.setAttribute("cardstatus",channel.getCard());	    
	    session.setAttribute("language",channelData.getLanguage());
	    session.setAttribute("genre",channelData.getGenre());
 		//view.addObject("channeldata",singleChannelData);
		return view;
	} 
 
	@RequestMapping(value="/SingleChannelDashboard",method=RequestMethod.GET)
	public String SingleChannel() {
		return "SingleChannelDashboard";
	}
	
	@ResponseBody
	@RequestMapping(value= "/getHourlyPlayoutByChannel",method= {RequestMethod.POST})
	public List<AllDashboard> getDataByLanguage(@RequestBody Filter data,@RequestParam(value="order",defaultValue="desc",required=false)String order) {
        data.setOrder(order);
    	System.out.println("data: " +data);
    	List<AllDashboard> hourlyPlayout=new ArrayList<AllDashboard>();
    	hourlyPlayout=channelService.hourlyPlayoutForChannel(data);
		return hourlyPlayout;
	}

	
	@ResponseBody
	@RequestMapping(value= "/getDailyPlayoutByChannel",method= {RequestMethod.POST})
	public List<AllDashboard> getDailyPlayoutByAOrP(@RequestBody Filter data,@RequestParam(value="order",defaultValue="desc",required=false)String order) {
        data.setOrder(order);
    	System.out.println("data: " +data);
    	List<AllDashboard> dailyPlayout=new ArrayList<AllDashboard>();
    	dailyPlayout=channelService.dailyPlayoutForChannel(data);
		return dailyPlayout;
	}

	

	@ResponseBody
	@RequestMapping(value= "/ChannelsList",method= {RequestMethod.POST})
	public List<AllDashboard> channelsList(@RequestBody Filter data,@RequestParam(value="order",defaultValue="desc",required=false)String order) {
	    data.setOrder(order); 
		List<AllDashboard> channels=new ArrayList<AllDashboard>();
		channels=channelService.channelsList(data);
		return channels;
	}

	
	@ResponseBody
	@RequestMapping(value= "/getDatabyProduct",method= {RequestMethod.POST})
	public List<AllDashboard> getDatabyProduct(@RequestBody Filter data,@RequestParam(value="order",defaultValue="desc",required=false)String order) {
	    data.setOrder(order); 
		List<AllDashboard> products=new ArrayList<AllDashboard>();
		products=channelService.getDataByTopProduct(data);
		return products;
	}

	@ResponseBody
	@RequestMapping(value= "/getTopBrands",method= {RequestMethod.POST})
	public List<AllDashboard> getTopBrands(@RequestBody Filter data,@RequestParam(value="order",defaultValue="desc",required=false)String order) {
        data.setOrder(order);
    	List<AllDashboard> brands=new ArrayList<AllDashboard>();
    	brands=channelService.getDatabyBrands(data);
		return brands;
   }

}
