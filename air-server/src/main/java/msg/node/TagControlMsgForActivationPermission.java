package msg.node;

/**
 * �±��� activation request�� ���� permission�� ����� Tag Control Message
 * 
 * @author		�����
 * @since       2014-02-06
 * @version     0.1      
 */
public class TagControlMsgForActivationPermission extends TagControlMsg
{	
	private int heartbeatPeriod; // �±� ���� ���� �ֱ�

	public TagControlMsgForActivationPermission(String tid, String cid, int heartbeatPeriod) {
		super(tid, cid, null);
		this.heartbeatPeriod = heartbeatPeriod;
	}

	public int getheartbeatPeriod() {
		return heartbeatPeriod;
	}

	public void setheartbeatPeriod(int heartbeatPeriod) {
		this.heartbeatPeriod = heartbeatPeriod;
	}
}
