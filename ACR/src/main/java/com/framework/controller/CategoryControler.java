package com.framework.controller;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;

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

import com.framework.daoImplement.CategoryDao;
import com.framework.daoImplement.ProductDaoImpl;
import com.framework.model.Category;
import com.framework.model.Product;
import com.framework.serviceimplement.ProductServiceImpl;

@Controller
public class CategoryControler {
	
	@Value ("${categoryImagePath}")
	String categoryRootpath;
	
	@Value ("${categoryImageUrl}")
	String categoryImageurl;
	

	@Autowired
	ProductServiceImpl ProductService;
	@Autowired
	ProductDaoImpl ProductDao;
	@Autowired
	ProductDaoImpl productdaoimpl;

	@Autowired
	CategoryDao categorydao;

	@RequestMapping(value = "/categoryManagment", method = RequestMethod.GET)
	public ModelAndView category() {

		List<Category> category = categorydao.getAllCategory();

		//System.out.println("alll category dataa  ======" + category);

		ModelAndView mv = new ModelAndView();

		mv.setViewName("categoryManagement");
		mv.addObject("category", category);
		mv.addObject("categoryImageurl", categoryImageurl);

		return mv;
	}

	@RequestMapping(value = "/Addcategory", method = RequestMethod.GET)
	public ModelAndView Addcategory() {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("AddCategoryPage");

		return mv;
	}

	@RequestMapping(value = "/InsertCategory", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody String  InsertCategory(@RequestParam("categoryName") String categoryName,
			@RequestParam("file") MultipartFile file,@RequestParam("name") String fileName) {
		int a = 0;
		System.out.println("category name------" + categoryName+"...filename=="+fileName);
	
		String category=categorydao.selectCategory(categoryName);
		System.out.println("category name=="+category);
		if(!categoryName.equals(category))
		{
		try {

				/*
				 * int f = categorydao.insertCategory(categoryName); int categoryid =
				 * categorydao.selectMaxCategory();
				 * 
				 * System.out.println("category imserted...." + f);
				 * System.out.println("category id max...." + categoryid);
				 */

			System.out.println("Inside editProduct page");
			byte[] bytes = file.getBytes();
			String rootPath = categoryRootpath;
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
			String im = categoryImageurl;
			//String filename = file.getOriginalFilename();
			//String name = im.concat(fileName);

			int res = categorydao.insertCategoryImage(categoryName,height,width,fileName);
			System.out.println("category image insert sucess .."+res);
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
		System.out.println("category is alreadyexist..");
		return "failure"; 
		}
		
		
	}

	/*
	 * ModelAndView mv =new ModelAndView(); mv.setViewName("AddCategoryPage");
	 */



	

	@RequestMapping(value = "/categoryManagment/{id}", method = RequestMethod.GET)
	public ModelAndView editCategory(@PathVariable("id") int id) {
		System.out.println("id in controler==" + id);

		List<Category> category = categorydao.getCategory(id);
		System.out.println("alll category dataa from id   ======" + category);

		/*
		 * String map = categorydao.getCategoryNameId(id);
		 * System.out.println("alll category via id  ======" + map);
		 */
		ModelAndView mv = new ModelAndView();
		mv.setViewName("editCategory");
	//	mv.addObject("map", map);
		mv.addObject("categoryImageurl", categoryImageurl);
		mv.addObject("category", category);
		return mv;
	}

	@RequestMapping(value = "/editCategory/{categoryid}", method = { RequestMethod.GET,RequestMethod.POST })
	public @ResponseBody String editChannel(@RequestParam("categoryName") String categoryName,@RequestParam("name") String fileName,
			@PathVariable("categoryid") int categoryid,MultipartFile file) {

		System.out.println("Inside Edit category");
		System.out.println("category image url==="+categoryImageurl+"  image PATH...."+categoryRootpath);
		System.out.println("category id==" + categoryid);
		
		System.out.println("category name=====" + categoryName);
		
		/*String category=categorydao.selectCategoryName(categoryName,categoryid);
		System.out.println("category name id bases==="+category);*/
		/*if(!category.isEmpty())
		{*/
		try {

		//	System.out.println(file.getOriginalFilename() + "File Name");
			System.out.println("Inside editProduct page");
			byte[] bytes = file.getBytes();
			String rootPath = categoryRootpath;
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
			//String im = categoryImageurl;
		//	String filename = file.getOriginalFilename();
			//String name = im.concat(fileName);
			/*
			 * for(Channel f:featureList) {
			 * System.out.println("Name Of Image of Channel"+f.getImageUrl());
			 * System.out.println("Inside for each loop");
			 */
			//categorydao.setdimension(height, width, categorImageId);
			//categorydao.editCategory(categoryid, name, categorImageId);
			categorydao.updateCategory(categoryid,categoryName,height,width,fileName);
			
			/* } */
		} catch (Exception e) {
			System.out.println("exception" + e);
		} finally {
			String id = new String("");
			System.out.println(id);
			
		}
		
		System.out.println("update category sucessfull");
		return "updated";
		
		
	}
	
	@RequestMapping(value="deletecategorylogo/{categoryId}",method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView deletelogo(@PathVariable("categoryId") int id) {
	
System.out.println("Inside Channel delete id=="+id);
categorydao.deleteCategorylLogo(id);
System.out.println("category image is deletd.");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/categoryManagment");
		return mv;
}

}
