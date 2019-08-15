package msg.node;


/**
 * �±��� ���� ������ �����ϴ� InboundControlMsg ��Ŷ
 * 
 * @author		�����
 * @since       2014-02-04
 * @version     0.1       
 */
public class InboundControlMsgForHeartbeat extends InboundMsg
{
	private float battery; // �±� ���͸� �ܷ� (Voltage)

	public InboundControlMsgForHeartbeat(String tid, String cid, float battery) {
		super(tid, cid);
		this.battery = battery;
	}

	public float getBattery() {
		return battery;
	}

	public void setBattery(float battery) {
		this.battery = battery;
	}
}
