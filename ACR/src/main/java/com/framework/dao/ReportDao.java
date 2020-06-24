package com.framework.dao;

import java.util.List;

import com.framework.model.ReportModel;

public interface ReportDao {

	


	public List<ReportModel> fetchAllData() ;

	List<ReportModel>fetchChannel();

	
	List<ReportModel> fetchAllFilterData(ReportModel report);

	List<ReportModel> fetchBrand(ReportModel report);

	List<ReportModel> allFilterCategory(ReportModel report);

	

	
	
}
