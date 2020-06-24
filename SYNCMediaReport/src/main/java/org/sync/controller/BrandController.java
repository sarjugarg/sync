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
import org.sync.model.Brand;
import org.sync.model.Channel;
import org.sync.model.Filter;
import org.sync.model.FilterData;
import org.sync.model.TotalAddData;
import org.sync.serviceimpl.BrandServiceImpl;
import org.sync.serviceimpl.CategoryServiceImpl;
import org.sync.serviceimpl.ProductServiceImpl;

@Controller
public class BrandController {
	@Autowired BrandServiceImpl brandService;
	@Autowired ProductServiceImpl productService;
	@Value("${brandUrl}")
	String brandLogoUrl; 
	
	@RequestMapping(value= "/BrandDashboard",method=RequestMethod.GET)
	public ModelAndView categoryDashboard() { 
		ModelAndView view=new ModelAndView("BrandDashboard");
		List<String> genreList=new ArrayList<String>();
		List<Channel> channelList=new ArrayList<Channel>();
		List<String> brand =new ArrayList<String>();         
		brand=brandService.getAllBrand(); 
		genreList=productService.getAllGenres();
		channelList=productService.getAllChannels();
		view.addObject("genres",genreList);
		view.addObject("channels",channelList);
		view.addObject("brands",brand);
		return view;
	}

	@ResponseBody
	@RequestMapping(value= "/TotalBrands",method=RequestMethod.GET)
	public Integer brandCount() {
		Integer brandCount;
		brandCount=brandService.brandDatacount();
		return brandCount;
	} 
    @ResponseBody
	@RequestMapping(value="/SingleBrand",method=RequestMethod.POST)
	public ModelAndView singleproductDashboard(@RequestBody Brand brandData,HttpSession session) { 
		System.out.println("brand data= "+brandData);
		ModelAndView view=new ModelAndView("SingleBrandDashboard");
		List<AllDashboard> getBrandData=new ArrayList<AllDashboard>();
		List<String> singleBrandByProduct=new ArrayList<String>();
		String Logo=new String();
		Logo=brandService.brandLogo(brandData.getBrand());
		getBrandData=brandService.DataBySingleBrand(brandData.getBrand(), brandData.getStartdate(), brandData.getEnddate());
		singleBrandByProduct=brandService.singleBrandByProduct(brandData.getBrand(), brandData.getStartdate(), brandData.getEnddate());
		view.addObject("Logo",Logo); 
		view.addObject("brandData",getBrandData);	
		view.addObject("brandbyProduct",singleBrandByProduct);
		session.setAttribute("Logo", Logo);
		session.setAttribute("brandData", getBrandData);
		session.setAttribute("brandbyProduct", singleBrandByProduct);
		session.setAttribute("startdate", brandData.getStartdate());
		session.setAttribute("enddate", brandData.getEnddate());
		session.setAttribute("brand", brandData.getBrand());
		session.setAttribute("datetext", brandData.getDatetext());
	    session.setAttribute("cardstatus",brandData.getCard());	 
        session.setAttribute("logoUrl",brandLogoUrl ); 
		return view;   
	}
	@RequestMapping(value="/SingleBrandDashboard",method=RequestMethod.GET)
	public String singleChannelPage() {
		return "SingleBrandDashboard";	
	} 

	@ResponseBody
	@RequestMapping(value= "/getHourlyPlayoutByBrand",method= {RequestMethod.POST})
	public List<AllDashboard> getDataByBrand(@RequestBody Filter data,@RequestParam(value="order",defaultValue="desc",required=false)String order) {
		data.setOrder(order);
		System.out.println("data: " +data);
		List<AllDashboard> hourlyPlayout=new ArrayList<AllDashboard>();
		hourlyPlayout=brandService.hourlyPlayoutForBrand(data);
		//System.out.println("get Hourly playout: "+hourlyPlayout);
		return hourlyPlayout;
	}

	@ResponseBody
	@RequestMapping(value= "/getDailyPlayoutByBrand",method= {RequestMethod.POST})
	public List<AllDashboard> getDailyPlayoutByBrand(@RequestBody Filter data,@RequestParam(value="order",defaultValue="desc",required=false)String order) {
		data.setOrder(order);
		System.out.println("data: " +data);
		List<AllDashboard> dailyPlayout=new ArrayList<AllDashboard>();
		dailyPlayout=brandService.dailyPlayoutForBrand(data);
		//System.out.println("get dailyPlayout: "+dailyPlayout);
		return dailyPlayout;
	}

	@ResponseBody
	@RequestMapping(value= "/BrandList",method= {RequestMethod.POST})
	public List<AllDashboard> brandList(@RequestBody Filter data,@RequestParam(value="order",defaultValue="desc",required=false)String order) {
		data.setOrder(order); 
		List<AllDashboard> brand=new ArrayList<AllDashboard>();
		brand=brandService.brandList(data);
		return brand;
	} 

	@ResponseBody
	@RequestMapping(value= "/BrandByEachProduct",method= {RequestMethod.POST})
	public List<AllDashboard> singleProductDataByDec(@RequestBody Filter data,@RequestParam(value="order",defaultValue="desc",required=false)String order) {
		data.setOrder(order);
		List<AllDashboard> genre=new ArrayList<AllDashboard>();
		genre=brandService.BrandDataBySeparateProduct(data); 
		return genre;       
	}

}
 