package com.framework.controller;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List; 
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.framework.daoImplement.ChannelDaoImpl;
import com.framework.model.Channel;
import com.framework.serviceimplement.ChannelServiceImpl;


@Controller
public class ChannelController {
	
	@Value ("${channelImageUrl}")
	String channelImageUrl;
	
	@Value ("${channelImagePath}")
	String channelImagePath;
	
	
	@Autowired
	ChannelServiceImpl ChannelService;
	@Autowired
	ChannelDaoImpl ChannelDao;
	@Autowired
	ChannelDaoImpl channeldaoimpl;
	
 
@RequestMapping(value="/channelmanagement",method=RequestMethod.GET)
		public ModelAndView channel() {
		System.out.println("Inside Channel");
		List<Channel> list = ChannelService.getAllChannels();
		//System.out.println("alll channel details.."+list);
		//Map<Integer,String> map = ChannelService.getChannelName();
		ModelAndView mv = new ModelAndView();
		mv.addObject("list",list);
		mv.addObject("channelImageUrl",channelImageUrl);
		mv.setViewName("channelmanagement");
		return mv;
	}

@RequestMapping(value="/channelEditById/{channelId}",method=RequestMethod.GET)
public ModelAndView channelEditById(@PathVariable("channelId") int channelId ) {
	
	//System.out.println("channel image id=="+channelImageId);
	List<Channel> list = ChannelService.getChannels(channelId);
	System.out.println("channel data from ida bases=="+list);
	//Channel map = ChannelService.getChannelNameId(channelId);
	//System.out.println("channel name and float values in controler=="+map);
	ModelAndView mv = new ModelAndView();
	mv.addObject("list",list);
	mv.addObject("channelImageUrl",channelImageUrl);
	//mv.addObject("map",map);
	mv.setViewName("EditChannel");
	return mv;
}




@RequestMapping(value = "/AddChannel", method = RequestMethod.GET)
public ModelAndView AddChannel() {

	ModelAndView mv = new ModelAndView();
	mv.setViewName("AddChannel");			

	return mv;
}



@RequestMapping(value = "/editChannel/{a}/{spend}/{spendunit}/{streamId}", method = { RequestMethod.GET, RequestMethod.POST })
public @ResponseBody String editChannel(@PathVariable("spendunit") int spendunit, @PathVariable("a") int a, @PathVariable("spend") float spend ,@RequestParam("channelName") String channel ,
		@PathVariable("streamId") String streamId ,@RequestParam("name") String fileName , MultipartFile file){

	System.out.println("Inside Edit Channel");
	System.out.println("chanelimagepath.."+channelImagePath+"  chanel image url...."+channelImageUrl);
	System.out.println("spend======"+spend);
	System.out.println("channel======"+channel);
	String channelName=channeldaoimpl.selectChannelName(channel,a);
	System.out.println("chanel name=="+channelName);
	System.out.println("streamId=="+streamId);
	if(file==null)
	{
	System.out.println("file name is empty,no image is selected ..");
		channeldaoimpl.updateChannelName(channel,spend,a);
		System.out.println("channelname is updated.");
	}
	
	if(!channelName.isEmpty())
	 {
	try {
				/*
				 * channeldaoimpl.updateChannel(a, channel,spend,spendunit);
				 * System.out.println("channel is updated.");
				 */
		//System.out.println(file.getOriginalFilename()+"File Name");
		
		byte[] bytes = file.getBytes();
		String rootPath = channelImagePath;
		File dir = new File(rootPath + File.separator);
		
		if(!dir.exists())
			dir.mkdirs();
		// Create the file on server
		//Calendar now = Calendar.getInstance();

		File serverFile = new File(rootPath+ fileName);
		System.out.println("COMPLETE PATH"+serverFile);
		BufferedOutputStream stream = new BufferedOutputStream(
				new FileOutputStream(serverFile));
		stream.write(bytes);
		stream.close();
		//System.out.println("Data:"+a+b);
		/*System.out.println("all form data of GameInformation:"+data);*/
		/*Gson gson=new Gson();
		List<Channel> featureList = gson.fromJson(data, new TypeToken<List<Channel>>() {
			}.getType());
		System.out.println("feature list"+featureList);*/
		BufferedImage bImg=ImageIO.read(file.getInputStream()); 
		Integer width=bImg.getWidth();
		Integer height=bImg.getHeight();
		System.out.println("Height of Image:"+height+"Width of Image:"+width);
		//String im = channelImageUrl;
		//String filename = file.getOriginalFilename();
		//String name = im.concat(fileName);
		//System.out.println("Inside edit Name:"+name);
		/*
		for(Channel f:featureList) {
			System.out.println("Name Of Image of Channel"+f.getImageUrl());
			System.out.println("Inside for each loop");*/
			//channeldaoimpl.setdimension(height,width,b);
			//channeldaoimpl.updateChannel(a,name,b);	
		
		System.out.println("height.."+height+"width...."+width);
			channeldaoimpl.updateChannel(a,channel,spend,spendunit,fileName,height,width,streamId);
			System.out.println("channel is updated.");
			
		/*}*/
	}catch(Exception e) {
		System.out.println("exception"+e);
	}finally {
		String id = new String("");
		System.out.println(id);
		
	}
	
	
	return "updated";
	 }
	
	 else {
		 System.out.println("channel is already exist in table..");
		 return "exist";
	 } 
	
	
}




@RequestMapping(value = "upload", method = { RequestMethod.GET, RequestMethod.POST })
public int upload(HttpServletRequest request, HttpServletResponse response,@RequestParam("file") MultipartFile  file) {
	System.out.println("inside upload");
	System.out.println(file.getOriginalFilename());
	System.out.println(file);
	if (!file.isEmpty()) {
		try {
			byte[] bytes = file.getBytes();

			// Creating the directory to store file
			String rootPath = channelImagePath;
			System.out.println(file.getOriginalFilename());
			File dir = new File(rootPath + File.separator);
			if (!dir.exists())
				dir.mkdirs();
			BufferedImage bImg=ImageIO.read(file.getInputStream()); 
			Integer width=bImg.getWidth();
			Integer height=bImg.getHeight();
			System.out.println("Height of Image:"+height+"Width of Image:"+width);
			File serverFile = new File(rootPath+ file.getOriginalFilename());
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(serverFile));
			stream.write(bytes);
			stream.close();

			System.out.println("Server File Location="
					+ serverFile.getAbsolutePath()+"------"+stream);
			System.out.println("Inside upload");
			return 1;
		} catch (Exception e) {
			return 0;
		}
	} else {
		return -1;
	}
}




@RequestMapping(value = "/InsertChannel/{channelName}/{spend}/{spendunit}", method = { RequestMethod.GET, RequestMethod.POST })
public @ResponseBody String  InsertChannel(@PathVariable("spendunit") int spendunit,@PathVariable("channelName") String channelName,@PathVariable("spend") float spend,
		@RequestParam("file") MultipartFile file,@RequestParam("name") String fileName) {
	System.out.println("category name------" + channelName);
	System.out.println("spend ammount------" + spend);
	System.out.println("image name===" + file.getOriginalFilename());
	String channel=channeldaoimpl.selectChannel(channelName);
	System.out.println("category name=="+channel);
	if(!channelName.equals(channel))
	{
	try {

		int f =channeldaoimpl.insertchannel(channelName,spend,spendunit);
		 
		int channelid = channeldaoimpl.selectMaxChannel();

		System.out.println("channel inserted...." + f);
		System.out.println("channel id max...." + channelid);

		//System.out.println(file.getOriginalFilename() + "File Name");
		System.out.println("Inside editProduct page");
		byte[] bytes = file.getBytes();
		String rootPath =channelImagePath;
		File dir = new File(rootPath + File.separator);

		if (!dir.exists())
			dir.mkdirs();
		// Create the file on server
		// Calendar now = Calendar.getInstance();

		File serverFile = new File(rootPath + fileName);
		System.out.println("COMPLETE PATH" + serverFile);
		BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
		stream.write(bytes);
		stream.close();

		/* System.out.println("all form data of GameInformation:"+data); */
		/*
		 * Gson gson=new Gson(); List<Channel> featureList = gson.fromJson(data, new
		 * TypeToken<List<Channel>>() { }.getType());
		 * System.out.println("feature list"+featureList);
		 */
		BufferedImage bImg = ImageIO.read(file.getInputStream());
		Integer width = bImg.getWidth();
		Integer height = bImg.getHeight();
		System.out.println("Height of Image:" + height + "Width of Image:" + width);
		///String im = channelImageUrl;
		//String filename = file.getOriginalFilename();
		//String name = im.concat(fileName);

		int res = channeldaoimpl.insertChannelImage(channelid,height,width,fileName);
		System.out.println("channel image insert sucess .."+res);
		/*
		 * for(Channel f:featureList) {
		 * System.out.println("Name Of Image of Channel"+f.getImageUrl());
		 * System.out.println("Inside for each loop");
		 * categorydao.setdimension(height,width,categorImageId);
		 * categorydao.editCategory(categoryid,name,categorImageId); }
		 */
	} catch (Exception e) {
		System.out.println("exception" + e);
	}
	return "success";
	}
	else {
		/*
		 * ModelAndView mv= new ModelAndView();
		 * mv.setViewName("redirect:/categoryManagment");
		 */
	System.out.println("channel is already exist..");
	return "failure"; 
	}
	
	
}




@RequestMapping(value="deletelogo/{imageid}",method = {RequestMethod.GET,RequestMethod.POST})
		public ModelAndView deletelogo(@PathVariable("imageid") int id) {
	System.out.println("Inside Channel delete id==");	
	System.out.println("Inside Channel delete id=="+id);
	channeldaoimpl.deleteChannelLogo(id);
	System.out.println("channel image is deletd.");
			ModelAndView mv = new ModelAndView();
			mv.setViewName("redirect:/channelmanagement");
			return mv;
	}
}
