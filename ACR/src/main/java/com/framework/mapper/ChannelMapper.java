package com.framework.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.framework.model.Channel;

public class ChannelMapper implements RowMapper<Channel>{
	
	@Override
	public Channel  mapRow(ResultSet rs, int i) throws SQLException {
		
		Channel con = new Channel();
		con.setChannelId(rs.getInt("channelId"));
		//con.setChannelImageId(rs.getInt("channelImageId"));
		con.setImageUrl(rs.getString("imageUrl"));
		con.setImageWidth(rs.getInt("imageWidth"));
		con.setImageHeight(rs.getInt("imageHeight"));
		con.setSpend(rs.getFloat("spend"));
		con.setSpendUnit(rs.getInt("spendUnit"));
		con.setChannel(rs.getString("streamName"));
		con.setStreamId(rs.getString("streamId"));
		con.setFilename(rs.getString("filename"));		
		
		return con;
	}
}
