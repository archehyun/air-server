package msg.queue;

import msg.node.MsgForAPI;
import msg.node.QueueNode;

/**
 * API Message Queue�� �����ϴ� Ŭ����
 * 
 * @author		�ں���
 * @since       2014-01-29
 * @version     0.1       
 */
public class MsgQueueForAPI extends MsgQueue
{
	private static MsgQueueForAPI apiMsgQueue; //API Module�� ���� Message Queue
	
	/**
	 * Class constructor
	 * API Message Queue Instance�� ���⼭ ������
	 */
	static
	{
		apiMsgQueue = new MsgQueueForAPI();
	}
	
	/*
	 * API Module�� ���� Message Queue Instance�� ȹ���� �� �ִ� Ŭ���� �޼���
	 */
	public static MsgQueueForAPI getInstance()
	{
		return apiMsgQueue;
	}
	
	public MsgQueueForAPI()
	{
		super();
	}
	
	/**
	 * �ش��ϴ� API Message�� �̾Ƽ� return��
	 * 
	 * @param userID	�ش� ���Ǹ� ����� user�� ID
	 * @param queryID	ó�� ����� ����� �ϴ� query�� ID
	 * @return			API Message if it exist, otherwise null          
	 */
	public synchronized MsgForAPI poll(String userID, int queryID)
	{
		MsgForAPI retMsg = null;
		if (first != null)
		{
			MsgForAPI m = (MsgForAPI)first;
			while(m != null)
			{
				QueueNode n = m.getNext();
				
				// ����
				if (m.getUserID().equals(userID) && m.getQueryID() == queryID)
				{
					retMsg = m;
					
					if (m == first)
					{
						first = n;
					}
					else
					{
						m.getPrev().setNext(n);
					}
					
					if (m == last)
					{
						last = null;
					}
					else
					{
						n.setPrev(m.getPrev());
					}
					
					break;
				}
				else
				{
					m = (MsgForAPI)n;
				}
				try 
				{
					wait();
				} 
				catch (InterruptedException e) 
				{
					//e.printStackTrace();
				}
			}
		}
		else
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
		
		return retMsg;
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
