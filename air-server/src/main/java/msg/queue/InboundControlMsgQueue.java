package msg.queue;

import msg.node.QueueNode;


/**
 * Inbound Control Message Queue�� �����ϴ� Ŭ����
 * 
 * @author		�ں���
 * @since       2014-01-29
 * @version     0.1       
 */
public class InboundControlMsgQueue extends MsgQueue
{
	private static InboundControlMsgQueue inboundControlMsgQueue; //Inbound Control Message Queue
	
	/**
	 * Class constructor
	 * Message Queue Instance�� ���⼭ ������
	 */
	static
	{
		inboundControlMsgQueue = new InboundControlMsgQueue();
	}
	
	/*
	 * Inbound Control Message Queue ��ü�� ȹ���� �� �ִ� Ŭ���� �޼���
	 */
	public static InboundControlMsgQueue getInstance()
	{
		return inboundControlMsgQueue;
	}
	
	public InboundControlMsgQueue()
	{
		super();
	}

	public int size() {
		return 0;
	}
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
