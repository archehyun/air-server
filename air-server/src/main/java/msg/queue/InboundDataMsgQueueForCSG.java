package msg.queue;

import msg.node.QueueNode;


/**
 * Cargo Status Generator�� ���� Inbound Data Message Queue�� �����ϴ� Ŭ����
 * 
 * @author		�ں���
 * @since       2014-01-29
 * @version     0.1       
 */
public class InboundDataMsgQueueForCSG extends MsgQueue
{
	private static InboundDataMsgQueueForCSG inboundDataMsgQueueForCSG; //Cargo Status Generator�� ���� Inbound Data Message Queue
	
	/**
	 * Class constructor
	 * Inbound Data Message Queue Instance�� ���⼭ ������
	 */
	static
	{
		inboundDataMsgQueueForCSG = new InboundDataMsgQueueForCSG();
	}
	
	/*
	 * Inbound Data Message Queue Instance�� ȹ���� �� �ִ� Ŭ���� �޼���
	 */
	public static InboundDataMsgQueueForCSG getInstance()
	{
		return inboundDataMsgQueueForCSG;
	}
	
	public InboundDataMsgQueueForCSG()
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
}
