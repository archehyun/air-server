package msg.node;


/**
 * �±� �����Ϳ� ���� ������ �����ϴ� ����� ������ ó�� ����� XML�� ǥ���Ͽ� ����ڿ��� �����ϱ� ���� Message
 * 
 * @author		�����
 * @since       2014-02-06
 * @version     0.1      
 */
public class MsgForAPI extends QueueNode
{
	private String userID;
	private int queryID;
	private String resultXML; //�±� �����Ϳ� ���� ������ �����ϴ� ����� ������ ó�� ��� ������(XML�� ǥ��)
	
	public MsgForAPI(String userID, int queryID, String resultXML)
	{
		super();
		this.userID = userID;
		this.queryID = queryID;
		this.resultXML = resultXML;
	}

	public String getUserID()
	{
		return userID;
	}

	public void setUserID(String userID)
	{
		this.userID = userID;
	}
	
	public int getQueryID()
	{
		return queryID;
	}

	public void setQueryID(int queryID)
	{
		this.queryID = queryID;
	}

	public String getResultXML()
	{
		return resultXML;
	}

	public void setResultXML(String resultXML)
	{
		this.resultXML = resultXML;
	}
}
