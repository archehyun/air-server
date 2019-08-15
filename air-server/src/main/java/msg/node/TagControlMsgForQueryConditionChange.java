package msg.node;

/**
 * ����� ���ǿ� ����Ͽ� �±��� ������ ���� ������ ����� Tag Control Message
 * 
 * @author		�����
 * @since       2014-02-06
 * @version     0.1      
 */
public class TagControlMsgForQueryConditionChange extends TagControlMsg
{
	public static byte DOOR_OPEN=0x01;
	public static byte DOOR_CLOSE=0x00;
	public static byte DOOR_NONE=0x02;
	
	private short lowerBoundTemperature; //������� �µ� ���Ѱ�(����), �� ������ �������� �˷��޶�
	private short upperBoundTemperature; //������� �µ� ���Ѱ�(����), �� ������ �ö󰡸� �˷��޶�
	private short lowerBoundHumidity; //������� ���� ���Ѱ�(%), �� ������ �������� �˷��޶�
	private short upperBoundHumidity; //������� ���� ���Ѱ�(%), �� ������ �ö󰡸� �˷��޶�
	private short upperBoundHit; //������� ��� ���Ѱ�(dB), �� ������ ũ�� �˷��޶�
	private byte door; // ���� ����(0x00), ���� ����(0x01), Ȯ�� �Ұ�(0x02)
	private int noticeInterval; //�±� ��� �ֱ�(��)
	private int sensingInterval; //�±� ���� �ֱ�(��)
	private boolean add; // true: ADD, false: REMOVE
	
	
	/**@see ��â�� �߰�
	 * @param tid
	 * @param cid
	 */
	public TagControlMsgForQueryConditionChange(String tid, String cid)
	{
		super(tid,cid,null);
		
	}
	
	public TagControlMsgForQueryConditionChange(String tid, String cid, String ip)
	{
		super(tid,cid,ip);
		
	}
	public TagControlMsgForQueryConditionChange(String tid, String cid, short lowerBoundTemperature, short upperBoundTemperature,
										short lowerBoundHumidity, short upperBoundHumidity, short upperBoundHit, 
										byte door, int noticeInterval, int sensingInterval, boolean add) {
		super(tid, cid, null);
		this.lowerBoundTemperature = lowerBoundTemperature;
		this.upperBoundTemperature = upperBoundTemperature;
		this.lowerBoundHumidity = lowerBoundHumidity;
		this.upperBoundHumidity = upperBoundHumidity;
		this.upperBoundHit = upperBoundHit;
		this.door = door;
		this.noticeInterval = noticeInterval;
		this.sensingInterval = sensingInterval;
		this.add = add;
	}

	public short getLowerBoundTemperature() {
		return lowerBoundTemperature;
	}

	public void setLowerBoundTemperature(short lowerBoundTemperature) {
		this.lowerBoundTemperature = lowerBoundTemperature;
	}

	public short getUpperBoundTemperature() {
		return upperBoundTemperature;
	}

	public void setUpperBoundTemperature(short upperBoundTemperature) {
		this.upperBoundTemperature = upperBoundTemperature;
	}

	public short getLowerBoundHumidity() {
		return lowerBoundHumidity;
	}

	public void setLowerBoundHumidity(short lowerBoundHumidity) {
		this.lowerBoundHumidity = lowerBoundHumidity;
	}

	public short getUpperBoundHumidity() {
		return upperBoundHumidity;
	}

	public void setUpperBoundHumidity(short upperBoundHumidity) {
		this.upperBoundHumidity = upperBoundHumidity;
	}

	public short getUpperBoundHit() {
		return upperBoundHit;
	}

	public void setUpperBoundHit(short upperBoundHit) {
		this.upperBoundHit = upperBoundHit;
	}

	public byte getDoor() {
		return door;
	}

	public void setDoor(byte door) {
		this.door = door;
	}

	public int getNoticeInterval() {
		return noticeInterval;
	}

	public void setNoticeInterval(int noticeInterval) {
		this.noticeInterval = noticeInterval;
	}

	public int getSensingInterval() {
		return sensingInterval;
	}

	public void setSensingInterval(int sensingInterval) {
		this.sensingInterval = sensingInterval;
	}
	
	public boolean isAdd() {
		return add;
	}

	public void setAdd(boolean add) {
		this.add = add;
	}
}
