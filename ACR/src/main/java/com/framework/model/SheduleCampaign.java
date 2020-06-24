package com.framework.model;

public class SheduleCampaign {
	private int planId;
	private String channnelName;
	private String campaignName	;
	private String startTime;
	private String endTime;
	private int spotCount;
	private int cost;
	public int getPlanId() {
		return planId;
	}
	public void setPlanId(int planId) {
		this.planId = planId;
	}
	public String getChannnelName() {
		return channnelName;
	}
	public void setChannnelName(String channnelName) {
		this.channnelName = channnelName;
	}
	public String getCampaignName() {
		return campaignName;
	}
	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public int getSpotCount() {
		return spotCount;
	}
	public void setSpotCount(int spotCount) {
		this.spotCount = spotCount;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	@Override
	public String toString() {
		return "SheduleCampaign [planId=" + planId + ", channnelName=" + channnelName + ", campaignName=" + campaignName
				+ ", startTime=" + startTime + ", endTime=" + endTime + ", spotCount=" + spotCount + ", cost=" + cost
				+ "]";
	}
	
	
}
