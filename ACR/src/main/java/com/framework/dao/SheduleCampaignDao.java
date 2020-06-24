package com.framework.dao;

import java.util.List;

import com.framework.model.NewCampaign;
import com.framework.model.SheduleCampaign;

public interface SheduleCampaignDao {
	
	public List<SheduleCampaign> shedule();

	List<SheduleCampaign> fetchChannel();

	List<SheduleCampaign> fetchCampaign();



	int addsheduleCampaign(SheduleCampaign newcampaign);

	SheduleCampaign sheduleById(int campaignid);

	int updateSchedule(SheduleCampaign newcampaign);

	int deleteSchedule(SheduleCampaign newcampaign);
	

}
