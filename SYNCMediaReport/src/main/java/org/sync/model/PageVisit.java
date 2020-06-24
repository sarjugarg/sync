package org.sync.model;

public class PageVisit {
private Integer recentId;
private Integer userId;
private String elementType;
private String elementName;
private String url;
private String recentTimestamp;
private Integer counter;
private Integer visitOrder;
private String firstTimestamp;
private String genre;
private String streamname;
private String cid;
private String product;
private String brand;
private String language;
private String cardName;
private String logo; 
private String logoUrl;
public String getCardName() {
	return cardName;
}
public void setCardName(String cardName) {
	this.cardName = cardName;
}
public Integer getRecentId() {
	return recentId; 
}
public void setRecentId(Integer recentId) {
	this.recentId = recentId;
}
public Integer getUserId() {
	return userId;
}
public void setUserId(Integer userId) {
	this.userId = userId;
}
public String getElementType() {
	return elementType;
}
public void setElementType(String elementType) {
	this.elementType = elementType;
}
public String getElementName() {
	return elementName;
}
public void setElementName(String elementName) {
	this.elementName = elementName;
}
public String getUrl() {
	return url;
}
public void setUrl(String url) {
	this.url = url;
}
public String getRecentTimestamp() {
	return recentTimestamp;
}
public void setRecentTimestamp(String recentTimestamp) {
	this.recentTimestamp = recentTimestamp;
}
public Integer getCounter() {
	return counter;
}
public void setCounter(Integer counter) {
	this.counter = counter;
}
public Integer getVisitOrder() {
	return visitOrder;
}
public void setVisitOrder(Integer visitOrder) {
	this.visitOrder = visitOrder;
}
public String getFirstTimestamp() {
	return firstTimestamp;
}
public void setFirstTimestamp(String firstTimestamp) {
	this.firstTimestamp = firstTimestamp;
}
public String getGenre() {
	return genre;
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
public String getCid() {
	return cid;
}
public void setCid(String cid) {
	this.cid = cid;
}
public String getProduct() {
	return product;
}
public void setProduct(String product) {
	this.product = product;
}
public String getBrand() {
	return brand;
}
public void setBrand(String brand) {
	this.brand = brand;
}
public String getLanguage() {
	return language;
}
public void setLanguage(String language) {
	this.language = language;
}
@Override
public String toString() {
	return "PageVisit [recentId=" + recentId + ", userId=" + userId + ", elementType=" + elementType + ", elementName="
			+ elementName + ", url=" + url + ", recentTimestamp=" + recentTimestamp + ", counter=" + counter
			+ ", visitOrder=" + visitOrder + ", firstTimestamp=" + firstTimestamp + ", genre=" + genre + ", streamname="
			+ streamname + ", cid=" + cid + ", product=" + product + ", brand=" + brand + ", language=" + language
			+ ", cardName=" + cardName + ", logo=" + logo + "]";
}
public String getLogo() {
	return logo;
}
public void setLogo(String logo) {
	this.logo = logo;
}
public String getLogoUrl() {
	return logoUrl;
}
public void setLogoUrl(String logoUrl) {
	this.logoUrl = logoUrl;
}

 
}
