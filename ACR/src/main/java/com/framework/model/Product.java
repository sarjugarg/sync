package com.framework.model;

public class Product {
	
	int ProductImageId;
	int productId;
	int imageHeight;
	int imageWidth;
	String imageUrl;
	String productName;
	String filename;
	
	
	
	
	public int getProductImageId() {
		return ProductImageId;
	}
	public void setProductImageId(int productImageId) {
		ProductImageId = productImageId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
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
	
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	
	
	
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	@Override
	public String toString() {
		return "Product [ProductImageId=" + ProductImageId + ", productId=" + productId + ", imageHeight=" + imageHeight
				+ ", imageWidth=" + imageWidth + ", imageUrl=" + imageUrl + ", productName=" + productName + ",filename="+filename+"]";
	}
	
	
	
	
}
