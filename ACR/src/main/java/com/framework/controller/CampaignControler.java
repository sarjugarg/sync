package com.framework.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.framework.daoImplement.NewCampaignDaoImplement;
import com.framework.model.NewCampaign;

@Controller
public class CampaignControler {
	
	@Autowired
	NewCampaignDaoImplement newcampaigndao;
	
	
	
	
	@RequestMapping(value="/campaign",method=RequestMethod.GET)
	public ModelAndView campaign()
	{
		ModelAndView mv =new ModelAndView();
		List<NewCampaign> campaign;
		campaign=newcampaigndao.showCampaign();
		System.out.println("alll campaign=="+campaign);
		mv.addObject("campaign", campaign);
		mv.setViewName("campaginManagment");
	
	
		
		return mv;	
	}
	

	@RequestMapping(value="/AddCampaign",method=RequestMethod.GET)
	public ModelAndView addCampaignPage()
	{
		List<NewCampaign> brand= new ArrayList<NewCampaign>();
		List<NewCampaign> product= new ArrayList<NewCampaign>();
		List<NewCampaign> category= new ArrayList<NewCampaign>();
		List<NewCampaign> language= new ArrayList<NewCampaign>();
		
	brand=newcampaigndao.fetchBrand();
	category=newcampaigndao.fetchCategory();
	language=newcampaigndao.fetchLanguage();		
	product=newcampaigndao.fetchProduct();
		
		ModelAndView mv =new ModelAndView();
		mv.setViewName("addCampaign");
		mv.addObject("brand",brand);
		mv.addObject("product",product);
		mv.addObject("category",category);
		mv.addObject("language",language);
		return mv;	
	}
	
	
	@RequestMapping(value="/addcampaign",method=RequestMethod.POST)
	
	public @ResponseBody ModelAndView addCampaign(@RequestBody NewCampaign newcampaign)
	{
		
		
		//System.out.println("filename."+file.getOriginalFilename());
		System.out.println("campaign details"+newcampaign);
		newcampaigndao.addCampaign(newcampaign);
		
		ModelAndView mv =new ModelAndView();
		mv.setViewName("redirect:/campaign");
		
		return mv;
	}
	

	@RequestMapping(value="/editCampaign/{campaignId}",method=RequestMethod.GET)
	public ModelAndView editCampaign(@PathVariable("campaignId") int campaignId)
	{
		System.out.println("campaign id"+campaignId);
		NewCampaign campaign=	newcampaigndao.campaignById(campaignId);
		System.out.println("campaign data="+campaign);
		ModelAndView mv =new ModelAndView();
		mv.setViewName("editCampaign");
		mv.addObject("campaign", campaign);
		return mv;
	}
	
	@RequestMapping(value="/updatecampaign",method=RequestMethod.POST)
	public  @ResponseBody int updateCampaign( @RequestBody NewCampaign newcampaign )
	{
		System.out.println(" update campaign from "+newcampaign);
		System.out.println("campaign id="+newcampaign.getCampaignId());
		int update=newcampaigndao.updateCampaign(newcampaign);
		//System.out.println("update status="+campaign);
		
	
		//mv.addObject("campaign", campaign);
		return update;
		
	}
	
	@RequestMapping(value="/deletecampaign",method=RequestMethod.POST)
	public ModelAndView deleteCampaign( @ModelAttribute("NewCampaign") NewCampaign newcampaign )
	{
		System.out.println("delete campaign "+newcampaign);
		
		newcampaigndao.deleteCampaign(newcampaign);
		//System.out.println("update status="+campaign);
		
		ModelAndView mv =new ModelAndView();
		mv.setViewName("redirect:/campaign");
		//mv.addObject("campaign", campaign);
		return mv;
		
	}
	
	
	@RequestMapping(value="/fetchBrand",method=RequestMethod.POST)
	public ModelAndView fetchBrand( @ModelAttribute("NewCampaign") NewCampaign newcampaign )
	{
		System.out.println("delete campaign "+newcampaign);
		
		newcampaigndao.deleteCampaign(newcampaign);
		//System.out.println("update status="+campaign);
		
		ModelAndView mv =new ModelAndView();
		mv.setViewName("redirect:/campaign");
		//mv.addObject("campaign", campaign);
		return mv;
		
	}
	
	

	@RequestMapping(value="/brandSchedule",method=RequestMethod.POST)
	public @ResponseBody List<NewCampaign> brandSchedule( )
	{
		

		List<NewCampaign> brand= new ArrayList<NewCampaign>();
		brand=newcampaigndao.fetchBrand();
		return brand;
	}
	
	
	@RequestMapping(value="/fetchProduct",method=RequestMethod.POST)
	public @ResponseBody List<NewCampaign> fetchProduct( )
	{
		

		List<NewCampaign> product= new ArrayList<NewCampaign>();
		product=newcampaigndao.fetchProduct();
		return product;
	
		
		
	}
	
	
	@RequestMapping(value="/fetchCategory",method=RequestMethod.POST)
	public @ResponseBody List<NewCampaign> fetchCategory( )
	{
		

		List<NewCampaign> category= new ArrayList<NewCampaign>();
		category=newcampaigndao.fetchCategory();
		return category;
	
		
		
	}
	
	
	@RequestMapping(value="/fetchLanguage",method=RequestMethod.POST)
	public @ResponseBody List<NewCampaign> fetchLanguage( )
	{
		

		List<NewCampaign> language= new ArrayList<NewCampaign>();
		language=newcampaigndao.fetchLanguage();
		return language;
	
		
		
	}
	
}
