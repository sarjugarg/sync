package com.framework.daoImplement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.framework.mapper.BrandMapper;
import com.framework.model.Brand;

public class BrandDao {

	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public List<Brand> getAllBrand(){
		String query="SELECT * FROM brand_backup29APR ORDER BY modifiedOn desc";
		
		System.out.println("query ........"+query);
		
		List<Brand> list = jdbcTemplate.query(query, new BrandMapper());
		
		//System.out.println("all brand details in brand dao......."+list);
		
		return list;
		
	}
	
	
public Map<Integer,String> getBrandName(){
		
		return jdbcTemplate.query("select 	brandId,brandName from brand", new ResultSetExtractor<Map<Integer,String>>() {

			@Override
			public Map<Integer,String> extractData(ResultSet rs2) throws SQLException, DataAccessException {
				Integer id=0;
				String name = new String("");
				Map<Integer,String> map = new LinkedHashMap<Integer,String>();
				while(rs2.next()) {
					id=rs2.getInt("brandId");
					name = rs2.getString("brandName");
					//System.out.println("ProductId:"+id+"ProductName:"+name);
					map.put(id, name);
					
				}
				System.out.println("data from brand ============ "+map);
				return map;
			}			
          });
	}


public String getBrandNameId(int id){
	
	return jdbcTemplate.query("select 	brandName from brand where brandId="+id, new ResultSetExtractor<String>() {

		@Override
		public String extractData(ResultSet rs2) throws SQLException, DataAccessException {
			Integer id=0;
			String name = new String("");
			Map<Integer,String> map = new LinkedHashMap<Integer,String>();
			while(rs2.next()) {
				
				name = rs2.getString("brandName");
				//System.out.println("ProductId:"+id+"ProductName:"+name);
				map.put(id, name);
				
			}
			System.out.println("data from brand ============ "+name);
			return name;
		}			
      });
}
	



public List<Brand> getBrand(int id){
	List<Brand> list = jdbcTemplate.query("select * from brand_backup29APR  where 	brandId='"+id+"'",new BrandMapper());
	System.out.println("branddata from id in dao===="+list);
	return list;
}




public int updateBrand(int a, String imageurl,int b) {
	System.out.println("Product Image Id"+a);
	System.out.println("ImageName:"+imageurl);
	System.out.println("ProductId:"+b);
	return jdbcTemplate.update("update brand_img  set 	brandId	=?,imageUrl=? where 	brandImageId=?",a,imageurl,b);
}

public int setdimension(int height,int width,int id) {
	return jdbcTemplate.update("update brand_img set imageHeight=?,imageWidth=? where brandImageId=?",height,width,id);
}
	
public int updateBrand(int id,String brand,int height ,int width,String imagename) {
	System.out.println("inside brand update..."+brand+id);
	
	return jdbcTemplate.update("update brand_backup29APR set brandName=?, imageHeight=?,imageWidth=? , filename=? where brandId=?",brand,height,width,imagename,id);
}


public int insertBrand(String  brand) {
	System.out.println("Inside Insert brand ="+brand);
	String query = "insert into brand(categoryName) values(?)"+','+brand;
			
	System.out.println("query ..."+query);

	//return jdbcTemplate.update(query,userId,date,gameId,packId);
	return jdbcTemplate.update("insert into brand(brandName) values(?)",brand);

}

public int insertBrandImage(String  brand,int height,int width,String imagename) {
	System.out.println("Inside Insert brand =."+brand+"...height==="+height+".....width==="+width+"...url=="+imagename);
	
	//return jdbcTemplate.update(query,userId,date,gameId,packId);
	return jdbcTemplate.update("insert into brand_backup29APR (brandName,imageHeight,imageWidth,filename) values(?,?,?,?)",brand,height,width,imagename);

}

public Integer  selectMaxCategory() {
	System.out.println("jdbc======" + jdbcTemplate);
	return jdbcTemplate.query("SELECT Max(brandId) as brandId FROM brand ",
			new ResultSetExtractor<Integer>() {

		@Override
		public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {

			String id = new String("");
			int gameId=0;
			while (rs.next()) {
				 gameId = rs.getInt("brandId");
				System.out.println("brandId in dao==="+gameId);
				
			}
			return gameId;
		}

	});
}
	

public String  selectBrand(String brand) {
	System.out.println("jdbc======" + jdbcTemplate);
	String brandname=brand.replaceAll("'", "\\\\'");  
	System.out.println("brandname"+brandname);
	String query="SELECT brandName FROM brand_backup29APR where brandName='"+brandname+"'";
	System.out.println("existing brand name=="+query);
	return jdbcTemplate.query("SELECT brandName FROM brand_backup29APR where brandName='"+brandname+"'",
			new ResultSetExtractor<String>() {

		@Override
		public String extractData(ResultSet rs) throws SQLException, DataAccessException {

			String id = new String("");
			String gameId="";
			while (rs.next()) {
				 gameId = rs.getString("brandName");
				System.out.println("bran name in dao==="+gameId);
				
			}
			return gameId;
		}

	});
}
	
public String  selectBrandName(String brand, int id) {
	System.out.println("jdbc======" + jdbcTemplate);
	String query="SELECT brandName FROM  brand_backup29APR WHERE brandId='"+id+"'";
	System.out.println("existing productName name=="+query);
	return jdbcTemplate.query(query,
			new ResultSetExtractor<String>() {

		@Override
		public String extractData(ResultSet rs) throws SQLException, DataAccessException {

			String id = new String("");
			String gameId="";
			while (rs.next()) {
				 gameId = rs.getString("brandName");
				System.out.println(" brandName in dao==="+gameId);
				
			}
			return gameId;
		}

	});
}


public int deleteBrandLogo(int id) {
	try {
		int height=0;
		int width =0;
		String url=null;
			/*
			 * String
			 * query="update channel_img set imageHeight=?, imageWidth=?, imageUrl=? where channelImageId=?"
			 * +','+height+','+width+','+url+','+id;
			 * System.out.println("delete query=="+query);
			 */
	return jdbcTemplate.update("update brand_backup29APR set imageHeight="+height+", imageWidth="+width+", filename='"+url+"' where brandId="+id+"");}
	catch(Exception ex){
		System.out.println(ex);
		
		return 0;
	}
}


}
