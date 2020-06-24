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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.framework.daoImplement.ProductDaoImpl;
import com.framework.model.Product;
import com.framework.serviceimplement.ProductServiceImpl;

@Controller
public class ProductController {

	
	@Value ("${productImageUrl}")
	String productImageUrl;
	
	@Value ("${productImagePath}")
	String productImagePath;
	
	
	@Autowired
	ProductServiceImpl ProductService;
	@Autowired
	ProductDaoImpl ProductDao;
	@Autowired
	ProductDaoImpl productdaoimpl;

	@RequestMapping(value = "/productmanagement", method = RequestMethod.GET)
	public ModelAndView channel() {
		System.out.println("Inside Product");
		List<Product> list = ProductService.getAllProduct();
		//System.out.println("all product list." + list);
		// Map<Integer,String> map = ProductService.getProductName();
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", list);
		 mv.addObject("productImageUrl",productImageUrl);
		mv.setViewName("productmanagement");
		return mv;
	}

	@RequestMapping(value = "/productEditById/{productId}", method = RequestMethod.GET)
	public ModelAndView productEditById(@PathVariable("productId") int productId) {

		List<Product> list = ProductService.getProduct(productId);
		// String map = ProductService.getProductNameId(productId);
		System.out.println("product name in edit condition..==" + list);
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", list);
		 mv.addObject("productImageUrl",productImageUrl);
		// mv.addObject("map",map);
		mv.setViewName("EditProduct");
		return mv;
	}

	@RequestMapping(value = "/AddProduct", method = RequestMethod.GET)
	public ModelAndView Addcategory() {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("AddProduct");

		return mv;
	}

	@RequestMapping(value = "/InsertProduct", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody String InsertCategory(@RequestParam("productName") String productName,
			@RequestParam("name") String fileName,	@RequestParam("file") MultipartFile file) {

		System.out.println("file  name------" +fileName);
		
		System.out.println("product  name------" + productName);
	//	System.out.println("image name===" + file.getOriginalFilename());
		String product = ProductDao.selectProduct(productName);
		if (!productName.equals(product)) {

			try {

				// int f = ProductDao.insertProduct(productName);
				// int brandid = ProductDao.selectMaxProduct();

				// System.out.println("category imserted...." + f);
				// System.out.println("category id max...." + brandid);

		//		System.out.println(file.getOriginalFilename() + "File Name");
				System.out.println("Inside editProduct page");
				byte[] bytes = file.getBytes();
				String rootPath = productImagePath;
				File dir = new File(rootPath + File.separator);

				if (!dir.exists())
					dir.mkdirs();
				// Create the file on server
				// Calendar now = Calendar.getInstance();

				File serverFile = new File(rootPath+fileName);
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
				//String im = productImageUrl;
				//String filename = file.getOriginalFilename();
				//String name = im.concat(fileName);

				int res = ProductDao.insertProductImage(productName, height, width, fileName);
				System.out.println("product image insert sucess .." + res);
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

		} else {
			System.out.println("product is exist......");
			return "failure";
		}

	}

	/*
	 * @RequestMapping(value = "/editProduct/{a}/{b}/{productname}", method = {
	 * RequestMethod.GET, RequestMethod.POST }) public @ResponseBody String
	 * editChannel(@PathVariable("productname") String
	 * productname,@PathVariable("a") int a,@PathVariable("b") int b,MultipartFile
	 * file){
	 */
	@RequestMapping(value = "/editProduct/{a}", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody String editChannel(@RequestParam("productname") String productname, @PathVariable("a") int a,
			@RequestParam("name") String fileName,MultipartFile file) {

		System.out.println("Inside Edit Product");
		System.out.println("imageurl..."+productImageUrl+"  product path..."+productImagePath);
		System.out.println("product name ==" + productname);
		String product = ProductDao.selectProductName(productname, a);
		
		
		System.out.println("file name==="+fileName);
		System.out.println("product name====" + product);
		if (!product.isEmpty()) {
			try {

				//System.out.println(file.getOriginalFilename() + "File Name");
				System.out.println("Inside editProduct page");
				byte[] bytes = file.getBytes();
				String rootPath = productImagePath;
				File dir = new File(rootPath + File.separator);

				if (!dir.exists())
					dir.mkdirs();
				// Create the file on server
				// Calendar now = Calendar.getInstance();

				File serverFile = new File(rootPath+fileName);
				System.out.println("COMPLETE PATH" + serverFile);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
				System.out.println("Data:" + a);
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
				//String im = productImageUrl;
				//String filename = file.getOriginalFilename();
				//String name = im.concat(fileName);
				/*
				 * for(Channel f:featureList) {
				 * System.out.println("Name Of Image of Channel"+f.getImageUrl());
				 * System.out.println("Inside for each loop");
				 */
				// productdaoimpl.setdimension(height,width,b);
				// productdaoimpl.updateProduct(a,name,b);
				productdaoimpl.updateProduct(a, productname, height, width, fileName);
				/* } */
			} catch (Exception e) {
				System.out.println("exception" + e);
			} finally {
				String id = new String("");
				System.out.println(id);

			}
			System.out.println("product updated.");
			return "Updated";
		}

		else {
			System.out.println("product is already exist");
			return "Exist";
		}

	}

	/*
	 * @RequestMapping(value = "/newProduct", method = { RequestMethod.GET,
	 * RequestMethod.POST }) public @ResponseBody String
	 * newProduct(@RequestParam("Product") Product product){
	 * 
	 * System.out.println("Inside Edit Product"); try {
	 * 
	 * System.out.println(file.getOriginalFilename()+"File Name");
	 * System.out.println("Inside editProduct page"); byte[] bytes =
	 * file.getBytes(); String rootPath =
	 * "/home/ubuntu/apache-tomcat-9.0.4/webapps/productImages/"; File dir = new
	 * File(rootPath + File.separator);
	 * 
	 * if(!dir.exists()) dir.mkdirs(); // Create the file on server //Calendar now =
	 * Calendar.getInstance();
	 * 
	 * File serverFile = new File(rootPath+ file.getOriginalFilename());
	 * System.out.println("COMPLETE PATH"+serverFile); BufferedOutputStream stream =
	 * new BufferedOutputStream( new FileOutputStream(serverFile));
	 * stream.write(bytes); stream.close(); System.out.println("Data:"+a+b);
	 * System.out.println("all form data of GameInformation:"+data); Gson gson=new
	 * Gson(); List<Channel> featureList = gson.fromJson(data, new
	 * TypeToken<List<Channel>>() { }.getType());
	 * System.out.println("feature list"+featureList); BufferedImage
	 * bImg=ImageIO.read(file.getInputStream()); Integer width=bImg.getWidth();
	 * Integer height=bImg.getHeight();
	 * System.out.println("Height of Image:"+height+"Width of Image:"+width); String
	 * im = "http://13.233.39.58:8080/productImages/"; String filename =    
	 * file.getOriginalFilename(); String name = im.concat(filename);
	 * 
	 * for(Channel f:featureList) {
	 * System.out.println("Name Of Image of Channel"+f.getImageUrl());
	 * System.out.println("Inside for each loop");
	 * productdaoimpl.setdimension(height,width,b);
	 * productdaoimpl.updateProduct(a,name,b); } }catch(Exception e) {
	 * System.out.println("exception"+e); }finally { String id = new String("");
	 * System.out.println(id); return id; } }
	 */

	@RequestMapping(value = "deleteproductlogo/{productId}", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView deletelogo(@PathVariable("productId") int id) {

		System.out.println("Inside product delete id==" + id);
		productdaoimpl.deleteproductLogo(id);
		System.out.println("product image is deletd.");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/productmanagement");
		return mv;
	}

}
