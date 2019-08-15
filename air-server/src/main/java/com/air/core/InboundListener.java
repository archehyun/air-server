package com.air.core;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.air.service.InboundService;


@Service
public class InboundListener implements Runnable{
	
	
	private int port=10002;
	private Thread thread;
	private byte[] buf;
	private DatagramPacket inPacket;
	private DatagramSocket socket;
	private boolean isStarted;
	private String tid, cid = null, gps_valid, tagIPaddr;
	@Autowired
	InboundService service;
	TagUtil tagUtil = new TagUtil();
	
	@Autowired
	TagManager tagManager;
	public InboundListener() {
		
		isStarted = true;
		thread = new Thread(this);
		thread.start();
	}

	@Override
	public void run() {
		try {
			
			buf = new byte[256];

			inPacket = new DatagramPacket(buf, buf.length);

			socket = new DatagramSocket(port);

			while (isStarted) {

				inPacket.setLength(buf.length);

				socket.receive(inPacket);

				byte[] payload = inPacket.getData();

				
				if (payload[0] == AIRProtocol.STX) { // STX

					tagIPaddr 	= tagUtil.extractedTagIP(inPacket);
					tagManager.addMessage(tagIPaddr);

					cid = "con001";  // 수정 필요
					tid = tagUtil.extractedTID(payload, 2);
					//logger.info("tag access => tid: " + tid+", ip:"+ tagIPaddr);					

					// Type Field 
					switch (payload[1]) { 

					case AIRProtocol.ACTIVATION_REQUEST:  		//0x21
						service.activationRequest(payload, inPacket);
						break;

					case AIRProtocol.ACTIVATION_REQUEST_RE_ACK: //0x22
						service.activationRequestReAck(payload);
						break;

					case AIRProtocol.ACTIVATION_PERMISSION_ACK:	//0x23
						service.activationPermissionAck(payload);
						break;

					case AIRProtocol.SEG:						//0x24
						service.seg(payload);
						break;

					case AIRProtocol.DISTANCE_CONDITION_ACK:    //0x25
						service.distanceContiditionAck(payload);
						break;

					case AIRProtocol.CQP:						//0x26
						service.cqp(payload,inPacket);
						break;

					case AIRProtocol.HEARTBEAT:					//0x27
						service.heartbeat(payload);
						break;

					case AIRProtocol.IP_CHANGE:					//0x28
						service.ipChange(payload, inPacket);
						break;

					case AIRProtocol.ACTUATOR_ACK:				//0x29
						service.actuatorAck(payload);
						break;
					case AIRProtocol.QUERY_CONDTION_ACK:				//0x30
						service.queryConditionAck(payload);
						break;						
					default:

						/*notifyMonitor("not support Message type:"+payload[1]+", tid:"+tid);
						logger.error("not support Message type:"+payload[1]+","+payload);*/
						break;
					}
				} else {
					//notifyMonitor("not acceptable format:"+AIRProtocol.STX+","+payload[0]);
					//break;
					continue;
				}				

			}

		} catch (SocketException e) {
			System.out.println(e.getMessage());
			//e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if(socket!=null)
				socket.close();
			socket = null;
		}		
	}

}
