package org.sync.model;

public class Category {
private String category;
private String startdate;
private String enddate;
private String datetext;
private String card;
public String getCard() {
	return card; 
}
public void setCard(String card) {
	this.card = card;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
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
	return "Category [category=" + category + ", startdate=" + startdate + ", enddate=" + enddate + ", datetext="
			+ datetext + ", card=" + card + "]";
}
}
