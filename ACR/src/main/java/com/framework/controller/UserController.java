package com.framework.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.framework.model.User;
import com.framework.model.UserType;
import com.framework.serviceimplement.UserServiceImpl;
import com.framework.serviceimplement.UserTypeServiceImpl;

/*################################################################################################################################################################################################ 
 *                                                                      #####################
 *                                                                      #  USER MANAGEMENT  #
 *                                                                      #####################
 * ###############################################################################################################################################################################################
 * */



@Controller
public class UserController {
	
	@Autowired
	UserServiceImpl userService;
	@Autowired
	UserTypeServiceImpl userTypeService;
	//READ
	@RequestMapping(value="fwusermanagement",method=RequestMethod.GET)
	public ModelAndView getUser() {
		
		List<User> users=userService.getAllUser();
		List<UserType> usertype=userTypeService.getAllUserType();
		ModelAndView mv=new ModelAndView("fwusermanagement");
		mv.addObject("users", users);
		mv.addObject("usertype",usertype);
		return mv;
	}
	
	//CREATE
	@RequestMapping(value="fwadduser",method=RequestMethod.POST)
	public ModelAndView addUser(@ModelAttribute User user,HttpSession session) {
		String servermessage=userService.addUser(user,session.getAttribute("username").toString());
		ModelAndView mv= new ModelAndView("redirect:/fwusermanagement");
		System.out.println(servermessage);
		mv.addObject("servermessage",servermessage);
		return mv;
	}
	
	//UPDATE
	@RequestMapping(value="fwupdateuser",method=RequestMethod.POST)
	public ModelAndView updateUser(@ModelAttribute User user,HttpSession session) {
		String servermessage=userService.updateUser(user,session.getAttribute("username").toString());
		ModelAndView mv= new ModelAndView("redirect:/fwusermanagement");
		System.out.println(servermessage);
		mv.addObject("servermessage",servermessage);
		return mv;
	}
	
	//DELETE
	@RequestMapping(value="fwdeleteuser",method=RequestMethod.POST)
	public ModelAndView deleteUser(@ModelAttribute User user,HttpSession session) {
		String servermessage=userService.deleteUser(user,session.getAttribute("username").toString());
		ModelAndView mv= new ModelAndView("redirect:/fwusermanagement");
		System.out.println(servermessage);
		mv.addObject("servermessage",servermessage);
		return mv;
	}
}
