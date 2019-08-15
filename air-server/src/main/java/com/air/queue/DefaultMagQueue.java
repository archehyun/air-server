package com.air.queue;

import msg.node.QueueNode;
import msg.queue.MsgQueue;

public class DefaultMagQueue extends MsgQueue{
	
	String queueID;
	
	public synchronized boolean append(QueueNode msgNode)
	{	
		if (super.append(msgNode))
		{
			notifyAll();
		}

		return true;
	}
	public synchronized QueueNode poll() 
	{
		QueueNode node = null;
		
		while((node = super.poll()) == null)
		{
			try 
			{
				wait();
			} 
			catch (InterruptedException e) 
			{
				//e.printStackTrace();
			}
		}
		return node;
	}

}
