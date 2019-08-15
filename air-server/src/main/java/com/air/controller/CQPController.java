package com.air.controller;

import org.springframework.web.bind.annotation.RestController;

import com.air.queue.node.CQPMessageNode;

@RestController
public class CQPController extends AbstractMessageController{
	
	public CQPController() {
		
		isStart = true;
		thread = new Thread(this);
		thread.start();
	}

	@Override
	public void run() {
		while(isStart)
		{
			CQPMessageNode message = (CQPMessageNode) cqpMessageQueue.poll();
			System.out.println("cqp message temp:"+message.getTemp());
			
		}
		
	}
	

}
