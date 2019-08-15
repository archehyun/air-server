package msg.queue;

import msg.node.QueueNode;


/**
 * ���� ó���⸦ ���� Inbound Data Message Queue�� �����ϴ� Ŭ����
 * 
 * @author		�ں���
 * @since       2014-01-29
 * @version     0.1       
 */
public class InboundDataMsgQueueForQP extends MsgQueue
{
	private static InboundDataMsgQueueForQP inboundDataMsgQueueForQP; //Query Processor�� ���� Inbound Data Message Queue
	
	/**
	 * Class constructor
	 * Inbound Data Message Queue Instance�� ���⼭ ������
	 */
	static
	{
		inboundDataMsgQueueForQP = new InboundDataMsgQueueForQP();
	}
	
	/*
	 * Query Processor�� ���� Inbound Data Message Queue Instance�� ȹ���� �� �ִ� Ŭ���� �޼���
	 */
	public static InboundDataMsgQueueForQP getInstance()
	{
		return inboundDataMsgQueueForQP;
	}
	private int length;
	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public InboundDataMsgQueueForQP()
	{
		super();
	}
	
	public synchronized boolean append(QueueNode msgNode)
	{		
		if (super.append(msgNode))
		{
			length++;
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
		length--;
		return node;
	}
}
