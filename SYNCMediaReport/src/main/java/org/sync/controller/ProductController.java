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
import org.sync.model.Filter;
import org.sync.model.Product;
import org.sync.model.SingleProduct;
import org.sync.model.AllDashboard;
import org.sync.model.Channel;
import org.sync.serviceimpl.ProductServiceImpl;

@Controller
public class ProductController {
	@Value("${productUrl}") 
	String productUrl;

	@Autowired ProductServiceImpl productService;
	@RequestMapping(value= "/ProductDashboard",method=RequestMethod.GET)
	public ModelAndView productDashboard() { 
		ModelAndView view=new ModelAndView("ProductDashboard");
        List<String> genreList=new ArrayList<String>();
        List<Channel> channelList=new ArrayList<Channel>();
        List<String> productList=new ArrayList<String>();
        Integer totalProducts=null;
        
        genreList=productService.getAllGenres();
        channelList=productService.getAllChannels();
        productList=productService.getAllProducts();
        totalProducts=productService.totalProduct();
		view.addObject("genres",genreList);
		view.addObject("channels",channelList);
		view.addObject("products",productList);
		view.addObject("totalproducts",totalProducts); 
		return view;
	}
	
	@ResponseBody
	@RequestMapping(value= "/TotalProducts",method=RequestMethod.GET)
	public Integer categoryCount() {
		Integer categoryCount;
        categoryCount=productService.totalProduct();
	    return categoryCount;
	} 
  
	@RequestMapping(value="/SingleProduct",method=RequestMethod.POST)
	public ModelAndView singleproductDashboard(@RequestBody SingleProduct product,HttpSession session) { 
		ModelAndView view=new ModelAndView("SingleProductDashboard");
		System.out.println("product value:" +product.getProduct()); 
		List<AllDashboard> singleProductData=new ArrayList<AllDashboard>();
        List<Product> productbyDescription=new ArrayList<Product>();
        List<String> creativesName=new ArrayList<String>();
        creativesName=productService.creativesByProduct(product.getProduct(),product.getStartdate(),product.getEnddate());
        String productLogo=new String();
        singleProductData=productService.singleProductData(product.getProduct(),product.getStartdate(),product.getEnddate()); 
        productLogo=productService.productLogo(product.getProduct());
        productbyDescription=productService.singleProductDescription(product.getProduct(),product.getStartdate(),product.getEnddate());
    	view.addObject("productbyDescription",productbyDescription);
        view.addObject("productdata",singleProductData);
        view.addObject("logo",productLogo); 
        session.setAttribute("logoUrl",productUrl ); 
		session.setAttribute("productbyDescription", productbyDescription);
		session.setAttribute("productdata", singleProductData);
		session.setAttribute("logo",productLogo);
		session.setAttribute("startdate", product.getStartdate()); 
		session.setAttribute("enddate",product.getEnddate());
		session.setAttribute("product", product.getProduct()); 
		session.setAttribute("datetext",product.getDatetext());
	    session.setAttribute("cardstatus",product.getCard());	
		session.setAttribute("creativesName", creativesName);
	    System.out.println("product value in session:  "+ product.getProduct());
        return view;  
	}

	@RequestMapping(value="/SingleProductDashboard",method=RequestMethod.GET)
	public String singleProductPage() {
		return "SingleProductDashboard";
	}     
	@ResponseBody
	@RequestMapping(value= "/TopProducts",method= {RequestMethod.POST})
	public List<AllDashboard> topProducts(@RequestBody Filter data,@RequestParam(value="order",defaultValue="desc",required=false)String order) {
	    data.setOrder(order); 
	    
		List<AllDashboard> products=new ArrayList<AllDashboard>();
    	products=productService.topProduct(data);
    	
		//System.out.println("get products: "+products);
		return products;
	}

	
	
	
	@ResponseBody
	@RequestMapping(value= "/getDataByChannels",method= {RequestMethod.POST})
	public List<AllDashboard> getDataByChannels(@RequestBody Filter data,@RequestParam(value="order",defaultValue="desc",required=false)String order) {
        data.setOrder(order);
    	//System.out.println("data: " +data);
    	List<AllDashboard> channelTime=new ArrayList<AllDashboard>();
    	channelTime=productService.getDatabyChannels(data);
		return channelTime;
	}

	@ResponseBody
	@RequestMapping(value= "/getDataByCategory",method= {RequestMethod.POST})
	public List<AllDashboard> getDataByCategery(@RequestBody Filter data,@RequestParam(value="order",defaultValue="desc",required=false)String order) {
        data.setOrder(order);
    	List<AllDashboard> categroyTime=new ArrayList<AllDashboard>();
    	categroyTime=productService.getDatabyCategory(data);
		return categroyTime;
	}
 
	@ResponseBody
	@RequestMapping(value= "/getDataByLanguage",method= {RequestMethod.POST})
	public List<AllDashboard> getDataByLanguage(@RequestBody Filter data,@RequestParam(value="order",defaultValue="desc",required=false)String order) {
        data.setOrder(order);
    	List<AllDashboard> languageByTime=new ArrayList<AllDashboard>();
    	languageByTime=productService.getDatabyLanguage(data);
		return languageByTime; 
	} 

	
	@ResponseBody
	@RequestMapping(value= "/getDataByDailyPlayout",method= {RequestMethod.POST})
	public List<AllDashboard> getDailyPlayoutByAOrP(@RequestBody Filter data,@RequestParam(value="order",defaultValue="desc",required=false)String order) {
        data.setOrder(order);
    	List<AllDashboard> dailyPlayout=new ArrayList<AllDashboard>();
    	dailyPlayout=productService.getDatabyDailyPlayout(data);
		return dailyPlayout;
	}

	
	@ResponseBody
	@RequestMapping(value= "/getDataByHourlyPlayout",method= {RequestMethod.POST})
	public List<AllDashboard> getDataByHourlyPlayout(@RequestBody Filter data,@RequestParam(value="order",defaultValue="desc",required=false)String order) {
        data.setOrder(order);
    	List<AllDashboard> channelTime=new ArrayList<AllDashboard>();
    	channelTime=productService.getDatabyHourlyPlayout(data);
		return channelTime;
	}
	@ResponseBody
	@RequestMapping(value= "/getTopGenreByProduct",method= {RequestMethod.POST})
	public List<AllDashboard> getTopGenreByProduct(@RequestBody Filter data,@RequestParam(value="order",defaultValue="desc",required=false)String order) {
        data.setOrder(order);
    	List<AllDashboard> genre=new ArrayList<AllDashboard>();
    	genre=productService.topGenreByProduct(data);
		return genre;
   }
 	@ResponseBody
	@RequestMapping(value= "/singleProductDataByDec",method= {RequestMethod.POST})
	public List<AllDashboard> singleProductDataByDec(@RequestBody Filter data,@RequestParam(value="order",defaultValue="desc",required=false)String order) {
        data.setOrder(order);
    	List<AllDashboard> genre=new ArrayList<AllDashboard>();
    	genre=productService.singleProductDataByDesc(data);
		return genre;
   }

	@ResponseBody
	@RequestMapping(value= "/singleCreativeData",method= {RequestMethod.POST})
	public List<AllDashboard> singleCreativeData(@RequestBody Filter data,@RequestParam(value="order",defaultValue="desc",required=false)String order) {
        data.setOrder(order);
    	List<AllDashboard> genre=new ArrayList<AllDashboard>();
    	genre=productService.CreativesData(data);
		return genre;
   }
	
	
	
}
