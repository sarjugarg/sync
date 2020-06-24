package com.framework.model;

import org.springframework.web.multipart.MultipartFile;

public class ReportModel {
	
	private int planId;
	private String channnelName;
	private String campaignName	;
	private String startTime;
	private String endTime;
	private int spotCount;
	private int cost;
	private int  campaignId;
	private int actualCount;
	private String  brand;
	private String  product;
	private String  category;
	private String  sub_category;
	private String  language;
	private String  description;
	private MultipartFile  audio_file;
	private String  startdDate;
	private String  enddDate;
	private String  modifiedDate;
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
	public int getCampaignId() {
		return campaignId;
	}
	public void setCampaignId(int campaignId) {
		this.campaignId = campaignId;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSub_category() {
		return sub_category;
	}
	public void setSub_category(String sub_category) {
		this.sub_category = sub_category;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public MultipartFile getAudio_file() {
		return audio_file;
	}
	public void setAudio_file(MultipartFile audio_file) {
		this.audio_file = audio_file;
	}
	public String getStartdDate() {
		return startdDate;
	}
	public void setStartdDate(String startdDate) {
		this.startdDate = startdDate;
	}
	public String getEnddDate() {
		return enddDate;
	}
	public void setEnddDate(String enddDate) {
		this.enddDate = enddDate;
	}
	public String getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	
	
	
	public int getActualCount() {
		return actualCount;
	}
	public void setActualCount(int actualCount) {
		this.actualCount = actualCount;
	}
	@Override
	public String toString() {
		return "ReportModel [planId=" + planId + ", channnelName=" + channnelName + ", campaignName=" + campaignName
				+ ", startTime=" + startTime + ", endTime=" + endTime + ", spotCount=" + spotCount + ", cost=" + cost
				+ ", campaignId=" + campaignId + ", brand=" + brand + ", product=" + product + ", category=" + category
				+ ", sub_category=" + sub_category + ", language=" + language + ", description=" + description
				+ ", audio_file=" + audio_file + ", startdDate=" + startdDate + ", enddDate=" + enddDate
				+ ", modifiedDate=" + modifiedDate + ", actualCount=" + actualCount +"]";
	}

	
	
	
}
