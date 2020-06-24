package com.framework.serviceimplement;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.framework.daoImplement.ChannelDaoImpl;
import com.framework.model.Channel;
import com.framework.service.ChannelService;

public class ChannelServiceImpl implements ChannelService{

@Autowired
ChannelDaoImpl ChannelDao;

public List<Channel> getAllChannels(){

	return ChannelDao.getAllChannels();
}

public Map<Integer,String> getChannelName(){
	return ChannelDao.getChannelName();
}

public Channel getChannelNameId(int chanelid){
	return ChannelDao.getChannelNameId(chanelid);
}

public List<Channel> getChannels(int id){

	return ChannelDao.getChannels(id);
}
public int updateChannel(Channel con) {
	return updateChannel(con);
}
}
