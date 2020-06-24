package com.framework.model;

public class Category {


	private int categoryImageId;
	private int categoryId;
	private int 	imageHeight;
	private int 	imageWidth;
	private String	imageUrl;
	private String	categoryName;
	private String filename; 
	
	public int getCategoryImageId() {
		return categoryImageId;
	}
	public void setCategoryImageId(int categoryImageId) {
		this.categoryImageId = categoryImageId;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
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
	
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	
	
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	@Override
	public String toString() {
		return "Category [categoryImageId=" + categoryImageId + ", categoryId=" + categoryId + ", imageHeight="
				+ imageHeight + ", imageWidth=" + imageWidth + ", imageUrl=" + imageUrl + ", categoryName=" + categoryName +",filename="+filename+"]";
	}
	
	
	
	
	
	
	
}
