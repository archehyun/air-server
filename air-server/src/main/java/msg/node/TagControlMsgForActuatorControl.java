package msg.node;

/**
 * Query Processor�� ���Ͽ� �±��� actuator control�� ����� Tag Control Message
 * 
 * @author		�ں���
 * @since       2014-01-25
 * @version     0.1       
 */
public class TagControlMsgForActuatorControl extends TagControlMsg
{
	private short switchNo; //�±׿� ����� actuator�� ����ġ ��ȣ
	private boolean on; // true: ����ġ ON, false: ����ġ OFF
	
	public TagControlMsgForActuatorControl(String tid, String cid, short switchNo, boolean on)
	{
		super(tid, cid, null);
		this.switchNo = switchNo;
		this.on = on;
	}

	public short getSwitchNo()
	{
		return switchNo;
	}

	public void setSwitchNo(short switchNo)
	{
		this.switchNo = switchNo;
	}

	public boolean isOn()
	{
		return on;
	}

	public void setOn(boolean on)
	{
		this.on = on;
	}
}
