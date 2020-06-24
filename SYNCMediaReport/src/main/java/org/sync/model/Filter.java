package org.sync.model;

public class Filter {
private String genre;
private String streamname;
private String streamid;
private String productname;
private String brandname;
private String startdate;
private String enddate;
private String limit;
private String order;
private String language;
private String cid;
private String time;
private String category;
private String creative ;
public String getGenre() {
	return genre;
}
public String getProductname() {
	 return productname;
}

public void setGenre(String genre) {
	this.genre = genre;
}
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
public void setProductname(String productname) {
	this.productname = productname;
}
public String getBrandname() {
	 return brandname ;
}
public void setBrandname(String brandname) {
	this.brandname = brandname;
} 
public String getStartdate() {
	return startdate;
}
public void setStartdate(String startdate) {
	this.startdate = startdate;
}
public String getEnddate() {
	return enddate;
}
public void setEnddate(String enddate) {
	this.enddate = enddate;
}
public String getLimit() {
	return limit;
}
public void setLimit(String limit) {
	this.limit = limit;
}
public String getOrder() {
	return order;
}
public void setOrder(String order) {
	this.order = order;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
public String getLanguage() {
	return language;
}
public void setLanguage(String language) {
	this.language = language;
}
public String getTime() {
	return time;
}
public void setTime(String time) {
	this.time = time;
}
public String getCid() {
	return cid;
}
public void setCid(String cid) {
	this.cid = cid;
}
public String getCreative() {
	return creative;
}
public void setCreative(String creative) {
	this.creative = creative;
}
@Override
public String toString() {
	return "Filter [genre=" + genre + ", streamname=" + streamname + ", streamid=" + streamid + ", productname="
			+ productname + ", brandname=" + brandname + ", startdate=" + startdate + ", enddate=" + enddate
			+ ", limit=" + limit + ", order=" + order + ", language=" + language + ", cid=" + cid + ", time=" + time
			+ ", category=" + category + ", creative=" + creative + "]";
}

}
