package com.framework.daoImplement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.framework.mapper.CategoryMapper;
import com.framework.model.Category;

public class CategoryDao {
	
	
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	
	public List<Category> getAllCategory(){
		String query="SELECT DISTINCT(categoryName) ,imageUrl,categoryId,imageHeight,imageWidth,filename FROM category_backup group  BY categoryName order by modifiedOn desc";
		
		System.out.println("query ........"+query);
		
		List<Category> list = jdbcTemplate.query(query, new CategoryMapper());
		
		//System.out.println("all categor details in category dao......."+list);
		
		return list;
		
	}
	
	
	public int insertCategory(String  category) {
		System.out.println("Inside Insert categoryname =."+category);
		String query = "insert into category(categoryName) values(?)"+','+category;
				
		System.out.println("query ..."+query);

		//return jdbcTemplate.update(query,userId,date,gameId,packId);
		return jdbcTemplate.update("insert into category(categoryName) values(?)",category);

	}
	
	public int insertCategoryImage(String  category,int height,int width,String url) {
		System.out.println("Inside Insert categoryImage =."+category+"...height==="+height+".....width==="+width+"...url=="+url);
	
		//return jdbcTemplate.update(query,userId,date,gameId,packId);
		return jdbcTemplate.update("insert into category_backup (categoryName,imageHeight,imageWidth,filename) values(?,?,?,?)",category,height,width,url);

	}
	
	
	
	public Integer  selectMaxCategory() {
		System.out.println("jdbc======" + jdbcTemplate);
		return jdbcTemplate.query("SELECT Max(categoryId) as categoryId FROM category ",
				new ResultSetExtractor<Integer>() {

			@Override
			public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {

				int gameId=0;
				while (rs.next()) {
					 gameId = rs.getInt("categoryId");
					System.out.println("categoryid in dao==="+gameId);
					
				}
				return gameId;
			}

		});
	}
	
public Map<Integer,String> getCategoryName(){
		
		return jdbcTemplate.query("select categoryId,categoryName from category", new ResultSetExtractor<Map<Integer,String>>() {

			@Override
			public Map<Integer,String> extractData(ResultSet rs2) throws SQLException, DataAccessException {
				Integer id=0;
				String name = new String("");
				Map<Integer,String> map = new LinkedHashMap<Integer,String>();
				while(rs2.next()) {
					id=rs2.getInt("categoryId");
					name = rs2.getString("categoryName");
					//System.out.println("ProductId:"+id+"ProductName:"+name);
					map.put(id, name);
					
				}
				System.out.println("data from category ============ "+map);
				return map;
			}			
          });
	}


public String getCategoryNameId(int id){
	
	return jdbcTemplate.query("select categoryName from category where categoryId="+id, new ResultSetExtractor<String>() {

		@Override
		public String extractData(ResultSet rs2) throws SQLException, DataAccessException {
			String name = new String("");
			while(rs2.next()) {
			name = rs2.getString("categoryName");
				//System.out.println("ProductId:"+id+"ProductName:"+name);
			}
			System.out.println("data from category ============ "+name);
			return name;
		}			
      });
}
	
	
	public List<Category> getCategory(int id){
		List<Category> list = jdbcTemplate.query("select * from category_backup  where categoryId='"+id+"'",new CategoryMapper());
		System.out.println("data from id in dao===="+list);
		return list;
	}
	
	
	
	public int editCategory(int a, String imageurl,int b) {
		System.out.println("Product Image Id"+a);
		System.out.println("ImageName:"+imageurl);
		System.out.println("ProductId:"+b);
		String query="update category_img set categoryId=?,imageUrl=? where 	categoryImageId=?"+','+a+','+imageurl+','+b;
		
		System.out.println("queru for update image name=="+query);
		
		return jdbcTemplate.update("update category_img set categoryId=?,imageUrl=? where 	categoryImageId=?",a,imageurl,b);
	}

	public int setdimension(int height,int width,int id) {
		return jdbcTemplate.update("update category_img set imageHeight=?,imageWidth=? where 	categoryImageId=?",height,width,id);
	}
	

	public int updateCategory(int id,String category,int height ,int width ,String imagename) {
		System.out.println("inside ctegory update..."+category+id);
		
		return jdbcTemplate.update("update category_backup set categoryName=?, imageHeight=?,imageWidth=? , filename=? where categoryId=?",category,height,width,imagename,id);
	}
	
	

public String  selectCategory(String category) {
	System.out.println("jdbc======" + jdbcTemplate);
	String categoryname=category.replaceAll("'", "\\\\'");  
	System.out.println("category"+categoryname);
	String query="SELECT categoryName FROM  category_backup WHERE categoryName="+categoryname;
	System.out.println("existing brand name=="+query);
	return jdbcTemplate.query("SELECT categoryName FROM category_backup WHERE categoryName='"+categoryname+"'",
			new ResultSetExtractor<String>() {

		@Override
		public String extractData(ResultSet rs) throws SQLException, DataAccessException {

			String gameId="";
			while (rs.next()) {
				 gameId = rs.getString("categoryName");
				System.out.println(" categoryName in dao==="+gameId);
				
			}
			return gameId;
		}

	});
}



public String  selectCategoryName(String category, int id) {
	System.out.println("jdbc======" + jdbcTemplate);
	String query="SELECT categoryName FROM category_backup WHERE  categoryId='"+id+"'";
	System.out.println("existing channel name=="+query);
	return jdbcTemplate.query(query,
			new ResultSetExtractor<String>() {

		@Override
		public String extractData(ResultSet rs) throws SQLException, DataAccessException {
			String gameId="";
			while (rs.next()) {
				 gameId = rs.getString("categoryName");
				System.out.println(" categoryName in dao==="+gameId);
				
			}
			return gameId;
		}

	});
}


public int deleteCategorylLogo(int id) {
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
	return jdbcTemplate.update("update category_backup set imageHeight="+height+", imageWidth="+width+", filename='"+url+"' where 	categoryId="+id+"");}
	catch(Exception ex){
		System.out.println(ex);
		
		return 0;
	}

}
}
