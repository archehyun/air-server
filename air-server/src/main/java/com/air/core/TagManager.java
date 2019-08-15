package com.air.core;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TagManager {
	
	List<String> messageList;
	public List<String> getMessageList() {
		return messageList;
	}

	public TagManager() {
		messageList = new LinkedList<String>();
	}
	
	public void addMessage(String message)
	{
		messageList.add(message);
	}
}
