package com.framework.serviceimplement;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.framework.daoImplement.ProductDaoImpl;
import com.framework.model.Product;
import com.framework.service.ProductService;

public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductDaoImpl ProductDao;

	public List<Product> getAllProduct(){

		return ProductDao.getAllProduct();
	}

	public Map<Integer,String> getProductName(){
		return ProductDao.getProductName();
	}
	
	
	
	public String getProductNameId(int id){
		return ProductDao.getProductNameId( id);
	}
	public List<Product> getProduct(int id){

		return ProductDao.getProduct(id);
	}
	public int updateProduct(Product con) {
		return updateProduct(con);
	}

}
