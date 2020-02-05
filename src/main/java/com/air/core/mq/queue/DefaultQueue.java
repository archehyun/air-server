package com.air.core.mq.queue;

import mq.node.QueueNode;

/**
 * @author 박창현
 *
 */
public class DefaultQueue extends MsgQueue{
	
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
