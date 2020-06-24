package org.sync.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.sync.model.Filter;
import org.sync.model.AllDashboard;
import org.sync.serviceimpl.ProductServiceImpl;
@RestController
public class ProductRestController2 {
	@Autowired ProductServiceImpl productService;
	
	@RequestMapping(value="/TopChannels",method=RequestMethod.POST)
	public ResponseEntity<?> getChannelsData(@RequestBody Filter data,@RequestParam(value="order",defaultValue="desc",required=false)String order){
		data.setOrder(order);
		List<AllDashboard> hourlyPlayouts=new ArrayList<AllDashboard>();
		hourlyPlayouts=productService.getDatabyChannels(data);
		System.out.println("get hourlyPlayouts: "+hourlyPlayouts);
		try{
			if(hourlyPlayouts != null)
				return new ResponseEntity<>(hourlyPlayouts, HttpStatus.OK);
			else
				return new ResponseEntity<>("409", HttpStatus.CONFLICT);
		}
		catch(Exception e){
			e.printStackTrace();
			return new ResponseEntity<>("409", HttpStatus.CONFLICT);
		}
	}

	
	@RequestMapping(value="/DatabyCategory",method=RequestMethod.POST)
	public ResponseEntity<?> databyCategory(@RequestBody Filter data,@RequestParam(value="order",defaultValue="desc",required=false)String order){
		data.setOrder(order);
		List<AllDashboard> databyCategory=new ArrayList<AllDashboard>();
		databyCategory=productService.getDatabyCategory(data);
		System.out.println("get databyCategory: "+databyCategory);
		try{
			if(databyCategory != null)
				return new ResponseEntity<>(databyCategory, HttpStatus.OK);
			else
				return new ResponseEntity<>("409", HttpStatus.CONFLICT);
		}
		catch(Exception e){
			e.printStackTrace();
			return new ResponseEntity<>("409", HttpStatus.CONFLICT);
		}
	}

	
	@RequestMapping(value="/DatabyLanguage",method=RequestMethod.POST)
	public ResponseEntity<?> databyLanguage(@RequestBody Filter data,@RequestParam(value="order",defaultValue="desc",required=false)String order){
		data.setOrder(order);
		List<AllDashboard> databyLanguage=new ArrayList<AllDashboard>();
		databyLanguage=productService.getDatabyLanguage(data);
		System.out.println("get databyLanguage: "+databyLanguage);
		try{
			if(databyLanguage != null)
				return new ResponseEntity<>(databyLanguage, HttpStatus.OK);
			else
				return new ResponseEntity<>("409", HttpStatus.CONFLICT);
		}
		catch(Exception e){
			e.printStackTrace();
			return new ResponseEntity<>("409", HttpStatus.CONFLICT);
		}
	}

	
	@RequestMapping(value="/DatabydailyPlayouts",method=RequestMethod.POST)
	public ResponseEntity<?> DatabydailyPlayouts(@RequestBody Filter data,@RequestParam(value="order",defaultValue="desc",required=false)String order){
		data.setOrder(order);
		List<AllDashboard> dailyPlayouts=new ArrayList<AllDashboard>();
		dailyPlayouts=productService.getDatabyDailyPlayout(data);
		System.out.println("get dailyPlayouts: "+dailyPlayouts);
		try{
			if(dailyPlayouts != null)
				return new ResponseEntity<>(dailyPlayouts, HttpStatus.OK);
			else
				return new ResponseEntity<>("409", HttpStatus.CONFLICT);
		}
		catch(Exception e){
			e.printStackTrace();
			return new ResponseEntity<>("409", HttpStatus.CONFLICT);
		}
	}
	
	@RequestMapping(value="/DatabyHourlyPlayouts",method=RequestMethod.POST)
	public ResponseEntity<?> databyHourlyPlayouts(@RequestBody Filter data,@RequestParam(value="order",defaultValue="desc",required=false)String order){
		data.setOrder(order);
		List<AllDashboard> hourlyPlayouts=new ArrayList<AllDashboard>();
		hourlyPlayouts=productService.getDatabyHourlyPlayout(data);
		System.out.println("get hourlyPlayouts: "+hourlyPlayouts);
		try{
			if(hourlyPlayouts != null)
				return new ResponseEntity<>(hourlyPlayouts, HttpStatus.OK);
			else
				return new ResponseEntity<>("409", HttpStatus.CONFLICT);
		}
		catch(Exception e){
			e.printStackTrace();
			return new ResponseEntity<>("409", HttpStatus.CONFLICT);
		}
	}


}
