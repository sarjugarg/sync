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

import com.framework.daoImplement.BrandDao;
import com.framework.daoImplement.ProductDaoImpl;
import com.framework.model.Brand;
import com.framework.serviceimplement.ProductServiceImpl;

@Controller
public class BrandControler {

	
	@Value ("${brandRootPath}")
	String brandrootpath;
	
	@Value ("${brandImageUrl}")
	String imageurl;
	
	@Autowired
	ProductServiceImpl ProductService;
	@Autowired
	ProductDaoImpl ProductDao;
	@Autowired
	ProductDaoImpl productdaoimpl;

	@Autowired
	BrandDao brandDao;



	@RequestMapping(value="/brandManagement",method=RequestMethod.GET)
	public ModelAndView brand() {

		List<Brand> list = brandDao.getAllBrand();
		//Map<Integer,String> map = brandDao.getBrandName();

		//System.out.println("alll brand data dataa  ======"+list);
		//System.out.println(" brann name data   ======"+map);
		ModelAndView mv = new ModelAndView();

		mv.setViewName("BrandManagement");
		mv.addObject("brand", list);
		mv.addObject("imageurl",imageurl);
		

		return mv;
	}


	@RequestMapping(value="/brandEditById/{brandId}",method=RequestMethod.GET)
	public ModelAndView productEditById(@PathVariable("brandId") int brandImageId) {

		System.out.println("brand id=="+brandImageId);
		List<Brand> list = brandDao.getBrand(brandImageId);
		//String map = brandDao.getBrandNameId(brandImageId);

		System.out.println("brand data bases of id.."+list);

		ModelAndView mv = new ModelAndView();
		mv.addObject("brand",list);
		mv.addObject("imageurl",imageurl);
		mv.setViewName("editBrand");
		return mv;
	}



	@RequestMapping(value = "/editbrand/{brandid}", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody String editChannel(@RequestParam("BrandName") String BrandName ,@PathVariable("brandid") int brandid,
			@RequestParam("file") MultipartFile file,@RequestParam("name") String fileName){

		System.out.println("file name is."+fileName);
		System.out.println("Inside Edit brand");
		System.out.println("category id=="+brandid);
		System.out.println("brand name====="+BrandName);
		String brand =brandDao.selectBrandName(BrandName,brandid);
		System.out.println("brand name  via id=="+brand);
		System.out.println("brand path...."+brandrootpath+" ..brand image url=="+imageurl);
		if(!brand.isEmpty())
		{
			try {

				//System.out.println(file.getOriginalFilename()+"File Name");
				System.out.println("Inside editProduct page");
				byte[] bytes = file.getBytes();
				String rootPath = brandrootpath;
				File dir = new File(rootPath + File.separator);

				if(!dir.exists())
					dir.mkdirs();
				// Create the file on server
				//Calendar now = Calendar.getInstance();

				File serverFile = new File(rootPath+fileName);
				System.out.println("COMPLETE PATH"+serverFile);
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
				/*System.out.println("all form data of GameInformation:"+data);*/
				/*Gson gson=new Gson();
			List<Channel> featureList = gson.fromJson(data, new TypeToken<List<Channel>>() {
				}.getType());
			System.out.println("feature list"+featureList);*/
				BufferedImage bImg=ImageIO.read(file.getInputStream()); 
				Integer width=bImg.getWidth();
				Integer height=bImg.getHeight();
				System.out.println("Height of Image:"+height+"Width of Image:"+width);
				//String im = imageurl;
				//String filename = file.getOriginalFilename();
				//String name = im.concat(fileName);
				/*
			for(Channel f:featureList) {
				System.out.println("Name Of Image of Channel"+f.getImageUrl());
				System.out.println("Inside for each loop");*/
			//	brandDao.setdimension(height,width,brandImageId);
				//brandDao.updateBrand(brandid,name,brandImageId);
				brandDao.updateBrand(brandid, BrandName,height,width,fileName);
				/*}*/
			}catch(Exception e) {
				System.out.println("exception"+e);
			}finally {
				String id = new String("");
				//System.out.println(id);

			}
			System.out.println("brand updation is sucessfull.");
			return "updated";
		}
		else {

			System.out.println("brand is already exist..");
			return "Exist";
		}

	}	


	@RequestMapping(value = "/AddBrand", method = RequestMethod.GET)
	public ModelAndView Addcategory() {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("AddBrand");

		return mv;
	}

	@RequestMapping(value = "/InsertBrand", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody String InsertCategory(@RequestParam("brandName") String brandName,@RequestParam("name") String fileName,
			@RequestParam("file") MultipartFile file) {
	
	
	
		System.out.println("file name------" + fileName);
		System.out.println("brand name------" + brandName);
		System.out.println("image name===" + file);
		String brand=brandDao.selectBrand(brandName);
		if(!brandName.equals(brand))
		{




			try {

				/*
				 * int f = brandDao.insertBrand(brandName); int brandid =
				 * brandDao.selectMaxCategory();
				 * 
				 * System.out.println("category imserted...." + f);
				 * System.out.println("category id max...." + brandid);
				 */

			//	System.out.println(file.getOriginalFilename() + "File Name");
				
				byte[] bytes = file.getBytes();
				String rootPath = brandrootpath;
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
				//String im = imageurl;
				//String fileName = file.getOriginalFilename();
				//String name = im.concat(fileName);

				int res = brandDao.insertBrandImage(brandName,height,width,fileName);
				System.out.println("brand image insert sucess .."+res);
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
			/*
			 * ModelAndView mv= new ModelAndView();
			 * mv.setViewName("redirect:/brandManagement");
			 */
			return "sucess";
		}
		else {
			System.out.println("brand is exist......");
			return "failure";
		}



	}



	@RequestMapping(value="deletebrandlogo/{imageid}",method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView deletelogo(@PathVariable("imageid") int id) {
		System.out.println("Inside brand id=="+id);
		brandDao.deleteBrandLogo(id);
		System.out.println("brand image is deletd.");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/brandManagement");
		return mv;
	}



}
