package msg.node;

/**
 * �±��� activation request�� ���� permission�� ����� Tag Control Message
 * 
 * @author		�����
 * @since       2014-02-06
 * @version     0.1      
 */
public class InboundControlMsgForActivationPermissionACK extends InboundMsg
{	

	public InboundControlMsgForActivationPermissionACK(String tid, String cid) {
		super(tid, cid);
	}
}
