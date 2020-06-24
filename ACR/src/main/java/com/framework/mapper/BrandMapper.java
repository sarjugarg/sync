package com.framework.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.framework.model.Brand;
import com.framework.model.Category;

public class BrandMapper  implements RowMapper<Brand> {

	
	@Override
	public Brand  mapRow(ResultSet rs, int i) throws SQLException {
		
		Brand brand = new Brand();
		
		brand.setBrandId(rs.getInt("brandId"));
		brand.setImageHeight(rs.getInt("imageHeight"));
		brand.setImageWidth(rs.getInt("imageWidth"));
		brand.setImageUrl(rs.getString("imageUrl"));
		brand.setBrandName(rs.getString("brandName"));

		brand.setFilename(rs.getString("filename"));
		return brand;
	}
}
