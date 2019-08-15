package com.air.queue.node;

public class SEQMessageNode extends CQPMessageNode{
	public SEQMessageNode(String id) {
		super(id);
		// TODO Auto-generated constructor stub
	}
	String lng;
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	String lat;

}
