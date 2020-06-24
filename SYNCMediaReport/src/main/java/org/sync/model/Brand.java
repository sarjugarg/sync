package org.sync.model;
public class Brand {
private String brand;
private String startdate;
private String enddate;
private String datetext;
private String card;
public String getCard() {
	return card; 
}
public String getBrand() {
	return brand; 
}    
public void setBrand(String brand) {
	this.brand = brand;
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
	return "Brand [brand=" + brand + ", startdate=" + startdate + ", enddate=" + enddate + ", datetext=" + datetext
			+ ", card=" + card + "]";
} 
}
