package org.sync.model;

public class FilterData {
	private String genre;
	private String streamname;
	private String streamid;
	private String productname;
	private String brandname;
	private String category;
	public String getStreamname() {
		return streamname;
	}
	public void setStreamname(String streamname) {
		this.streamname = streamname;
	}
	public String getStreamid() {
		return streamid;
	}
	public void setStreamid(String streamid) {
		this.streamid = streamid;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getBrandname() {
		return brandname;
	}
	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	@Override
	public String toString() {
		return "FilterData [genre=" + genre + ", streamname=" + streamname + ", streamid=" + streamid + ", productname="
				+ productname + ", brandname=" + brandname + ", category=" + category + "]";
	}
}
