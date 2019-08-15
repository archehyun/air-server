package com.air.controller;

import org.springframework.web.bind.annotation.RestController;

import com.air.queue.node.SEQMessageNode;

@RestController
public class SEQMessageController extends AbstractMessageController{
	
	public SEQMessageController() {
		isStart = true;
		thread = new Thread(this);
		thread.start();
	}


	@Override
	public void run() {
		while(isStart)
		{
			SEQMessageNode message = (SEQMessageNode) seqMessageQueue.poll();
			System.out.println("seq message temp:"+message.getTemp());
			
		}
	}

}
