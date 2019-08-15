package msg.queue;

import msg.node.QueueNode;



/**
 * Outbound Control Message Queue�� �����ϴ� Ŭ����
 * 
 * @author		�ں���
 * @since       2014-01-29
 * @version     0.1       
 */
public class OutboundMsgQueue extends MsgQueue
{
	private static OutboundMsgQueue outboundMsgQueue; //Outbound Message Queue
	
	/**
	 * Class constructor
	 * Message Queue Instance�� ���⼭ ������
	 */
	static
	{
		outboundMsgQueue = new OutboundMsgQueue();
	}
	
	/*
	 * Outbound Message Queue Instance�� ȹ���� �� �ִ� Ŭ���� �޼���
	 */
	public static OutboundMsgQueue getInstance()
	{
		return outboundMsgQueue;
	}
	
	public OutboundMsgQueue()
	{
		super();
	}
	
	/* ��â�� �߰�
	 * (non-Javadoc)
	 * @see msg.queue.MsgQueue#append(msg.node.MsgNode)
	 */
	public synchronized boolean append(QueueNode msgNode)
	{		
		if (super.append(msgNode))
		{
			notifyAll();
		}
		
		return true;
	}
	/* ��â�� �߰�
	 * (non-Javadoc)
	 * @see msg.queue.MsgQueue#append(msg.node.MsgNode)
	 */
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
