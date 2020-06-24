package com.framework.dao;

import java.util.List;

import com.framework.model.NewCampaign;

public interface NewCampaignDao {
	
	public int addCampaign(NewCampaign newcampaign);
	public List<NewCampaign> showCampaign();
	int updateCampaign(NewCampaign newcampaign);
	int deleteCampaign(NewCampaign newcampaign);
	List<NewCampaign> fetchBrand();
	List<NewCampaign> fetchProduct();
	List<NewCampaign> fetchCategory();
	List<NewCampaign> fetchLanguage();
	

}
