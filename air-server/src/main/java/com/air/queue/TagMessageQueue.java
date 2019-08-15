package com.air.queue;

public class TagMessageQueue extends DefaultMagQueue{
	
	
	static TagMessageQueue instance;
	
	private TagMessageQueue() {
		// TODO Auto-generated constructor stub
	}
	public static TagMessageQueue getInstance() {
		if(instance ==null)
		instance = new TagMessageQueue();
				
		return instance;
	}

}
