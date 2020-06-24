package com.framework.model;

import org.springframework.web.multipart.MultipartFile;

public class NewCampaign {
	
	
	
	private int  campaignId;
	private String  campaignName;
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
	public int getCampaignId() {
		return campaignId;
	}
	public void setCampaignId(int campaignId) {
		this.campaignId = campaignId;
	}
	public String getCampaignName() {
		return campaignName;
	}
	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
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
	public void setModifiedDate(String modifiedDate)  {
		this.modifiedDate = modifiedDate;
	}
	
	
	
	
	@Override
	public String toString() {
		return "NewCampaign [campaignId=" + campaignId + ", campaignName=" + campaignName + ", brand=" + brand
				+ ", product=" + product + ", category=" + category + ", sub_category=" + sub_category + ", language="
				+ language + ", description=" + description + ", audio_file=" + audio_file + ", startdDate="
				+ startdDate + ", enddDate=" + enddDate + ", modifiedDate=" + modifiedDate + "]";
	}
	
}
