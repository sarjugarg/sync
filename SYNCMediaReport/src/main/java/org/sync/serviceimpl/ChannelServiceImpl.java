package org.sync.serviceimpl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.sync.daoimpl.ChannelDaoImpl;
import org.sync.model.AllDashboard;
import org.sync.model.Channel;
import org.sync.model.Filter;
import org.sync.model.Search;
import org.sync.service.ChannelService;

public class ChannelServiceImpl implements ChannelService{

	@Autowired
	ChannelDaoImpl channelDao;

	
	@Override
	public List<AllDashboard> hourlyPlayoutForChannel(Filter f) {
		return channelDao.hourlyPlayoutForChannel(f);
	}

	@Override
	public List<AllDashboard> dailyPlayoutForChannel(Filter f) {
		return channelDao.dailyPlayoutForChannel(f);
	}

	@Override
	public List<AllDashboard> channelsDatacount() {
		return channelDao.channelsDatacount();
	}

	@Override
	public List<AllDashboard> channelsList(Filter f) {
		return channelDao.channelsList(f); 
	}
 
	@Override
	public List<AllDashboard> getDataByTopProduct(Filter f) {
		return channelDao.getDataByTopProduct(f);
	}

	@Override
	public List<AllDashboard> getDatabyBrands(Filter f) {
		return channelDao.getDatabyBrands(f);
	}

	@Override
	public List<AllDashboard> DataBySingleChannel(Integer cid, String startdate, String enddate) {
		return channelDao.DataBySingleChannel(cid, startdate, enddate);
	}
	
	@Override
	public List<Search> brandSearch(Search obj) {
		
		return channelDao.brandSearch(obj);
	}
	@Override
	public List<Search> productSearch(Search obj2){
		return channelDao.productSearch(obj2);
	}

	@Override
	public List<Search> categorySearch(Search obj3) {
		
		return channelDao.categorySearch(obj3);	}

	@Override
	public List<Search> channelSearch(Search obj4) {
		
		return channelDao.channelSearch(obj4);
	}
	
	@Override
	public String getStreamIdByStreamName(String streamName) {
		return channelDao.getStreamIdByStreamName(streamName);
	}
 
	@Override
	public List<String> totalLanguages() {
		return channelDao.totalLanguages();
 		  
	}

	@Override
	public Channel channelLogo(Integer cid) {
		return channelDao.channelLogo(cid);
	}

}
