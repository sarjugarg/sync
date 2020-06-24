package com.framework.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import com.framework.daoImplement.ReportDaoImplement;
import com.framework.model.ReportModel;


@Controller
public class ReportControler 



{
	@Autowired 
	ReportDaoImplement reportdaoimp;

	
	@RequestMapping(value="/Report",method=RequestMethod.GET)
	public ModelAndView campaign()
	{
		//List<ReportModel> report= new ArrayList<ReportModel>();
		/*	report=	reportdaoimp.fetchAllData();
		Map<String, List<ReportModel>> map= new HashMap<String, List<ReportModel>>();
		map.put("data",report);*/
		List<ReportModel> report= new ArrayList<ReportModel>();
		report=	reportdaoimp.fetchAllData();
		ModelAndView mv =new ModelAndView();
		mv.addObject("report",report);
		mv.setViewName("Report");
		
		return mv;	
	}
	
	
	

	@RequestMapping(value="/fetchData",method=RequestMethod.POST)
	public @ResponseBody Map<String,List<ReportModel>> fetchData()
	{
		List<ReportModel> report= new ArrayList<ReportModel>();
			report=	reportdaoimp.fetchAllData();
		Map<String, List<ReportModel>> map= new HashMap<String, List<ReportModel>>();
		map.put("data",report);
		return map;	
	}
	


//****************************************/                                      /***************************************************
//****************************************/Fecth channel data to filter Controlrt/***************************************************	
	
	
	
	@RequestMapping(value="/dataFilterParams",method=RequestMethod.POST)
	public @ResponseBody  Map<String,List<ReportModel>> fetchChannel(@RequestBody ReportModel reportmodel)
	{
		
		System.out.println("data in controler==="+reportmodel);
		List<ReportModel> report= new ArrayList<ReportModel>();
		report=	reportdaoimp.fetchAllFilterData(reportmodel);
		Map<String, List<ReportModel>> map= new HashMap<String, List<ReportModel>>();
		map.put("data",report);
		return map;	
	}
	

	@RequestMapping(value="/fetchBrandFilter",method=RequestMethod.POST)
	public @ResponseBody  List<ReportModel> fetchBrand(@RequestBody ReportModel reportmodel)
	{
		
		System.out.println("data in controler==="+reportmodel);
		List<ReportModel> report= new ArrayList<ReportModel>();
		report=	reportdaoimp.fetchBrand(reportmodel);
		
		return report;	
	}
	

	@RequestMapping(value="/fetchCategoryByBrand",method=RequestMethod.POST)
	public @ResponseBody  List<ReportModel> fetchCategoryByBrand(@RequestBody ReportModel reportmodel)
	{
		
		System.out.println("data in controler==="+reportmodel);
		List<ReportModel> report= new ArrayList<ReportModel>();
		report=	reportdaoimp.allFilterCategory(reportmodel);
		
		return report;	
	}

	@RequestMapping(value="/fetchCategoryByProduct",method=RequestMethod.POST)
	public @ResponseBody  List<ReportModel> fetchCategoryByProduct(@RequestBody ReportModel reportmodel)
	{
		
		System.out.println("product in controler==="+reportmodel);
		List<ReportModel> report= new ArrayList<ReportModel>();
		report=	reportdaoimp.allFilterProduct(reportmodel);
		
		return report;	
	}
	
	@RequestMapping(value="/fetchLanguageyByProduct",method=RequestMethod.POST)
	public @ResponseBody  List<ReportModel> fetchLanguageyByProduct(@RequestBody ReportModel reportmodel)
	{
		
		System.out.println("language in controler==="+reportmodel);
		List<ReportModel> report= new ArrayList<ReportModel>();
		report=	reportdaoimp.allFilterLanguageGenre(reportmodel);
		
		return report;	
	}
	
	
	
}
