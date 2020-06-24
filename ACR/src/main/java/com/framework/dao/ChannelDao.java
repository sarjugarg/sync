package com.framework.dao;

import java.util.List;
import java.util.Map;

import com.framework.model.Channel;

public interface ChannelDao {

	public List<Channel> getAllChannels();
	public Map<Integer,String> getChannelName();
	public List<Channel> getChannels(int id);
	public int updateChannel(int a,String b,int c);
}
