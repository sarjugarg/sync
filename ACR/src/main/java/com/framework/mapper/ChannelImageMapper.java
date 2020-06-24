package com.framework.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.framework.model.Channel;

public class ChannelImageMapper implements RowMapper<Channel>{
	
	
	@Override
	public Channel  mapRow(ResultSet rs, int i) throws SQLException {
		
		Channel con = new Channel();
		con.setChannelId(rs.getInt("channelId"));
		con.setChannelImageId(rs.getInt("channelImageId"));
		con.setImageUrl(rs.getString("imageUrl"));
		con.setImageWidth(rs.getInt("imageWidth"));
		con.setImageHeight(rs.getInt("imageHeight"));
		
		
		return con;
	}

}
