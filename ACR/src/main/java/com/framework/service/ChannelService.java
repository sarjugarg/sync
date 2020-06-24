package com.framework.service;

import java.util.List;
import java.util.Map;

import com.framework.model.Channel;

public interface ChannelService {
	
	
	public List<Channel> getAllChannels(); 
	public Map<Integer,String> getChannelName();
	public List<Channel> getChannels(int id);
	public int updateChannel(Channel con);
}
