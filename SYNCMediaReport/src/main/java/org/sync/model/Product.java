package org.sync.model;

public class Product {
private String productname;
private String description;
private String timestamp_utc;
private Integer productcount;
private Integer playoutduration;
public String getProductname() {
	return productname;
}
public void setProductname(String productname) {
	this.productname = productname;
}
public String getTimestamp_utc() {
	return timestamp_utc;
}
public void setTimestamp_utc(String timestamp_utc) {
	this.timestamp_utc = timestamp_utc;
}
public Integer getProductcount() {
	return productcount;
}
public void setProductcount(Integer productcount) {
	this.productcount = productcount;
}
public Integer getPlayoutduration() {
	return playoutduration;
}
public void setPlayoutduration(Integer playoutduration) {
	this.playoutduration = playoutduration;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
@Override
public String toString() {
	return "Product [productname=" + productname + ", description=" + description + ", timestamp_utc=" + timestamp_utc
			+ ", productcount=" + productcount + ", playoutduration=" + playoutduration + "]";
}

}
