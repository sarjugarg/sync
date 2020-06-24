package org.sync.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

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
import org.sync.model.Category;
import org.sync.model.Channel;
import org.sync.model.Filter;
import org.sync.serviceimpl.CategoryServiceImpl;
import org.sync.serviceimpl.ProductServiceImpl;

@Controller
public class CategoryController { 
	@Autowired CategoryServiceImpl categoryService;
	@Autowired ProductServiceImpl productService;
	@Value("${categoryUrl}") 
	String categoryLogoUrl;

	@RequestMapping(value= "/CategoryDashboard",method=RequestMethod.GET)
	public ModelAndView categoryDashboard() {
		ModelAndView view=new ModelAndView("CategoryDashboard");
        List<String> genreList=new ArrayList<String>();
        List<Channel> channelList=new ArrayList<Channel>();
        genreList=productService.getAllGenres();
        channelList=productService.getAllChannels();
		view.addObject("genres", genreList);
		view.addObject("channels",channelList);
		return view;
	}
	@ResponseBody
	@RequestMapping(value= "/TotalCategories",method=RequestMethod.GET)
	public List<AllDashboard> categoryCount() {
        List<AllDashboard> categoryCount=new ArrayList<AllDashboard>();
        categoryCount=categoryService.categoryDatacount();
	    return categoryCount;
	} 
	
	@RequestMapping(value="/SingleCategory",method=RequestMethod.POST)
	public ModelAndView singleproductDashboard(@RequestBody Category category,HttpSession session) { 
	   System.out.println("category data" + category); 
	   System.out.println("card value: " +category.getCard());
		if((!"".equals(category.getCategory())|| category.getCategory()==null)) {
	    	category.getCategory().replaceAll("'", "\\\\'");
	    }  
		ModelAndView view=new ModelAndView("SingleCategoryDashboard");
	    List<AllDashboard> categoryData=new ArrayList<AllDashboard>();
	    categoryData=categoryService.DataBySingleCategory(category.getCategory(), category.getStartdate(), category.getEnddate());
	    String Logo=new String();
	    Logo=categoryService.categoryLogo(category.getCategory());
	    view.addObject("Logo",Logo);
	    view.addObject("categoryData",categoryData);
	    session.setAttribute("Logo",Logo);
	    session.setAttribute("categoryData",categoryData);
	    session.setAttribute("categoryname",category.getCategory());
	    session.setAttribute("startdate", category.getStartdate());
	    session.setAttribute("enddate", category.getEnddate());
	    session.setAttribute("datetext", category.getDatetext()); 
	    session.setAttribute("cardstatus",category.getCard());
	    session.setAttribute("logoUrl", categoryLogoUrl);
	    return view;
	}
	@RequestMapping(value="/SingleCategoryDashboard",method=RequestMethod.GET)
    public String singleCategoryPage() {
		return "SingleCategoryDashboard";
	}
	
	@ResponseBody
	@RequestMapping(value= "/getHourlyPlayoutByCategory",method= {RequestMethod.POST})
	public List<AllDashboard> getDataByCategory(@RequestBody Filter data,@RequestParam(value="order",defaultValue="desc",required=false)String order) {
        data.setOrder(order);
    	System.out.println("data: " +data);
    	List<AllDashboard> hourlyPlayout=new ArrayList<AllDashboard>();
    	hourlyPlayout=categoryService.hourlyPlayoutForCategory(data);
		//System.out.println("get Hourly playout: "+hourlyPlayout);
		return hourlyPlayout;
	}

	
	@ResponseBody
	@RequestMapping(value= "/getDailyPlayoutByCategory",method= {RequestMethod.POST})
	public List<AllDashboard> getDailyPlayoutByCategory(@RequestBody Filter data,@RequestParam(value="order",defaultValue="desc",required=false)String order) {
        data.setOrder(order);
    	System.out.println("data: " +data);
    	List<AllDashboard> dailyPlayout=new ArrayList<AllDashboard>();
    	dailyPlayout=categoryService.dailyPlayoutForCategory(data);
		//System.out.println("get dailyPlayout: "+dailyPlayout);
		return dailyPlayout;
	}
	
	@ResponseBody
	@RequestMapping(value= "/CategoryList",method= {RequestMethod.POST})
	public List<AllDashboard> categoryList(@RequestBody Filter data,@RequestParam(value="order",defaultValue="desc",required=false)String order) {
	    data.setOrder(order); 
		List<AllDashboard> category=new ArrayList<AllDashboard>();
		category=categoryService.categoryList(data);
		//System.out.println("get categoryList list: "+category);
		return category;
	}
	
	

		
}     
 