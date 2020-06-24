package com.framework.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.framework.model.Category;

public class CategoryMapperupdate  implements RowMapper<Category> {

	
	
	
	@Override
	public Category  mapRow(ResultSet rs, int i) throws SQLException {
		
		Category category = new Category();
		
		category.setCategoryId(rs.getInt("categoryId"));
		category.setCategoryImageId(rs.getInt("categoryImageId"));
		category.setImageHeight(rs.getInt("imageHeight"));
		category.setImageWidth(rs.getInt("imageWidth"));
		category.setImageUrl(rs.getString("imageUrl"));
		//category.setCategoryName(rs.getString("categoryName"));
		return category;
	}
}
