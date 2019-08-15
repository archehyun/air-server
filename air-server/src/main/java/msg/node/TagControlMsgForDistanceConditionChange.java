package msg.node;

/**
 * Spatial Event Generator�� ���� �±��� ������ ���� ������ ����� Tag Control Message
 * 
 * @author		�ں���
 * @since       2014-01-25
 * @version     0.1       
 */
public class TagControlMsgForDistanceConditionChange extends TagControlMsg
{
	private int movingDistance; //�±װ� �� �Ÿ�(meter)��ŭ �̵��ϸ� ������ ���� ��û
	
	public TagControlMsgForDistanceConditionChange(String tid, String cid, int movingDistance)
	{
		super(tid, cid, null);
		this.movingDistance = movingDistance;
	}

	public int getMovingDistance()
	{
		return movingDistance;
	}

	public void setMovingDistance(int movingDistance)
	{
		this.movingDistance = movingDistance;
	}
}
