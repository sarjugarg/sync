package org.sync.model;

public class SingleProduct {
private String product;
private String startdate;
private String enddate;
private String datetext;
private String card;
public String getCard() {
	return card; 
}
public String getProduct() {
	return product;
}  
public void setProduct(String product) {
	this.product = product;
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
public String getDatetext() {
	return datetext;
}
public void setDatetext(String datetext) {
	this.datetext = datetext;
}
@Override
public String toString() {
	return "SingleProduct [product=" + product + ", startdate=" + startdate + ", enddate=" + enddate + ", datetext="
			+ datetext + ", card=" + card + "]";
}
}
