package com.framework.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.framework.model.Category;
import com.framework.model.ReportModel;

public class ReportMapper  implements RowMapper<ReportModel>
{ 


	@Override
	public ReportModel  mapRow(ResultSet rs, int i) throws SQLException {
		
		ReportModel report = new ReportModel();
		
		report.setChannnelName(rs.getString("channnelName"));
		report.setCampaignName(rs.getString("sheduledCampaign"));
		report.setBrand(rs.getString("brand"));
		report.setProduct(rs.getString("product"));
		report.setCategory(rs.getString("category"));
		report.setSub_category(rs.getString("sub_category"));
		report.setLanguage(rs.getString("language"));
		report.setDescription(rs.getString("description"));
		report.setPlanId(rs.getInt("reportId"));
		report.setStartdDate(rs.getString("startTime"));
		report.setEnddDate(rs.getString("endTime"));
		report.setSpotCount(rs.getInt("spotCount"));
		report.setCost(rs.getInt("cost"));
		report.setActualCount(rs.getInt("running_count"));
		//report.setCampaignId(rs.getInt("campaignId"));
	
	
		return report;
	}	
}
