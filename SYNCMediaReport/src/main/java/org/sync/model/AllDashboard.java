package org.sync.model;


public class AllDashboard {
private String productname;
private String streamname;
private String timestamp_utc;
private String categoryname;
private Integer count;
private Integer playoutduration;
private String streamid;
private String date;
private Integer cid;
private Integer hours;
private Integer  timeduration;
private String language;
private String duration_name;
private String Airtime;
private String logo;
private String genre; 
private String brand;
private Double spend;
private String logoUrl;
private String creative;
public String getAirtime() {
	return Airtime; 
}
public void setAirtime(String airtime) {
	Airtime = airtime;
}
public String getLanguage() {
	return language;
}
public void setLanguage(String language) {
	this.language = language;
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
public String getTimestamp_utc() {
	return timestamp_utc;
}
public void setTimestamp_utc(String timestamp_utc) {
	this.timestamp_utc = timestamp_utc;
} 
public Integer getPlayoutduration() {
	return playoutduration;
}
public void setPlayoutduration(Integer playoutduration) {
	this.playoutduration = playoutduration;
}
public Integer getCount() {
	return count;
}
public void setCount(Integer count) {
	this.count = count;
}
public String getCategoryname() {
	return categoryname;
}
public void setCategoryname(String categoryname) {
	this.categoryname = categoryname;
}
@Override
public String toString() {
	return "AllDashboard [productname=" + productname + ", streamname=" + streamname + ", timestamp_utc="
			+ timestamp_utc + ", categoryname=" + categoryname + ", count=" + count + ", playoutduration="
			+ playoutduration + ", streamid=" + streamid + ", date=" + date + ", cid=" + cid + ", hours=" + hours
			+ ", timeduration=" + timeduration + ", language=" + language + ", duration_name=" + duration_name
			+ ", Airtime=" + Airtime + ", logo=" + logo + ", genre=" + genre + ", brand=" + brand + ", spend=" + spend
			+ ", logoUrl=" + logoUrl + ", creative=" + creative + "]";
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public Integer getHours() {
	return hours;
}
public Integer getCid() {
	return cid;
}
public void setCid(Integer cid) {
	this.cid = cid;
}
public void setHours(Integer hours) {
	this.hours = hours;
}
public String getStreamname() {
	return streamname;
}
public void setStreamname(String streamname) {
	this.streamname = streamname;
}
public Integer getTimeduration() {
	return timeduration;
}
public void setTimeduration(Integer timeduration) {
	this.timeduration = timeduration;
}
public String getDuration_name() {
	return duration_name;
}
public String getLogoUrl() {
	return logoUrl;
}
public void setLogoUrl(String logoUrl) {
	this.logoUrl = logoUrl;
}
public void setDuration_name(String duration_name) {
	this.duration_name = duration_name;
}
public String getLogo() {
	return logo;
}
public Double getSpend() {
	return spend; 
}
public void setSpend(Double spend) {
	this.spend = spend;
}
public void setLogo(String logo) {
	this.logo = logo;
}
public String getGenre() {
	return genre;
}
public void setGenre(String genre) {
	this.genre = genre;
}
public String getBrand() {
	return brand;
}
public void setBrand(String brand) {
	this.brand = brand;
}
public String getCreative() {
	return creative;
}
public void setCreative(String creative) {
	this.creative = creative;
}

}
