package com.framework.daoImplement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.framework.dao.ChannelDao;
import com.framework.mapper.ChannelImageMapper;
import com.framework.mapper.ChannelMapper;
import com.framework.model.Channel;
import com.framework.model.Feature;
import com.framework.model.User;
import com.framework.model.UserType;

public class ChannelDaoImpl implements ChannelDao{
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public List<Channel> getAllChannels(){
		List<Channel> list = jdbcTemplate.query("SELECT DISTINCT(streamName) ,imageWidth,imageHeight,imageUrl,filename,streamId,channelId,spend,spendUnit FROM channel_master2 ORDER by modifiedOn DESC", new ChannelMapper());
		return list;
	}
public List<Channel> getChannels(int id){
		List<Channel> list = jdbcTemplate.query("select * from channel_master2 where channelId='"+id+"'",new ChannelMapper());
		return list;
	}
	
public Map<Integer,String> getChannelName(){
		
		return jdbcTemplate.query("select channelId,channelName from channel", new ResultSetExtractor<Map<Integer,String>>() {

			@Override
			public Map<Integer,String> extractData(ResultSet rs2) throws SQLException, DataAccessException {
				Integer id=0;
				String name = new String("");
				Map<Integer,String> map = new LinkedHashMap<Integer,String>();
				while(rs2.next()) {
					id=rs2.getInt("channelId");
					name = rs2.getString("channelName");
					System.out.println("ChannelId:"+id+"ChannelName:"+name);
					map.put(id, name);
				}
				return map;
			}			
          });
	}
	
	
	
public Channel getChannelNameId(int channelid){
		
	
	String query="select channelName,spend ,spendUnit from channel where channelId="+channelid;
	System.out.println("query========"+query);
		return jdbcTemplate.query("select channelName,spend,spendUnit from channel where channelId="+channelid, new ResultSetExtractor<Channel>() {

			@Override
			public Channel extractData(ResultSet rs2) throws SQLException, DataAccessException {
				
				Channel channel = new Channel();
				String name = new String("");
				String map = "";
				while(rs2.next()) {
					String chanelname = rs2.getString("channelName");
				float 	spend = rs2.getFloat("spend");
				int 	spendunit = rs2.getInt("spendUnit");
				channel.setChannel(chanelname);
				channel.setSpend(spend);
				channel.setSpendUnit(spendunit);
				}
				System.out.println("All chanel names and float=="+channel);
				return channel;
			}			
          });
	}





	public int updateChannel(int a, String imageurl,int b) {
		System.out.println("Channel Image Id"+b);
		System.out.println("ImageName:"+imageurl);
		System.out.println("ChannelId:"+a);
	
	
		String query="update channel_img set channelId=?,imageUrl=? where channelImageId=?"+','+a+','+imageurl+','+b;
		System.out.println("chanel update query====="+query);
		return jdbcTemplate.update("update channel_img set channelId=?,imageUrl=? where channelImageId=?",a,imageurl,b);
	}
	
	
	
	public int setdimension(int height,int width,int id) {
		return jdbcTemplate.update("update channel_img set imageHeight=?,imageWidth=? where channelImageId=?",height,width,id);
	}
	
	public int updateChannel(int id,String channel,float spend,int spendunit,String name,int height,int width,String streamId) {
		System.out.println("inside chanel update..."+channel+id);
		System.out.println("spend value="+spend+"..spend value.."+spendunit);
		return jdbcTemplate.update("update channel_master2 set streamName=? ,spend=?,spendUnit=?,imageHeight=?,imageWidth=? ,filename=? where channelId=? and streamId=?",channel,spend,spendunit,height,width,name,id,streamId);
	}

	
	
	public int updateChannelName(String channel,float spend,int channelid) {
		System.out.println("inside chanelname update..."+channel+"spend value."+spend);
		//System.out.println("spend value="+spend+"..spend value.."+spendunit);
		return jdbcTemplate.update("update channel_master2 set streamName=? ,spend=? where channelId=?",channel,spend,channelid);
	}

	

	public Integer  selectMaxChannel() {
		System.out.println("jdbc======" + jdbcTemplate);
		return jdbcTemplate.query("SELECT Max(channelId) as channelId FROM channel ",
				new ResultSetExtractor<Integer>() {

			@Override
			public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {

				String id = new String("");
				int gameId=0;
				while (rs.next()) {
					 gameId = rs.getInt("channelId");
					System.out.println("channelId in dao==="+gameId);
					
				}
				return gameId;
			}

		});
	}
	
	

public String  selectChannel(String channel) {
	System.out.println("jdbc======" + jdbcTemplate);
	String query="SELECT channelName FROM  channel WHERE channelName="+channel;
	System.out.println("existing channel name=="+query);
	return jdbcTemplate.query("SELECT channelName FROM channel WHERE channelName='"+channel+"'",
			new ResultSetExtractor<String>() {

		@Override
		public String extractData(ResultSet rs) throws SQLException, DataAccessException {

			String id = new String("");
			String gameId="";
			while (rs.next()) {
				 gameId = rs.getString("channelName");
				System.out.println(" channelName in dao==="+gameId);
				
			}
			return gameId;
		}

	});
}


public String  selectChannelName(String channel, int id) {
	System.out.println("jdbc======" + jdbcTemplate);
	String query="SELECT streamName FROM  channel_master2 WHERE  channelId='"+id+"'";
	System.out.println("query=="+query);
	return jdbcTemplate.query(query,
			new ResultSetExtractor<String>() {

		@Override
		public String extractData(ResultSet rs) throws SQLException, DataAccessException {

			String id = new String("");
			String chanelid="";
			while (rs.next()) {
				chanelid = rs.getString("streamName");
				System.out.println(" channelName in dao==="+chanelid);
				
			}
			return chanelid;
		}

	});
}
	

public int insertchannel(String  channel ,float spend,int spendunit) {
	System.out.println("Inside Insert channel =."+channel);
	String query = "insert into channel(channelName,spend,spendUnit) values(?,?,?)"+','+channel+','+spend+','+spendunit;
			
	System.out.println("query ..."+query);

	//return jdbcTemplate.update(query,userId,date,gameId,packId);
	return jdbcTemplate.update("insert into channel(channelName,spend,spendUnit) values(?,?,?)",channel,spend,spendunit);

}

public int insertChannelImage(int  channel,int height,int width,String url) {
	System.out.println("Inside Insert categoryImage =."+channel+"...height==="+height+".....width==="+width+"...url=="+url);
	String query = "insert into channel_img (channelId,imageHeight,imageWidth,filename) values(?,?,?,?)"+channel+','+height+','+width+','+url;
			
	System.out.println("query ..."+query);

	//return jdbcTemplate.update(query,userId,date,gameId,packId);
	return jdbcTemplate.update("insert into channel_img (channelId,imageHeight,imageWidth,imageUrl) values(?,?,?,?)",channel,height,width,url);

}

public int deleteChannelLogo(int id) {
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
	return jdbcTemplate.update("update channel_master2 set imageHeight="+height+", imageWidth="+width+", filename='"+url+"' where channelId="+id+"");}
	catch(Exception ex){
		System.out.println(ex);
		
		return 0;
	}
}
	
	
}
