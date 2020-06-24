package com.framework.dao;

import java.util.List;
import java.util.Map;

import com.framework.model.Channel;
import com.framework.model.Product;

public interface ProductDao {
	
	public List<Product> getAllProduct();
	public Map<Integer,String> getProductName();
	public List<Product> getProduct(int id);
	public int updateProduct(int a,String b,int c);
}
