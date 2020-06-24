package com.framework.service;

import java.util.List;
import java.util.Map;

import com.framework.model.Channel;
import com.framework.model.Product;

public interface ProductService {
	
	public List<Product> getAllProduct(); 
	public Map<Integer,String> getProductName();
	public List<Product> getProduct(int id);
	public int updateProduct(Product con);

}
