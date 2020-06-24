package com.framework.daoImplement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.framework.dao.ProductDao;
import com.framework.mapper.ChannelMapper;
import com.framework.mapper.ProductMapper;
import com.framework.model.Channel;
import com.framework.model.Product;

public class ProductDaoImpl implements ProductDao{
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public List<Product> getAllProduct(){
		List<Product> list = jdbcTemplate.query("select * from product_backup29APR ORDER BY modifiedOn desc", new ProductMapper());
		//System.out.println("data from product_img ============"+list);
		
		return list;
	}
	
public Map<Integer,String> getProductName(){
		
		return jdbcTemplate.query("select productId,productName from product", new ResultSetExtractor<Map<Integer,String>>() {

			@Override
			public Map<Integer,String> extractData(ResultSet rs2) throws SQLException, DataAccessException {
				Integer id=0;
				String name = new String("");
				Map<Integer,String> map = new LinkedHashMap<Integer,String>();
				while(rs2.next()) {
					id=rs2.getInt("productId");
					name = rs2.getString("productName");
					//System.out.println("ProductId:"+id+"ProductName:"+name);
					map.put(id, name);
					
				}
				System.out.println("data from product ============ "+map);
				return map;
			}			
          });
	}



public String getProductNameId(int id){
	
	System.out.println("product id="+id);
	
	String query="select productName from product where productId="+id;
	System.out.println("query========"+query);
	return jdbcTemplate.query("select productName from product where productId="+id, new ResultSetExtractor<String>() {

		@Override
		public String extractData(ResultSet rs2) throws SQLException, DataAccessException {
			
			String name = new String("");
			while(rs2.next()) {
				
				name = rs2.getString("productName");
			}
			System.out.println("data from product name ============ "+name);
			return name;
		}			
      });
}

public List<Product> getProduct(int id){
	List<Product> list = jdbcTemplate.query("select * from product_backup29APR where productId='"+id+"'",new ProductMapper());
	return list;
}

public int updateProduct(int a, String imageurl,int b) {
	System.out.println("Product Image Id"+a);
	System.out.println("ImageName:"+imageurl);
	System.out.println("ProductId:"+b);
	return jdbcTemplate.update("update product_img set productId=?,imageUrl=? where productImageId=?",a,imageurl,b);
}

public int setdimension(int height,int width,int id) {
	return jdbcTemplate.update("update product_img set imageHeight=?,imageWidth=? where productImageId=?",height,width,id);
}

public int updateProduct(int id,String product,int Height,int width,String url) {
	System.out.println("inside product update..."+product+"id=="+id+"height==="+Height+"width=="+width+"url=="+url);
	
	return jdbcTemplate.update("update product_backup29APR set productName=?,filename=?,imageHeight=?,imageWidth=? where productId=?",product,url,Height,width,id);
}



public String  selectProduct(String product) {
	System.out.println("jdbc======" + jdbcTemplate);
	String productname=product.replaceAll("'", "\\\\'");  
	System.out.println("brandname"+productname);
	String query="SELECT productName FROM product where productName="+productname;
	System.out.println("query=="+query);
	return jdbcTemplate.query("SELECT productName FROM product_backup29APR where productName='"+productname+"'",
			new ResultSetExtractor<String>() {

		@Override
		public String extractData(ResultSet rs) throws SQLException, DataAccessException {

			String id = new String("");
			String gameId="";
			while (rs.next()) {
				 gameId = rs.getString("productName");
				System.out.println("productName in dao==="+gameId);
				
			}
			return gameId;
		}

	});
}

public int insertProduct(String  product) {
	System.out.println("Inside Insert brand ="+product);
	String query = "insert into product(productName) values(?)"+','+product;
			
	System.out.println("query ..."+query);

	//return jdbcTemplate.update(query,userId,date,gameId,packId);
	return jdbcTemplate.update("insert into product(productName) values(?)",product);

}


public Integer  selectMaxProduct() {
	System.out.println("jdbc======" + jdbcTemplate);
	return jdbcTemplate.query("SELECT Max(productId) as productId FROM product ",
			new ResultSetExtractor<Integer>() {

		@Override
		public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {

			String id = new String("");
			int gameId=0;
			while (rs.next()) {
				 gameId = rs.getInt("productId");
				System.out.println("productId in dao==="+gameId);
				
			}
			return gameId;
		}

	});
}

public int insertProductImage(String  product,int height,int width,String imagename) {
	System.out.println("Inside Insert product =."+product+"...height==="+height+".....width==="+width+"...url=="+imagename);
	String query = "insert into product_backup29APR (productName,imageHeight,imageWidth,filename) values(?,?,?,?)"+','+product+','+height+','+width+','+imagename;
			
	System.out.println("query ..."+query);

	//return jdbcTemplate.update(query,userId,date,gameId,packId);
	return jdbcTemplate.update("insert into product_backup29APR (productName,imageHeight,imageWidth,filename) values(?,?,?,?)",product,height,width,imagename);

}



public String  selectProductName(String product, int id) {
	System.out.println("jdbc======" + jdbcTemplate);
	String query="SELECT productName FROM product_backup29APR  WHERE  productId='"+id+"'";
	//String query="SELECT productName FROM  product WHERE productName='"+product+"'and productId!='"+id+"'";
	System.out.println("query=="+query);
	return jdbcTemplate.query(query,
			new ResultSetExtractor<String>() {

		@Override
		public String extractData(ResultSet rs) throws SQLException, DataAccessException {

			String id = new String("");
			String gameId="";
			while (rs.next()) {
				 gameId = rs.getString("productName");
				System.out.println(" productName in dao==="+gameId);
				
			}
			return gameId;
		}

	});
}




public int deleteproductLogo(int id) {
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
	return jdbcTemplate.update("update product_backup29APR set imageHeight="+height+", imageWidth="+width+", filename='"+url+"' where productId="+id+"");}
	catch(Exception ex){
		System.out.println(ex);
		
		return 0;
	}
}

}
