package com.framework.daoImplement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.framework.dao.SheduleCampaignDao;
import com.framework.model.NewCampaign;
import com.framework.model.SheduleCampaign;

public class SheduleCampaignDaoImplement implements SheduleCampaignDao {


	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	
	
	@Override
	public int addsheduleCampaign(SheduleCampaign newcampaign) {
		System.out.println(jdbcTemplate);
		
		try {
		System.out.println("newcampaign details"+newcampaign);
		String query="insert into  sheduledcampaign (channnelName,campaignName	,startTime,endTime,spotCount,cost) values('"+newcampaign.getChannnelName()+"','"+newcampaign.getCampaignName()+"','"+newcampaign.getStartTime()+"','"+newcampaign.getEndTime()+"','"+newcampaign.getSpotCount()+"','"+newcampaign.getCost()+"')";
	
		
			System.out.println("query="+query);
		return jdbcTemplate.update(query);
		}
		catch(Exception ex)
		{
			
			System.out.println("excepion is"+ex);
			return 0;
		}
		
	}

	
	@Override	
public SheduleCampaign sheduleById( int campaignid) {
		
		String query="select * from  sheduledcampaign where planId="+campaignid;
				System.out.println(query);
		return jdbcTemplate.query(query,new ResultSetExtractor<SheduleCampaign>() {

			@Override
			public SheduleCampaign extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				
				//List<NewCampaign> campaignList=new ArrayList<NewCampaign>();
				SheduleCampaign newcampaign= new SheduleCampaign();
				while(rs.next())
				{
					newcampaign.setPlanId(rs.getInt("planId"));
					newcampaign.setCampaignName(rs.getString("campaignName"));
					newcampaign.setChannnelName(rs.getString("channnelName"));
					newcampaign.setStartTime(rs.getString("startTime"));
					newcampaign.setEndTime(rs.getString("endTime"));
					newcampaign.setSpotCount(rs.getInt("spotCount"));
					newcampaign.setCost(rs.getInt("cost"));
					
					//campaignList.add(newcampaign);	
				}
				
				return newcampaign;
			}});
		
		
	}
	
	
	@Override
	public int updateSchedule(SheduleCampaign newcampaign) {
		try {
			return jdbcTemplate.update("Update sheduledcampaign set campaignName='"+newcampaign.getCampaignName()+"',channnelName='"+newcampaign.getChannnelName()+"',startTime='"+newcampaign.getStartTime()+"',endTime='"+newcampaign.getEndTime()+"',spotCount='"+newcampaign.getSpotCount()+"',cost='"+newcampaign.getCost()+"' where planId='"+newcampaign.getPlanId()+"' ");
					}
			catch(Exception ex){
				System.out.println(ex);
				System.out.println("schedule Updation faild !!");
				return 0;
			}
	}


	
	@Override
	public List<SheduleCampaign> shedule() {
		
		String query="select * from sheduledcampaign order by modifiedDate  desc";
		return jdbcTemplate.query(query,new ResultSetExtractor<List<SheduleCampaign>>() {

			@Override
			public List<SheduleCampaign> extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				
				List<SheduleCampaign> campaignList=new ArrayList<SheduleCampaign>();
				while(rs.next())
				{
					SheduleCampaign newcampaign= new SheduleCampaign();
					
					
					newcampaign.setCampaignName(rs.getString("campaignName"));
					newcampaign.setChannnelName(rs.getString("channnelName"));
					newcampaign.setStartTime(rs.getString("startTime"));
					newcampaign.setEndTime(rs.getString("endTime"));
					newcampaign.setSpotCount(rs.getInt("spotCount"));
					newcampaign.setCost(rs.getInt("cost"));
					newcampaign.setPlanId(rs.getInt("planId"));
					campaignList.add(newcampaign);	
				}
				
				return campaignList;
			}});

		
	}
	
	

	@Override
	public List<SheduleCampaign> fetchChannel() {
		
		String query="select distinct(streamName) from channel_master2";
		return jdbcTemplate.query(query,new ResultSetExtractor<List<SheduleCampaign>>() {
			
			
			@Override
			public List<SheduleCampaign> extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				
				List<SheduleCampaign> campaignList=new ArrayList<SheduleCampaign>();
				while(rs.next())
				{
					SheduleCampaign newcampaign= new SheduleCampaign();
					
					
					
					newcampaign.setChannnelName(rs.getString("streamName"));
					campaignList.add(newcampaign);	
				}
				System.out.println("channel list="+campaignList);
				return campaignList;
			}});

		
	}
	
	
	@Override
	public List<SheduleCampaign> fetchCampaign() {
		
		String query="select distinct(campaignName) from newcampaigns";
		return jdbcTemplate.query(query,new ResultSetExtractor<List<SheduleCampaign>>() {

			@Override
			public List<SheduleCampaign> extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				
				List<SheduleCampaign> campaignList=new ArrayList<SheduleCampaign>();
				while(rs.next())
				{
					SheduleCampaign newcampaign= new SheduleCampaign();
					
					
					
					newcampaign.setCampaignName(rs.getString("campaignName"));
					campaignList.add(newcampaign);	
				}
				
				return campaignList;
			}});

		
	}
	

@Override
public int deleteSchedule(SheduleCampaign newcampaign) {
try {
	return jdbcTemplate.update("delete from sheduledcampaign  where planId="+newcampaign.getPlanId()+"");
			}
	catch(Exception ex){
		System.out.println(ex);
		System.out.println("Campaign deletion faild !!");
		return 0;
	}
}

	

}


