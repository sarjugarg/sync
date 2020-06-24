package com.framework.model;

public class Brand {

	private int brandImageId	;
	private int 	brandId;
	private int imageHeight;
	private int imageWidth;
	private String  	imageUrl;
	private String brandName;
	private String filename;
	public int getBrandImageId() {
		return brandImageId;
	}
	public void setBrandImageId(int brandImageId) {
		this.brandImageId = brandImageId;
	}
	public int getBrandId() {
		return brandId;
	}
	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}
	public int getImageHeight() {
		return imageHeight;
	}
	public void setImageHeight(int imageHeight) {
		this.imageHeight = imageHeight;
	}
	public int getImageWidth() {
		return imageWidth;
	}
	public void setImageWidth(int imageWidth) {
		this.imageWidth = imageWidth;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	
	
	
	
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	@Override
	public String toString() {
		return "Brand [brandImageId=" + brandImageId + ", brandId=" + brandId + ", imageHeight=" + imageHeight
				+ ", imageWidth=" + imageWidth + ", imageUrl=" + imageUrl + ", brandName=" + brandName + ",filename="+filename+"]";
	}
	
	
	
	
	
}
