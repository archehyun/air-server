package com.air.core.mq.queue;

public class TagMessageQueue extends DefaultQueue{
	
	private static TagMessageQueue messageQueue;
	
	private TagMessageQueue()
	{
		
	}
	public static TagMessageQueue getInstance()
	{
		if(messageQueue==null)
			messageQueue = new TagMessageQueue();
		return messageQueue;
	}
	

}
