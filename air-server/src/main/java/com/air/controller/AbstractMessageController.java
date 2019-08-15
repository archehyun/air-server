package com.air.controller;

import com.air.queue.CQPMessageQueue;
import com.air.queue.SEQMessageQueue;
import com.air.queue.TagMessageQueue;

public abstract class AbstractMessageController implements Runnable {
	
	
	public static final byte ACTIVATION_REQUEST				= (byte)0x21;
	public static final byte ACTIVATION_REQUEST_RE_ACK 		= (byte)0x22;
	public static final byte ACTIVATION_PERMISSION_ACK 		= (byte)0x23;
	public static final byte SEG							= (byte)0x24;
	public static final byte DISTANCE_CONDITION_ACK	 		= (byte)0x25;
	public static final byte CQP						 	= (byte)0x26;	
	public static final byte HEARTBEAT				 		= (byte)0x27;
	public static final byte IP_CHANGE						= (byte)0x28;
	public static final byte ACTUATOR_ACK				 	= (byte)0x29;
	public static final byte QUERY_CONDTION_ACK 			= (byte)0x30;

	public static final byte EXT1							= (byte)0x2A;
	public static final byte EXT2							= (byte)0x2D;
	public static final byte STX							= (byte)0x8F;

	TagMessageQueue messageQueue =TagMessageQueue.getInstance();
	
	CQPMessageQueue cqpMessageQueue = CQPMessageQueue.getInstance();
	
	SEQMessageQueue seqMessageQueue = SEQMessageQueue.getInstance();
	
	protected boolean isStart;
	
	protected Thread thread;
	

}
