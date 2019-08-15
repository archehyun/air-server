package com.air.controller;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.air.domain.TagInfo;
import com.air.queue.TagMessageQueue;
import com.air.queue.node.TagMessageNode;
import com.air.service.TagService;

@RestController
public class TagInboundProcess implements Runnable{
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
	
	Thread  thread;
	
	@Autowired
	TagService tagService;
	public TagInboundProcess() {
		isStart = true;
		thread = new Thread(this);
		thread.start();
	}
	
	
	private boolean isStart;
	
	TagMessageQueue queue = TagMessageQueue.getInstance();
	
	public void run()
	{
		while(isStart)
		{
			TagMessageNode node = (TagMessageNode) queue.poll();
			
			TagInfo info = tagService.selectTag(node.getId());
			if(info!=null)
			{
				InetAddress addr = node.inPacket.getAddress();
				byte but[] = new byte[12];
				but[0]=STX;
				but[1]=ACTIVATION_PERMISSION_ACK;
				
				try {
					DatagramPacket sendPacket =  

							new DatagramPacket(but, but.length, addr, 10004);
					DatagramSocket dsocket;
					dsocket = new DatagramSocket();
					dsocket.send(sendPacket);
					dsocket.close();
				} catch (SocketException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
			else
			{
				System.out.println(node.getId()+" is null");
			}
			
			
			
		}
	}

}
