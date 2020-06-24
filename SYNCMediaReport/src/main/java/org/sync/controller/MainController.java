
package org.sync.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.sync.model.FilterData;
import org.sync.model.LogoData;
import org.sync.model.Product;
import org.sync.model.AllDashboard;
import org.sync.model.Channel;
import org.sync.model.TotalAddData;
import org.sync.model.User;
import org.sync.serviceimpl.ChannelServiceImpl;
import org.sync.serviceimpl.ProductServiceImpl;
import org.sync.serviceimpl.UserServiceImpl;


@Controller 
public class MainController {
	@Autowired ProductServiceImpl productService;
	@Autowired ChannelServiceImpl channelService;
	@Autowired
	UserServiceImpl userService;
	@RequestMapping(value= {"/","/Login"},method=RequestMethod.GET)
    public ModelAndView login() {
		ModelAndView view= new ModelAndView("Login");
        view.addObject("user",new User());
		return view;
	}

	@RequestMapping(value="/Logout",method=RequestMethod.GET)
    public ModelAndView logout(HttpSession session)
	{
		session.invalidate();
		ModelAndView view= new ModelAndView("Login");
         view.addObject("user",new User());
		return view;
	}
 
	@RequestMapping(value= {"/Main"},method=RequestMethod.POST)
    public ModelAndView savelogin(@ModelAttribute User user, HttpSession session) {
		try {	
		String verifyUser = userService.verifyUser(user);
		if (verifyUser.equals("True")) {
			User userData=new User();
			userData=userService.getUser(user);
			ModelAndView mv = new ModelAndView("Overview");
			System.out.println("userdata: " +userData);
			session.setAttribute("username", user.getUsername()); 
			session.setAttribute("userid", userData.getUserid());
			return mv; 
		} else {
			ModelAndView mv = new ModelAndView("Login");
			mv.addObject("msg", verifyUser);
			return mv;
		}		}
		 catch (Exception e) {
				System.out.println(e);
				e.printStackTrace();
				ModelAndView mv = new ModelAndView("Login");
				mv.addObject("msg", "Somthing went wrong please try again later");
				return mv;
			}
	}

	@ResponseBody      
	@RequestMapping(value= {"/dataCount"},method=RequestMethod.GET)
	public List<TotalAddData> dataCount() {
			List<TotalAddData> addData=new ArrayList<TotalAddData>();
			addData=productService.getAddDataCount();
			return addData;        
	}

	
	@RequestMapping(value= {"/Overview"},method=RequestMethod.GET)
    public ModelAndView overview() {
			ModelAndView mv = new ModelAndView("Overview");
			return mv;        
	}


	 
}
