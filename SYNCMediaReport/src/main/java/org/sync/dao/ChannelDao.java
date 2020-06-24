package org.sync.dao;

import java.util.List;

import org.sync.model.AllDashboard;
import org.sync.model.Channel;
import org.sync.model.Filter;
import java.util.Set;
import org.sync.model.Search;



public interface ChannelDao {
public List<AllDashboard> hourlyPlayoutForChannel(Filter f);
public List<AllDashboard> dailyPlayoutForChannel(Filter f);
public List<AllDashboard> channelsDatacount();
public List<AllDashboard> channelsList(Filter f);
public List<AllDashboard> getDataByTopProduct(Filter f);
public List<AllDashboard> DataBySingleChannel(Integer cid,String startdate,String enddate);
public List<AllDashboard> getDatabyBrands(Filter f);
public List<Search> brandSearch(Search obj1);
public List<Search> productSearch(Search obj2);
public List<Search> categorySearch(Search obj3);
public List<Search> channelSearch(Search obj4);
public  String getStreamIdByStreamName(String streamName);
public List<String> totalLanguages();
public Channel channelLogo(Integer cid);  
}

