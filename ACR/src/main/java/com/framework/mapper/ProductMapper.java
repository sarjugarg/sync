package com.framework.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.framework.model.Channel;
import com.framework.model.Product;

public class ProductMapper implements RowMapper<Product>{
	
	@Override
	public Product  mapRow(ResultSet rs, int i) throws SQLException {
		
		Product con = new Product();
		con.setProductId(rs.getInt("productId"));
		con.setProductName(rs.getString("productName"));
		con.setImageUrl(rs.getString("imageUrl"));
		con.setImageWidth(rs.getInt("imageWidth"));
		con.setImageHeight(rs.getInt("imageHeight"));
		con.setFilename(rs.getString("filename"));
		
		return con;
	}
}
