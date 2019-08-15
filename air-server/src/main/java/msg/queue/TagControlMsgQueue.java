package msg.queue;

import msg.node.QueueNode;


/**
 * Tag Control Message Queue�� �����ϴ� Ŭ����
 * 
 * @author		�ں���
 * @since       2014-01-29
 * @version     0.1       
 */
public class TagControlMsgQueue extends MsgQueue
{
	private static TagControlMsgQueue tagControlMsgQueue; //�±׸� �����ϱ� ���� Tag Control Message Queue
	
	/**
	 * Class constructor
	 * Tag Control Message Queue Instance�� ���⼭ ������
	 */
	static
	{
		tagControlMsgQueue = new TagControlMsgQueue();
	}
	
	/*
	 * Tag Manager�� ���� Tag Control Message Queue Instance�� ȹ���� �� �ִ� Ŭ���� �޼���
	 */
	public static TagControlMsgQueue getInstance()
	{
		return tagControlMsgQueue;
	}
	
	public TagControlMsgQueue()
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
