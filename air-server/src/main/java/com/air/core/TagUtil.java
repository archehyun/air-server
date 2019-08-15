package com.air.core;

import java.net.DatagramPacket;

public class TagUtil {
	/**
	 * 
	 */
	private String strLatitude;
	
	private String strLongitude;
	/**
	 * @param payload
	 * @return
	 */
	public float extractedBattery(byte[] payload,int startIndex) {
		return Float.parseFloat(payload[startIndex] + "." + payload[startIndex+1]);
	}

	/**
	 * �� ǥ���
	 * @return
	 */
	private double doNotation(byte a, byte b, byte c)
	{
		double tempLatitude = (Double.parseDouble(String.valueOf(a))
				+ (Double.parseDouble(String.valueOf(b)) * 0.01)
				+ (Double.parseDouble(String.valueOf(c)) * 0.0001)) / 60;
		return tempLatitude;
	}
	
	
	/**��ġ ���� ����
	 * @param payload
	 * @return
	 */
	public double[] extractedLatLng(byte[] payload) {
		//logger.debug("extracted latlng start...");
		//logger.debug("extracted lat data");
		/*logger.debug("palyload data=>palyload[7]:"+payload[7]+
									" palyload[8]:"+payload[8]+
									" palyload[9]:"+payload[9]+
									" palyload[10]:"+payload[10]);*/

		double[] temp_latlng = new double[2];

		/*
		 * ���� ��ǥ ���
		 */
		strLatitude = payload[7] + "." + payload[8] + payload[9] + payload[10];
		//logger.debug("���� ǥ���(lat):"+ payload[7] + "." + payload[8] + payload[9] + payload[10]);				
		// ���� ǥ��� ---------> �� ǥ������� ��ȯ		

		temp_latlng[0] = Double.parseDouble(String.format("%.6f", (Double.valueOf(payload[7]) + doNotation(payload[8], payload[9], payload[10]))));
		//logger.debug("<lat result:"+temp_latlng[0]+">");


		/*
		 * ���� ��ǥ ���
		 */
		strLongitude = (payload[12] & 0xFF) + "." + payload[13] + payload[14] + payload[15];
		/*logger.debug("���� ǥ���(lng):"+(payload[12] & 0xFF) + "." + payload[13] + payload[14] + payload[15]);
		logger.debug("extracted lng data");
		logger.debug("palyload data=>palyload[12]:"+payload[12]+
									" palyload[13]:"+payload[13]+
									" palyload[14]:"+payload[14]+
									" palyload[15]:"+payload[15]);*/

		// ���� ǥ��� ---------> �� ǥ������� ��ȯ	
		temp_latlng[1] = Double.parseDouble(String.format("%.6f", (Double.valueOf((payload[12]) & 0xFF) +  doNotation(payload[13], payload[14], payload[15]))));
		/*		logger.debug("<lng result:"+temp_latlng[1]+">");

		logger.debug("extracted latlng end...");*/

		//temp_latlng[0] = Double.valueOf(strLatitude); 
		//temp_latlng[1] = Double.valueOf(strLongitude);
		return temp_latlng;
	}
	
	/**��ġ ���� ����
	 * 
	 * @���� ����(4byte), ���� ����(1byte), �浵(4byte), �浵 ����(1byte)
	 * ���� ����('N','S')
	 * �浵 ����('E','W')
	 * @param payload
	 * @return
	 */
	public double[] extractedLatLng(byte[] payload, int startIndex) {

		int latStartIndex=startIndex;

		double[] temp_latlng = new double[2];

		/*
		 * ���� ��ǥ ���
		 * 4byte: ����
		 * 1byt : ���� ����
		 * 
		 */
		strLatitude = (payload[11] & 0xFF) + "." + 
		             String.format("%02d",payload[12]) + 
		             String.format("%02d",payload[13]) + 
		             String.format("%02d",payload[14]);
		
		

		// ���� ǥ��� ---------> �� ǥ������� ��ȯ		

		temp_latlng[0] = Double.parseDouble(String.format("%.6f", (Double.valueOf(payload[latStartIndex]) 
				+ doNotation(payload[latStartIndex+1], payload[latStartIndex+2], payload[latStartIndex+3]))));

		/*
		 * �浵 ��ǥ ���
		 * 4byte: �浵
		 * 1byt : �浵 ����
		 */
		int lngStartIndex = startIndex+5;// latidue-d:4+latidue:1
		strLongitude = (payload[15] & 0xFF) + "." + 
		              String.format("%02d",payload[16]) + 
				      String.format("%02d",payload[17]) + String.format("%02d",payload[18]);
		//logger.debug("���� ǥ���(lng):"+(payload[12] & 0xFF) + "." + payload[13] + payload[14] + payload[15]);


		System.out.println(strLatitude+","+strLongitude);


		// ���� ǥ��� ---------> �� ǥ������� ��ȯ	
		temp_latlng[1] = Double.parseDouble(String.format("%.6f", (Double.valueOf((payload[lngStartIndex]) & 0xFF) +  doNotation(payload[lngStartIndex+1], payload[lngStartIndex+2], payload[lngStartIndex+3]))));
		
		
		byte lat[] = new byte[4];
		byte lng[] = new byte[4];
		lat[0] = payload[startIndex++];
		lat[1] = payload[startIndex++];
		lat[2] = payload[startIndex++];
		lat[3] = payload[startIndex++];
		
		lng[0] = payload[startIndex++];
		lng[1] = payload[startIndex++];
		lng[2] = payload[startIndex++];
		lng[3] = payload[startIndex++];

		temp_latlng[0] =TagUtil.convertByteToDouble(lat);
		temp_latlng[1] =TagUtil.convertByteToDouble(lng);

		return temp_latlng;
	}

	public String extractedTagIP(DatagramPacket inPacket) {
		return inPacket.getAddress().getHostAddress().toString() + ":" + inPacket.getPort();
	}
	/**�±� ���̵� ����-
	 * ��ü����: 8byte
	 * 1. country : 1byte
	 * 2. company : 2byte
	 * 3. type 	  : 1byte
	 * 4. number  : 4byte 
	 * @param payload
	 * @return
	 */
	public String extractedTID(byte[] payload, int startIndex) {
		/*			String tid = new String(payload, 2, 1);

		int intTid = (((int)payload[3] & 0xFF) << 16) + (((int)payload[4] & 0xFF) << 8) + ((int)payload[5] & 0xFF);

		tid += intTid;*/
		/*
		String country = toHex(payload[startIndex]);
		String company = new String(payload,startIndex+1,2);
		String type = new String(payload,startIndex+3,1);
		StringBuffer buffer = new StringBuffer();
		for(int i=(startIndex+4);i<(startIndex+4)+4;i++)
		{
			buffer.append(toHex(payload[i]));
		}
*/	
		StringBuffer buffer = new StringBuffer();

		for(int i=0;i<8;i++)
		{
			buffer.append(String.format("%02X",payload[startIndex]));
			startIndex++;
		}
		return buffer.toString();
	}



	/**
	 * ����Ʈ 16���� ǥ��
	 * ����Ʈ�� 8��Ʈ�ϱ�  16������ 2�ڸ��� ǥ��
	 * @param data
	 * @return
	 */
	private String toHex(byte data)
	{
		StringBuffer sb = new StringBuffer();
		sb.append(Integer.toString((data&0xF0)>>4,16));

		sb.append(Integer.toString((data&0x0F),16));
		return sb.toString();

	}

	/**��� ���� ����
	 * @param payload
	 * @return
	 */
	public String[] extractHit(byte[] payload, int startIndex) {

		String[] tempHit = new String[3];
		try{
			tempHit[0] = String.valueOf(payload[startIndex] + "." + payload[startIndex+1]);
			tempHit[1] = String.valueOf((payload[startIndex+2] & 0xFF) + "." + (payload[startIndex+3] & 0xFF));
			tempHit[2] =String.valueOf((payload[startIndex+4] & 0xFF) + "." + (payload[startIndex+5] & 0xFF));
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return tempHit;
	}

	public String extractStrHit(byte[] payload) {

		String[] tempHit = new String[3];
		try{
			tempHit[0] = (payload[19] + "." + payload[20]);
			tempHit[1] = (payload[21] & 0xFF) + "." + (payload[22] & 0xFF);
			tempHit[2] = (payload[23] & 0xFF) + "." + (payload[24] & 0xFF);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return payload[19] + "." + payload[20]+"."+(payload[21] & 0xFF) + "." + (payload[22] & 0xFF)+"."+(payload[23] & 0xFF) + "." + (payload[24] & 0xFF);
	}
	/**�µ� ���� ����
	 * @param payload
	 * @return
	 */
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
	/**
	 *�Ҽ��� 6�ڸ� ��ȯ 
	 */
	public static final byte[] convertDoubleToByte(double value)
	{
		byte[] data = new byte[4];

		String strValue =String.format("%.6f",value);
		
		String lat1 = strValue.substring(0, strValue.indexOf("."));

		String lat2 = strValue.substring(strValue.indexOf(".")+1, strValue.length());
		
		data[0] =(byte) Integer.parseInt(lat1);
		data[1] =(byte) Integer.parseInt(lat2.substring(0, 2));
		data[2] =(byte) Integer.parseInt(lat2.substring(2, 4));
		data[3] =(byte) Integer.parseInt(lat2.substring(4, 6));
		
		return data;
	}
	public static final double convertByteToDouble(byte[] value)
	{
		
		String strValue = (value[0] & 0xFF) + "." + 
				String.format("%02d",value[1] & 0xFF)+ 
				String.format("%02d",value[2] & 0xFF)+
				String.format("%02d",value[3] & 0xFF);
		return Double.valueOf(strValue);

	}
}
