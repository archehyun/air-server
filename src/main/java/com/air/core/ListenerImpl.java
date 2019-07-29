package com.air.core;

import org.springframework.stereotype.Service;

import com.air.core.mq.queue.TagMessageQueue;

import mq.node.QueueNode;

@Service
public class ListenerImpl implements Listener{
	
	TagMessageQueue messageQueue = TagMessageQueue.getInstance();
	
	TagMessageListner tagMessageListner;
	
	public ListenerImpl() {
		tagMessageListner = new TagMessageListner();
		new Thread(tagMessageListner).start();
	}
	class TagMessageListner implements Runnable
	{

		@Override
		public void run() 
		{
			while(true)
			{	
				try {
					
					messageQueue.append(new QueueNode());
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	@Override
	public void insert() {
		// TODO Auto-generated method stub
		
	}

}
