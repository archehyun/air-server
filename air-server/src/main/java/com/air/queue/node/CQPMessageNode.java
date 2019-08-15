package com.air.queue.node;

public class CQPMessageNode extends TagMessageNode{
	
	
	public CQPMessageNode(String id)
	{
		super(id);
	}
	
	
	int temp; // 온도
	
	String hit;
	
	public String getHit() {
		return hit;
	}

	public void setHit(String hit) {
		this.hit = hit;
	}

	public void setTemp(int temp) {
		this.temp = temp;
	}
	
	public int getTemp() {
		// TODO Auto-generated method stub
		return temp;
	}

}
