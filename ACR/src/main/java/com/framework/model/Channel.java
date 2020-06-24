package com.framework.model;

public class Channel {
	
	int channelImageId;
	int channelId;
	private	String channel;
	private String streamId;
 	
	int imageHeight;
	int imageWidth;
	String imageUrl;
	private int spendUnit;
	private String filename;
	
	private float spend;
	public int getChannelImageId() {
		return channelImageId;
	}
	public void setChannelImageId(int channelImageId) {
		this.channelImageId = channelImageId;
	}
	public int getChannelId() {
		return channelId;
	}
	public void setChannelId(int channelId) {
		this.channelId = channelId;
	}
	public int getImageHeight() {
		return imageHeight;
	}
	public void setImageHeight(int imageHeight) {
		this.imageHeight = imageHeight;
	}
	public int getImageWidth() {
		return imageWidth;
	}
	public void setImageWidth(int imageWidth) {
		this.imageWidth = imageWidth;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public float getSpend() {
		return spend;
	}
	public void setSpend(float spend) {
		this.spend = spend;
	}
	
	
	
	
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	
	
	
	public int getSpendUnit() {
		return spendUnit;
	}
	public void setSpendUnit(int spendUnit) {
		this.spendUnit = spendUnit;
	}
	
	
	public String getStreamId() {
		return streamId;
	}
	public void setStreamId(String streamId) {
		this.streamId = streamId;
	}
	
	
	
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	@Override
	public String toString() {
		return "Channel [channelImageId=" + channelImageId + ", channelId=" + channelId + ", imageHeight=" + imageHeight
				+ ", imageWidth=" + imageWidth + ", imageUrl=" + imageUrl + ", spend=" + spend + ", channel=" + channel +", spendUnit=" +  spendUnit +", streamId=" +  streamId +",filename="+filename+"]";
	}
	
	


}
