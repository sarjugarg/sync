package com.framework.daoImplement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;


import com.framework.dao.ReportDao;
import com.framework.mapper.ReportMapper;
import com.framework.model.NewCampaign;
import com.framework.model.ReportModel;
import com.framework.model.SheduleCampaign;

public class ReportDaoImplement implements ReportDao {

	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	public List<ReportModel> fetchAllData() 
	{
		
		

		
			//String query="SELECT sheduledcampaign.channnelName,sheduledcampaign.campaignName,sheduledcampaign.startTime,sheduledcampaign.endTime,sheduledcampaign.spotCount,sheduledcampaign.cost,sheduledcampaign.createdDate,sheduledcampaign.modifiedDate,sheduledcampaign.planId, newcampaigns.campaignName,newcampaigns.brand,newcampaigns.campaignId,newcampaigns.product,newcampaigns.category,newcampaigns.sub_category,newcampaigns.language,newcampaigns.description,newcampaigns.audio_file,newcampaigns.createdDate,newcampaigns.modifiedDate from sheduledcampaign LEFT JOIN newcampaigns ON sheduledcampaign.campaignName=newcampaigns.campaignName";
			String query="SELECT * FROM  campaignreport";
			System.out.println("query ........"+query);
			
			List<ReportModel> list = jdbcTemplate.query(query, new ReportMapper());
			
			System.out.println("all categor details in category dao......."+list);
			
			return list;
			
		}
		
	
	
	
	@Override
	public List<ReportModel> fetchAllFilterData(ReportModel report) 
	{
		
		StringBuilder subquery=  new StringBuilder();		

		subquery.append("select * from campaignreport where  date(startTime)=date('"+report.getStartTime()+"') and date(endTime)=date('"+report.getEndTime()+"') ");
		/*if(report.getChannnelName().equals("") && report.getBrand().equals("") && report.getProduct().equals("") && report.getCategory().equals("") && report.getLanguage().equals(""))
		{
				
		}*/
		
		if(!(("").equals(report.getChannnelName())|| report.getChannnelName()==null)  )
		{
		subquery.append("  and   channnelName IN ("+report.getChannnelName()+")");
		}
		
		if (!(("").equals(report.getBrand()) || report.getBrand()==null))
		{
			subquery.append(" and  brand IN ("+report.getBrand()+")");	
		}
		if(!(("").equals(report.getCategory()) ||report.getCategory()==null))
			
		{
			subquery.append(" and  category IN ("+report.getCategory()+")");
		}
		 if(!(("").equals(report.getProduct()) || report.getProduct()==null))
		 {
			 subquery.append(" and product IN ("+report.getProduct()+")");
		 }
		 if(!(("").equals(report.getLanguage()) ||report.getLanguage()==null))
		 {
			 
			 subquery.append(" and  language IN ("+report.getLanguage()+")");
		 }
		 
	/*	 else {
			 
			
		 
		 
			//String query="SELECT sheduledcampaign.channnelName,sheduledcampaign.campaignName,sheduledcampaign.startTime,sheduledcampaign.endTime,sheduledcampaign.spotCount,sheduledcampaign.cost,sheduledcampaign.createdDate,sheduledcampaign.modifiedDate,sheduledcampaign.planId, newcampaigns.campaignName,newcampaigns.brand,newcampaigns.campaignId,newcampaigns.product,newcampaigns.category,newcampaigns.sub_category,newcampaigns.language,newcampaigns.description,newcampaigns.audio_file,newcampaigns.createdDate,newcampaigns.modifiedDate from sheduledcampaign LEFT JOIN newcampaigns ON sheduledcampaign.campaignName=newcampaigns.campaignName";
//			 subquery.append(" WHERE channnelName IN ("+report.getChannnelName()+") and  brand IN ("+report.getBrand()+") and product IN ("+report.getProduct()+") and category IN ("+report.getCategory()+") and language IN("+report.getLanguage()+")");
		 }*/
			
		 String finalquery= new String(subquery);
		 
		 System.out.println("query ........"+finalquery);
			
			List<ReportModel> list = jdbcTemplate.query(finalquery, new ReportMapper());
			
			System.out.println("all categor details in category dao......."+list);
			
			return list;
			
		}
			
	
		
	
//*********************************fetch channel dao/***************************************************************************




	@Override	
	public List<ReportModel> fetchChannel( ) {
			
			String query="select distinct(streamName)  from  channel_master2  order by streamName ASC";
					System.out.println(query);
			return jdbcTemplate.query(query,new ResultSetExtractor<List<ReportModel>>() {

				@Override
				public List<ReportModel> extractData(ResultSet rs) throws SQLException, DataAccessException {
					// TODO Auto-generated method stub
					
					List<ReportModel> campaignList=new ArrayList<ReportModel>();
					
					while(rs.next())
					{
						ReportModel newcampaign= new ReportModel();
						newcampaign.setChannnelName(rs.getString("streamName"));
						campaignList.add(newcampaign);	
					}
					
					return campaignList;
				}});
			
			
		}


	@Override
	public List<ReportModel> fetchBrand(ReportModel report) {
		
		String query="select distinct(Brand) from  all_channels_1 where stream_name IN ("+report.getChannnelName()+")";
		System.out.println("+query"+query);
		return jdbcTemplate.query(query,new ResultSetExtractor<List<ReportModel>>() {
			
			
			@Override
			public List<ReportModel> extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				
				List<ReportModel> campaignList=new ArrayList<ReportModel>();
				while(rs.next())
				{
					ReportModel newcampaign= new ReportModel();
					
					
					
					newcampaign.setBrand(rs.getString("Brand"));
					campaignList.add(newcampaign);	
				}
				System.out.println("brandlist list="+campaignList);
				return campaignList;
			}});

		
	}
	
	
	@Override
	public List<ReportModel> allFilterCategory(ReportModel report) {
		try {
			String query="";
			System.out.println("brand name="+report);
			if(report.getChannnelName().isEmpty() && report.getChannnelName().isEmpty())
			{
				query="select distinct(categories) from all_channels_1  order by categories ASC "; 
			}
			// String query="SELECT *,ch.streamId,ch.streamName,ch.streamUrl,ch.language,ch.type,ch.status FROM all_channels_1 ch1 INNER JOIN channel_master ch ON ch1.stream_id=ch.streamId where date(ch1.timestamp_utc) between '" +fromdate+ "' and '" +endate+"' order by ch1.timestamp_utc desc limit 200 ";                         
			else if(!report.getChannnelName().isEmpty() && report.getChannnelName().isEmpty() )
			{
				query="select distinct(categories) from all_channels_1 where  stream_name in ("+report.getChannnelName()+") order by categories ASC"; 
			}
			else if(report.getChannnelName().isEmpty() && !report.getChannnelName().isEmpty() )
			{
				query="select distinct(categories) from all_channels_1 where  Brand in ("+report.getBrand()+") order by categories ASC "; 
			}
			else{
				query="select distinct(categories) from all_channels_1 where  stream_name in ("+report.getChannnelName()+") and Brand in ("+report.getBrand()+") order by categories ASC "; 
				}
			System.out.println("query to fetch all channels....."+query);
			 
			return jdbcTemplate.query(query, new ResultSetExtractor<List<ReportModel>>() {
						public List<ReportModel> extractData(ResultSet rs) throws SQLException, DataAccessException {
							List<ReportModel> channelslist= new ArrayList<ReportModel>();
							while (rs.next()) {
								ReportModel data = new ReportModel();	 
								data.setCategory(rs.getString("categories"));
								channelslist.add(data);
						}
							System.out.println("all chanels data  in dao......"+channelslist);
							return channelslist;
						}
					});
				} catch (Exception e) {
					System.out.println("exception in fetch categories"+e);
					return null;
				}	
		}
	

	
	
	
	
	public List<ReportModel> allFilterProduct(ReportModel reportmodel) {
		try {
			// String query="SELECT *,ch.streamId,ch.streamName,ch.streamUrl,ch.language,ch.type,ch.status FROM all_channels_1 ch1 INNER JOIN channel_master ch ON ch1.stream_id=ch.streamId where date(ch1.timestamp_utc) between '" +fromdate+ "' and '" +endate+"' order by ch1.timestamp_utc desc limit 200 ";                         
			String query="";
			if(reportmodel.getBrand().isEmpty() && reportmodel.getChannnelName().isEmpty() && reportmodel.getCategory().isEmpty())
				{
				System.out.println("brand,category and cahnnel is empty..");
				query="select distinct (Product) from all_channels_1 ";	
				}
			else if (!reportmodel.getBrand().isEmpty() && reportmodel.getChannnelName().isEmpty() && reportmodel.getCategory().isEmpty())
			{
				System.out.println(" cahnnel and category is empty..");
				query="select distinct (Product) from all_channels_1 where   Brand in ("+reportmodel.getBrand()+") "; 	
	
			}
			else  if(reportmodel.getBrand().isEmpty() && !reportmodel.getChannnelName().isEmpty() && reportmodel.getCategory().isEmpty() )
			{
				System.out.println(" brand and category is empty..");
				query="select distinct (Product) from all_channels_1 where   stream_name in ("+reportmodel.getChannnelName()+")"; 	
			}
			
			else  if(reportmodel.getBrand().isEmpty() && reportmodel.getChannnelName().isEmpty() && !reportmodel.getCategory().isEmpty() )
			{
				System.out.println(" brand and channel is empty..");
				query="select distinct (Product) from all_channels_1 where   categories in ("+reportmodel.getCategory()+") "; 	
			}
			
			else  if(!reportmodel.getBrand().isEmpty() && !reportmodel.getChannnelName().isEmpty() && reportmodel.getCategory().isEmpty() )
			{
				System.out.println(" category  is empty..");
				query="select distinct (Product) from all_channels_1 where   stream_name in ("+reportmodel.getChannnelName()+") and Brand in ("+reportmodel.getBrand()+")"; 	
			}
			
			else  if(reportmodel.getBrand().isEmpty() && !reportmodel.getChannnelName().isEmpty() && !reportmodel.getCategory().isEmpty() )
			{
				System.out.println(" brand is empty..");
				query="select distinct (Product) from all_channels_1 where  stream_name in ("+reportmodel.getChannnelName()+") and categories in ("+reportmodel.getCategory()+")"; 	
			}
			
			else  if(!reportmodel.getBrand().isEmpty() && reportmodel.getChannnelName().isEmpty() && !reportmodel.getCategory().isEmpty() )
			{
				System.out.println(" channel is empty..");
				query="select distinct (Product) from all_channels_1 where  Brand in ("+reportmodel.getBrand()+") and categories in ("+reportmodel.getCategory()+")"; 	
			}
			
			
			else {
				 query="select distinct (Product) from all_channels_1 where    Brand in ("+reportmodel.getBrand()+") and stream_name in ("+reportmodel.getChannnelName()+") and categories in ("+reportmodel.getCategory()+")"; 	
			}
			
			System.out.println("query to fetch all channels....."+query);
			 
			return jdbcTemplate.query(query, new ResultSetExtractor<List<ReportModel>>() {
						public List<ReportModel> extractData(ResultSet rs) throws SQLException, DataAccessException {
							List<ReportModel> channelslist= new ArrayList<ReportModel>();
							while (rs.next()) {
								ReportModel data = new ReportModel();	 
								data.setProduct(rs.getString("product"));
								channelslist.add(data);
						}
							//System.out.println("all chanels data  in dao......"+channelslist);
							return channelslist;
						}
					});
				} catch (Exception e) {
					System.out.println("exception in fetch all product"+e);
					return null;
				}	
		}
	
	
	
	
	
	
	
	
	
	
	public List<ReportModel> allFilterLanguageGenre(ReportModel report) {
		try {
			
			String query="";
			if(report.getBrand().isEmpty() && report.getChannnelName().isEmpty() && report.getCategory().isEmpty() && report.getProduct().isEmpty())
			{
				System.out.println("brand , channel  and category  and product is empty");
				 query="select distinct (stream_language) from all_channels_1"; 
			}
			else if( !report.getBrand().isEmpty() && report.getChannnelName().isEmpty() && report.getCategory().isEmpty() && report.getProduct().isEmpty())
			{
				System.out.println(" channel  and category is empty");
				query="select distinct (stream_language) from all_channels_1 where  Brand in ("+report.getBrand()+") "; 
			}
			else if( report.getBrand().isEmpty() && !report.getChannnelName().isEmpty() && report.getCategory().isEmpty() && report.getProduct().isEmpty())
			{
				System.out.println("brand   and category is empty");
				query="select distinct (stream_language)  from all_channels_1 where  stream_name in ("+report.getChannnelName()+") ";
			}
			else if( report.getBrand().isEmpty() && report.getChannnelName().isEmpty() && !report.getCategory().isEmpty() && report.getProduct().isEmpty())
			{
				System.out.println("brand and channel  is empty");
				query="select distinct (stream_language)  from all_channels_1 where categories in ("+report.getCampaignName()+") ";
			}
			
			else if( report.getBrand().isEmpty() && report.getChannnelName().isEmpty() && report.getCategory().isEmpty() && !report.getProduct().isEmpty())
			{
				System.out.println("brand and channel and category   is empty");
				query="select distinct (stream_language)  from all_channels_1 where  and product in ("+report.getProduct()+") ";
			}
			
			else if( report.getChannnelName().isEmpty() && !report.getCategory().isEmpty() && !report.getBrand().isEmpty() && !report.getProduct().isEmpty())
			{
				System.out.println(" channel  is empty");
				query="select distinct (stream_language) from all_channels_1 where  Brand ("+report.getBrand()+")  and categories in ("+report.getCategory()+") and product in ("+report.getProduct()+"'";
			}
			else if( !report.getChannnelName().isEmpty() && report.getCategory().isEmpty() && !report.getBrand().isEmpty()  && !report.getProduct().isEmpty())
			{
				System.out.println(" category is empty");
				query="select distinct (stream_language) from all_channels_1  Brand in ("+report.getBrand()+") and stream_name in ("+report.getChannnelName()+") and product in ("+report.getProduct()+") ";	
			}
			
			else if( !report.getChannnelName().isEmpty() && !report.getCategory().isEmpty() && report.getBrand().isEmpty()  && !report.getProduct().isEmpty())
			{
				System.out.println(" brand is empty");
				query="select distinct (stream_language) from all_channels_1 where  and categories in ("+report.getCategory()+") and stream_name in ("+report.getChannnelName()+") and product in ("+report.getProduct()+")";	
			}
			else if( report.getChannnelName().isEmpty() && !report.getCategory().isEmpty() && report.getBrand().isEmpty()  && !report.getProduct().isEmpty())
			{
				System.out.println(" brand is empty");
				query="select distinct (stream_language) from all_channels_1 where  and categories in ("+report.getCategory()+")  and product in ("+report.getProduct()+")";	
			}
			
			else if( !report.getChannnelName().isEmpty() && !report.getCategory().isEmpty() && !report.getBrand().isEmpty()  && report.getProduct().isEmpty())
			{
				System.out.println(" brand is empty");
				query="select distinct (stream_language) from all_channels_1 where  and categories in ("+report.getCategory()+") and stream_name in ("+report.getChannnelName()+") and Brand in ("+report.getBrand()+") ";	
			}
			
			else if( !report.getChannnelName().isEmpty() && !report.getCategory().isEmpty() && report.getBrand().isEmpty() && report.getProduct().isEmpty())
			{
				query="select distinct (stream_language) from all_channels_1 where  stream_name in ("+report.getChannnelName()+") and categories in ("+report.getCategory()+") ";
			}
			
			else if( report.getChannnelName().isEmpty() && !report.getCategory().isEmpty() && !report.getBrand().isEmpty() && report.getProduct().isEmpty())
			{
				query="select distinct (stream_language) from all_channels_1 where   Brand in ("+report.getBrand()+") and categories in ("+report.getCategory()+")";
			}
			else if( report.getChannnelName().isEmpty() && report.getCategory().isEmpty() && !report.getBrand().isEmpty() && !report.getProduct().isEmpty())
			{
				query="select distinct (stream_language) from all_channels_1 where   Brand in ("+report.getBrand()+") and product in ("+report.getProduct()+") ";
			}
			else if( !report.getChannnelName().isEmpty() && report.getCategory().isEmpty() && report.getBrand().isEmpty() && !report.getProduct().isEmpty())
			{
				query="select distinct (stream_language) from all_channels_1 where   stream_name in ("+report.getChannnelName()+") and product in ("+report.getProduct()+")";
			}
			
			else if( !report.getChannnelName().isEmpty() && report.getCategory().isEmpty() && !report.getBrand().isEmpty() && report.getProduct().isEmpty())
			{
				query="select distinct (stream_language) from all_channels_1 where stream_name in ("+report.getChannnelName()+") and Brand in ("+report.getBrand()+")";
			}
			
			else {
				System.out.println("not empty");
				 query="select distinct (stream_language) from all_channels_1 where  Brand in ("+report.getBrand()+") and stream_name in ("+report.getChannnelName()+") and categories in ("+report.getCategory()+") and product in ("+report.getProduct()+") "; 
			}
			// String query="SELECT *,ch.streamId,ch.streamName,ch.streamUrl,ch.language,ch.type,ch.status FROM all_channels_1 ch1 INNER JOIN channel_master ch ON ch1.stream_id=ch.streamId where date(ch1.timestamp_utc) between '" +fromdate+ "' and '" +endate+"' order by ch1.timestamp_utc desc limit 200 ";                         
			
			System.out.println("query to fetch all channels....."+query);
			 
			return jdbcTemplate.query(query, new ResultSetExtractor<List<ReportModel>>() {
						public List<ReportModel> extractData(ResultSet rs) throws SQLException, DataAccessException {
							List<ReportModel> channelslist= new ArrayList<ReportModel>();
							while (rs.next()) {
								ReportModel data = new ReportModel();	 
								//data.setMaster_type(rs.getNString("stream_type"));
								data.setLanguage(rs.getString("stream_language"));
								channelslist.add(data);
						}
							//System.out.println("all chanels data  in dao......"+channelslist);
							return channelslist;
						}
					});
				} catch (Exception e) {
					System.out.println("exception in fetch all chanels"+e);
					return null;
				}	
		}
	
	
	
	
	
	
	
}
