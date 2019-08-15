package msg.node;


/**
 * �±׷κ��� ���� Data Packet�� ��������ϴ� Inbound Data Message Queue�� ���
 * 
 * @author		�ں���
 * @since       2014-01-25
 * @version     0.1       
 */
public class InboundMsgForData extends InboundMsg
{
	private short year; //�±� ������ ���� ��
	
	private byte month; //�±� ������ ���� ��
	
	private byte day; //�±� ������ ���� ��
	
	private byte hour; //�±� ������ ���� ��
	
	private byte minute; //�±� ������ ���� ��
	
	private double latitude; //�±��� ���� ����
	
	private double longitude; //�±��� ���� �浵
	
	private short temperature; //�±��� ���� �µ�(����)
	
	private short humidity; //�±��� ���� ����(%)
	
	private String hitX; //�±װ� ���� X�� ���ġ(dB)
	
	private String hitY; //�±װ� ���� Y�� ���ġ(dB)
	
	private String hitZ; //�±װ� ���� Z�� ���ġ(dB)
	
	private byte door; //���� ����(0x00), ���� ����(0x01), Ȯ�� �Ұ�(0x02)

	private long currentTime;
	
	public InboundMsgForData(String tid, String cid)
	{
		super(tid, cid);
	}
	public InboundMsgForData(String tid, String cid,String tagIPaddr)
	{
		super(tid, cid,tagIPaddr);
	}

	public InboundMsgForData(String tid, String cid, short year, byte month, byte day, byte hour, byte minute, double latitude, double longitude,
							short temperature, short humidity, String hitX, String hitY, String hitZ, byte door) {
		super(tid, cid);
		this.year = year;
		this.month = month;
		this.day = day;
		this.hour = hour;
		this.minute = minute;
		this.latitude = latitude;
		this.longitude = longitude;
		this.temperature = temperature;
		this.humidity = humidity;
		this.hitX = hitX;
		this.hitY = hitY;
		this.hitZ = hitZ;
		this.door = door;
	}

	public short getYear() {
		return year;
	}

	public void setYear(short year) {
		this.year = year;
	}

	public byte getMonth() {
		return month;
	}

	public void setMonth(byte month) {
		this.month = month;
	}

	public byte getDay() {
		return day;
	}

	public void setDay(byte day) {
		this.day = day;
	}

	public byte getHour() {
		return hour;
	}

	public void setHour(byte hour) {
		this.hour = hour;
	}

	public byte getMinute() {
		return minute;
	}

	public void setMinute(byte minute) {
		this.minute = minute;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public short getTemperature() {
		return temperature;
	}

	public void setTemporature(short temperature) {
		this.temperature = temperature;
	}

	public short getHumidity() {
		return humidity;
	}

	public void setHumidity(short humidity) {
		this.humidity = humidity;
	}

	public String getHitX() {
		return hitX;
	}

	public void setHitX(String hitX) {
		this.hitX = hitX;
	}

	public String getHitY() {
		return hitY;
	}

	public void setHitY(String hitY) {
		this.hitY = hitY;
	}

	public String getHitZ() {
		return hitZ;
	}

	public void setHitZ(String hitZ) {
		this.hitZ = hitZ;
	}

	public byte getDoor() {
		return door;
	}

	public void setDoor(byte door) {
		this.door = door;
	}
	
	public long getCurrentTime() {
		return currentTime;
	}

	public void setCurrentTime(long currentTimeMillis) {
		this.currentTime = currentTimeMillis;
		
	}

}
