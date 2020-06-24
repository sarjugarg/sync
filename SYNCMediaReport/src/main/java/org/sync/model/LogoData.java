package org.sync.model;

public class LogoData {
private String name;
private String logo;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getLogo() {
	return logo;
}
public void setLogo(String logo) {
	this.logo = logo;
}
@Override
public String toString() {
	return "LogoData [name=" + name + ", logo=" + logo + "]";
}
}
