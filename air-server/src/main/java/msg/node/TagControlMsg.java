package msg.node;


/**
 * �±׷� ������ Control Packet�� ��������ϴ� Tag Control Message Queue�� ��� 
 * 
 * @author		�����
 * @since       2014-02-06
 * @version     0.1      
 */
public class TagControlMsg extends QueueNode implements OutboundMessage
{
	private String tid; //�±� ID
	private String cid; //�����̳� ID
	private String tagIPaddr; //�±� IP�ּ�
	
	public TagControlMsg(String tid, String cid, String tagIPaddr) {
		super();
		this.tid = tid;
		this.cid = cid;
		this.tagIPaddr = tagIPaddr;
	}
	
	public String getTid() {
		return tid;
	}
	
	public void setTid(String tid) {
		this.tid = tid;
	}
	
	public String getCid() {
		return cid;
	}
	
	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getTagIPaddr() {
		return tagIPaddr;
	}

	public void setTagIPaddr(String tagIPaddr) {
		this.tagIPaddr = tagIPaddr;
	}
}
