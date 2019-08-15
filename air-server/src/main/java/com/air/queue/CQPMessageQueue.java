package com.air.queue;

public class CQPMessageQueue extends DefaultMagQueue{
	
	static CQPMessageQueue instance;
	
	private CQPMessageQueue() {
		// TODO Auto-generated constructor stub
	}
	public static CQPMessageQueue getInstance() {
		if(instance ==null)
		instance = new CQPMessageQueue();
				
		return instance;
	}

}
