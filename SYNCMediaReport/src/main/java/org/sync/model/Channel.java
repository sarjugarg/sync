package org.sync.model;

public class Channel { 
private  String streamid;
private String streamname;
private String genre;
private String language;
private String startdate;
private String enddate;
private Integer cid;
private String datetext;
private String card;
private String logo;
public String getCard() {
	return card; 
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
@Override
public String toString() {
	return "Channel [streamid=" + streamid + ", streamname=" + streamname + ", genre=" + genre + ", language="
			+ language + ", startdate=" + startdate + ", enddate=" + enddate + ", cid=" + cid + ", datetext=" + datetext
			+ ", card=" + card + ", logo=" + logo + "]";
}
public Channel() {
	
}
public Channel(String streamid, String streamname) {
	this.streamid = streamid;
	this.streamname = streamname;
}
public Integer getCid() {
	return cid;
}
public void setCid(Integer cid) {
	this.cid = cid;
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

public String getLogo() {
	return logo;
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

public String getLanguage() {
	return language;
}

public void setLanguage(String language) {
	this.language = language;
}

public void setCard(String card) {
	this.card = card;
}

}
