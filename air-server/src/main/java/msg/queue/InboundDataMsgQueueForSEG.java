package msg.queue;

import msg.node.QueueNode;



public class InboundDataMsgQueueForSEG extends MsgQueue
{
	
	public InboundDataMsgQueueForSEG()
	{
		super();
	}
	
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
	
	private static InboundDataMsgQueueForSEG instance;

	public static InboundDataMsgQueueForSEG getInstance() {
		
		if(instance ==null)
			instance = new InboundDataMsgQueueForSEG();
				return instance;
	}
}
