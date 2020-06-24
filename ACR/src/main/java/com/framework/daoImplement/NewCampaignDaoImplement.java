package com.framework.daoImplement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.util.SystemPropertyUtils;

import com.framework.dao.NewCampaignDao;
import com.framework.model.Feature;
import com.framework.model.NewCampaign;
import com.framework.model.SheduleCampaign;

public class NewCampaignDaoImplement implements NewCampaignDao
	{

	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public int addCampaign(NewCampaign newcampaign) {
		System.out.println(jdbcTemplate);
		
		try {
		System.out.println("newcampaign details"+newcampaign);
		String query="insert into  newcampaigns (campaignName,brand,product,category,sub_category,language,description,audio_file) values('"+newcampaign.getCampaignName()+"','"+newcampaign.getBrand()+"','"+newcampaign.getProduct()+"','"+newcampaign.getCategory()+"','"+newcampaign.getSub_category()+"','"+newcampaign.getLanguage()+"','"+newcampaign.getDescription()+"','"+newcampaign.getAudio_file()+"')";
	
		
			System.out.println("query="+query);
		return jdbcTemplate.update(query);
		}
		catch(Exception ex)
		{
			
			System.out.println("excepion is"+ex);
			return 0;
		}
		
	}

	public List<NewCampaign> showCampaign() {
		
		String query="select * from  newcampaigns order by modifiedDate  desc";
		System.out.println(query);
		return jdbcTemplate.query(query,new ResultSetExtractor<List<NewCampaign>>() {

			@Override
			public List<NewCampaign> extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				
				List<NewCampaign> campaignList=new ArrayList<NewCampaign>();
				while(rs.next())
				{
					NewCampaign newcampaign= new NewCampaign();
					newcampaign.setCampaignName(rs.getString("campaignName"));
					newcampaign.setBrand(rs.getString("brand"));
					newcampaign.setProduct(rs.getString("product"));
					newcampaign.setCategory(rs.getString("category"));
					newcampaign.setSub_category(rs.getString("sub_category"));
					newcampaign.setLanguage(rs.getString("language"));
					newcampaign.setDescription(rs.getString("description"));
					newcampaign.setCampaignId(rs.getInt("campaignId"));
					//newcampaign.setAudio_file(rs.getString("audio_file"));
					newcampaign.setModifiedDate(rs.getString("modifiedDate"));
					campaignList.add(newcampaign);	
				}
				
				return campaignList;
			}});
		
		
	}
	
	
	
public NewCampaign campaignById( int campaignid) {
		
		String query="select * from  newcampaigns where campaignId="+campaignid;
				System.out.println(query);
		return jdbcTemplate.query(query,new ResultSetExtractor<NewCampaign>() {

			@Override
			public NewCampaign extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				
				//List<NewCampaign> campaignList=new ArrayList<NewCampaign>();
				NewCampaign newcampaign= new NewCampaign();
				while(rs.next())
				{
					
					newcampaign.setCampaignName(rs.getString("campaignName"));
					newcampaign.setBrand(rs.getString("brand"));
					newcampaign.setProduct(rs.getString("product"));
					newcampaign.setCategory(rs.getString("category"));
					newcampaign.setSub_category(rs.getString("sub_category"));
					newcampaign.setLanguage(rs.getString("language"));
					newcampaign.setDescription(rs.getString("description"));
					newcampaign.setCampaignId(rs.getInt("campaignId"));
					//newcampaign.setAudio_file(rs.getString("audio_file"));
					newcampaign.setModifiedDate(rs.getString("modifiedDate"));
					//campaignList.add(newcampaign);	
				}
				
				return newcampaign;
			}});
		
		
	}
	
	
@Override
public int updateCampaign(NewCampaign newcampaign) {
	try {
		return jdbcTemplate.update("Update newcampaigns set campaignName='"+newcampaign.getCampaignName()+"',brand='"+newcampaign.getBrand()+"',language='"+newcampaign.getLanguage()+"',description='"+newcampaign.getDescription()+"',sub_category='"+newcampaign.getSub_category()+"',audio_file='"+newcampaign.getAudio_file()+"',category='"+newcampaign.getCategory()+"',product='"+newcampaign.getProduct()+"' where campaignId="+newcampaign.getCampaignId()+"");
				}
		catch(Exception ex){
			System.out.println(ex);
			System.out.println("Campaign Updation faild !!");
			return 0;
		}
}

	

@Override
public int deleteCampaign(NewCampaign newcampaign) {
try {
	return jdbcTemplate.update("delete from newcampaigns  where campaignId="+newcampaign.getCampaignId()+"");
			}
	catch(Exception ex){
		System.out.println(ex);
		System.out.println("Campaign deletion faild !!");
		return 0;
	}
}

@Override
public List<NewCampaign> fetchBrand() {
	
	String query="select distinct(brandName) from  brand_backup29APR";
	return jdbcTemplate.query(query,new ResultSetExtractor<List<NewCampaign>>() {
		
		
		@Override
		public List<NewCampaign> extractData(ResultSet rs) throws SQLException, DataAccessException {
			// TODO Auto-generated method stub
			
			List<NewCampaign> campaignList=new ArrayList<NewCampaign>();
			while(rs.next())
			{
				NewCampaign newcampaign= new NewCampaign();
				
				
				
				newcampaign.setBrand(rs.getString("brandName"));
				campaignList.add(newcampaign);	
			}
			System.out.println("brandlist list="+campaignList);
			return campaignList;
		}});

	
}

@Override
public List<NewCampaign> fetchProduct() {
	
	String query="select distinct(productName) from   product_backup29APR";
	return jdbcTemplate.query(query,new ResultSetExtractor<List<NewCampaign>>() {
		
		
		@Override
		public List<NewCampaign> extractData(ResultSet rs) throws SQLException, DataAccessException {
			// TODO Auto-generated method stub
			
			List<NewCampaign> campaignList=new ArrayList<NewCampaign>();
			while(rs.next())
			{
				NewCampaign newcampaign= new NewCampaign();
				
				
				
				newcampaign.setProduct(rs.getString("productName"));
				campaignList.add(newcampaign);	
			}
			System.out.println("productName list="+campaignList);
			return campaignList;
		}});

	
}


@Override
public List<NewCampaign> fetchCategory() {
	
	String query="select distinct(categoryName) from   category_backup";
	return jdbcTemplate.query(query,new ResultSetExtractor<List<NewCampaign>>() {
		
		
		@Override
		public List<NewCampaign> extractData(ResultSet rs) throws SQLException, DataAccessException {
			// TODO Auto-generated method stub
			
			List<NewCampaign> campaignList=new ArrayList<NewCampaign>();
			while(rs.next())
			{
				NewCampaign newcampaign= new NewCampaign();
				
				
				
				newcampaign.setCategory(rs.getString("categoryName"));
				campaignList.add(newcampaign);	
			}
			System.out.println("categoryName list="+campaignList);
			return campaignList;
		}});

	
}

@Override
public List<NewCampaign> fetchLanguage() {
	
	String query="select  distinct(language) from channel_master2 where language!='NULL'";
	return jdbcTemplate.query(query,new ResultSetExtractor<List<NewCampaign>>() {
		
		
		@Override
		public List<NewCampaign> extractData(ResultSet rs) throws SQLException, DataAccessException {
			// TODO Auto-generated method stub
			
			List<NewCampaign> campaignList=new ArrayList<NewCampaign>();
			while(rs.next())
			{
				NewCampaign newcampaign= new NewCampaign();
				
				
				
				newcampaign.setLanguage(rs.getString("language"));
				campaignList.add(newcampaign);	
			}
			System.out.println("language list="+campaignList);
			return campaignList;
		}});

	
}


}
	

