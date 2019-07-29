package com.air.core.mq.queue;

import mq.node.QueueNode;

/**
 * ��� Message Queue�� ���� Ŭ����
 * 
 * @author		�ں���
 * @since       2014-01-29
 * @version     0.1       
 */
public class MsgQueue
{
	protected QueueNode first; //pointer to the first node of Linked List
	protected QueueNode last; //pointer to the last node of Linked List
	
	public MsgQueue()
	{
		first = null;
		last = null;
	}
	
	/**
	 * ���ο� Message�� ť ���� �߰�
	 * 
	 * @param newMsg	ť�� �߰��� Control Message
	 * @return			true if succeed, otherwise false          
	 */
	public synchronized boolean append(QueueNode newMsg)
	{
		if (first == null)
		{
			first = newMsg;
			last = newMsg;
		}
		else
		{
			newMsg.setPrev(last);
			last.setNext(newMsg);
			last = newMsg;
		}
		
		return true;
	}
	
	/**
	 * ť�� ù��° Message�� �̾Ƽ� return ��
	 * 
	 * @param 			����
	 * @return			Message if it exist, otherwise null          
	 */
	public synchronized QueueNode poll()
	{
		QueueNode retMsg = null;
		
		if (first == null)
		{
			retMsg = null;
		}
		else if (first == last)
		{
			retMsg = first;
			first = null;
			last = null;
		}
		else
		{
			retMsg = first; 
			first = first.getNext();;
			first.setPrev(null);
		}
		
		return retMsg;
	}
}
