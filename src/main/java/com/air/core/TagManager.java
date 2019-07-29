package com.air.core;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Component;

import mq.node.QueueNode;

@Component
public class TagManager {
	
	TagMessageQueue messageQueue = TagMessageQueue.getInstance();
	
	List<String> messageList;
	
	
	public List<String> getMessageList() {
		return messageList;
	}

	public TagManager() {
		messageList = new LinkedList<String>();
		process = new MessageProcess();
		process.start();
		
	}
	MessageProcess process;
	public void addMessage(String message)
	{
		messageList.add(message);
	}
	class MessageProcess extends Thread
	{
		public void run()
		{
			while(true)
			{
				QueueNode node=messageQueue.poll();
				System.out.println("update");
			}
		}
	}
	
}

