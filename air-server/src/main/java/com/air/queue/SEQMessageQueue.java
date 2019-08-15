package com.air.queue;

public class SEQMessageQueue extends DefaultMagQueue{
	
	static SEQMessageQueue instance;
	
	private SEQMessageQueue() {
		// TODO Auto-generated constructor stub
	}
	public static SEQMessageQueue getInstance() {
		if(instance ==null)
		instance = new SEQMessageQueue();
				
		return instance;
	}

}
