package org.sync.model;

public class TotalAddData {
private String totalcategories;
private String totalbrands;
private String totalproducts;
private String totalairtime;
private Integer totalplayout;
private Double spend;
public String getTotalcategories() {
	return totalcategories;
}
public void setTotalcategories(String totalcategories) {
	this.totalcategories = totalcategories;
}
public String getTotalbrands() {
	return totalbrands;
}
public void setTotalbrands(String totalbrands) {
	this.totalbrands = totalbrands;
}
public String getTotalproducts() {
	return totalproducts;
}
public void setTotalproducts(String totalproducts) {
	this.totalproducts = totalproducts;
}
public String getTotalairtime() {
	return totalairtime;
}
public void setTotalairtime(String totalairtime) {
	this.totalairtime = totalairtime;
}
public Integer getTotalplayout() {
	return totalplayout;
}
public void setTotalplayout(Integer totalplayout) {
	this.totalplayout = totalplayout;
}
public Double getSpend() {
	return spend;
}
public void setSpend(Double spend) {
	this.spend = spend;
}
@Override
public String toString() {
	return "TotalAddData [totalcategories=" + totalcategories + ", totalbrands=" + totalbrands + ", totalproducts="
			+ totalproducts + ", totalairtime=" + totalairtime + ", totalplayout=" + totalplayout + ", spend=" + spend
			+ "]";
}
}
