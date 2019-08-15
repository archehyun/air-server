package com.air.queue.node;

import java.net.DatagramPacket;

import msg.node.QueueNode;

public class TagMessageNode extends QueueNode{
	
	public TagMessageNode(String id) {
		this.id = id;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public DatagramPacket getInPacket() {
		return inPacket;
	}
	public void setInPacket(DatagramPacket inPacket) {
		this.inPacket = inPacket;
	}
	private String updateTime;
	private String ip;
	private String id;
	public DatagramPacket inPacket;
	

}
