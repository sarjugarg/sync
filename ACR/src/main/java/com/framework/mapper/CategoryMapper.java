package com.framework.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.framework.model.Category;
import com.framework.model.Channel;

public class CategoryMapper  implements RowMapper<Category>{
	
	
	@Override
	public Category  mapRow(ResultSet rs, int i) throws SQLException {
		
		Category category = new Category();
		
		category.setCategoryId(rs.getInt("categoryId"));
		category.setImageHeight(rs.getInt("imageHeight"));
		category.setImageWidth(rs.getInt("imageWidth"));
		category.setImageUrl(rs.getString("imageUrl"));
		category.setCategoryName(rs.getString("categoryName"));
		category.setFilename(rs.getString("filename"));
		return category;
	}	

}
