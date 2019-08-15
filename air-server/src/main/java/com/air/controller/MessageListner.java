package com.air.controller;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

import org.springframework.web.bind.annotation.RestController;

import com.air.queue.node.CQPMessageNode;
import com.air.queue.node.SEQMessageNode;
import com.air.queue.node.TagMessageNode;

@RestController
public class MessageListner extends AbstractMessageController{
	
	
	
	/**
	 * tag protocol
	 * 
	 * tag                       server
	 * 	
	 * 1. activation request====>
	 * 2.                   <====  activation ack
	 * 3.                   <====  condition
	 * 4. condition ack      ====>  
	 * 5. cqp(10s)           ====>
	 * 6.                   <====  cqp ack
	 * 7.                   <====  update cqp condition 
	 * 8. seq(10 move)       ====> seq ack
	 * 7.                   <====  update seq condition
	 */

	private int port=10002;

	private byte[] buf;

	private DatagramPacket inPacket;

	private DatagramSocket socket;

	public MessageListner()
	{
		isStart =true;
		thread = new Thread(this);
		thread.start();
	}
	private String extractedTID(byte[] data )
	{
		StringBuffer buffer = new StringBuffer();

		for(int i=0;i<8;i++)
		{
			buffer.append(String.format("%02X",data[i]));
		}
		return buffer.toString();
	}
	public short extractTemperature(byte[] payload,int temperature_index) {

		// temp index:17
		short temp_temperature;
		if (String.format("%08d", Integer.parseInt(Integer.toBinaryString((payload[temperature_index]) & 0xFF))).charAt(0) == '1') 
		{
			temp_temperature = Short.parseShort("-" + Integer.parseInt(String.format("%08d", Integer.parseInt(Integer.toBinaryString((payload[17]) & 0xFF).substring(1))), 2));
		}
		else
		{
			temp_temperature = (short) Integer.parseInt(Integer.toBinaryString((payload[temperature_index]) & 0xFF), 2);
		}
		return temp_temperature;
	}

	@Override
	public void run() {
		buf = new byte[256];
		inPacket = new DatagramPacket(buf, buf.length);

		try {
			socket = new DatagramSocket(port);
			while (isStart) {

				try {
					System.out.println("listen ready..");

					inPacket.setLength(buf.length);

					socket.receive(inPacket);

					byte[] payload = inPacket.getData();

					if(payload[0]!=STX)
						continue;

					byte[] tidByte = new byte[8];

					for(int i=0;i<tidByte.length;i++)
					{
						tidByte[i] = payload[i+2];	
					}

					String tid = extractedTID(tidByte);

					switch(payload[1])
					{
					case SEG:
						
						SEQMessageNode seqMessage = new SEQMessageNode(tid);
						
						seqMessageQueue.append(seqMessage);

						break;
						
					case CQP:

						int temp = this.extractTemperature(payload, 10);
						
						CQPMessageNode cqpMessage = new CQPMessageNode(tid);
						
						cqpMessage.setTemp(temp);
						
						cqpMessageQueue.append(cqpMessage);

						break;
						
					case ACTIVATION_REQUEST:						

						TagMessageNode activationMessage = new TagMessageNode(tid);

						activationMessage.inPacket=inPacket;

						messageQueue.append(activationMessage);

						break;

					default:
						
						System.out.println("none message: "+payload[1]+ ", tid:"+tid);
						break;
					}

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
