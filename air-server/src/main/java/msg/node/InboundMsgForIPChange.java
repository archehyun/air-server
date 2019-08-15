package msg.node;


/**
 * �±��� ����� IP ������ �����ϴ� InboundControlMsg ��Ŷ ���
 * 
 * @author		�����
 * @since       2014-02-04
 * @version     0.1       
 */
public class InboundMsgForIPChange extends InboundMsgForData
{
	public InboundMsgForIPChange(String tid, String cid, String tagIPaddr, 
			float latitude, double longitude, short temperature, short humidity, 
			String hitX, String hitY, String hitZ, byte door) {
		super(tid, cid,tagIPaddr);
		
		this.setLatitude(latitude);
		
		this.setLongitude((float) longitude);
		
		this.setTemporature(temperature);
		
		this.setHumidity(humidity);
		
		this.setHitX(hitX);
		
		this.setHitY(hitY);
		
		this.setHitZ(hitZ);
		
		this.setDoor(door);

	}
}
