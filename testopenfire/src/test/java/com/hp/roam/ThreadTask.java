package com.hp.roam;

import java.io.IOException;

import org.jivesoftware.smack.ConnectionConfiguration.SecurityMode;
import org.jivesoftware.smack.SASLAuthentication;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.SmackException.NotConnectedException;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Message.Type;
import org.jivesoftware.smack.sasl.javax.SASLPlainMechanism;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import org.jivesoftware.smack.tcp.XMPPTCPConnectionConfiguration;
import org.jivesoftware.smackx.receipts.DeliveryReceiptRequest;

import com.hp.roam.model.SysUser;

public class ThreadTask implements Runnable{

	 int port = 5222;
	 String host = "114.215.135.121";
	 String SERVERNAME3 = "test";
	 String[] sslProtocols = {"TLS", "TLSv1", "TLSv1.1", "TLSv1.2"};
	
	private SysUser user;
	
	
	public ThreadTask(SysUser user) {
		super();
		this.user = user;
	}

	@Override
	public void run() {
		System.out.println(user);
		XMPPTCPConnectionConfiguration configBuilder;
		try {
			configBuilder = XMPPTCPConnectionConfiguration.builder()
					.setXmppDomain(SERVERNAME3)
					.setUsernameAndPassword(user.getUsername(), user.getPassword())
					.setSecurityMode(SecurityMode.disabled)
//				.setSocketFactory(new DummySSLSocketFactory())
					.setConnectTimeout(45000)
//				.setCustomSSLContext(SSLContext.getDefault())
//				.setEnabledSSLProtocols(sslProtocols)
					.setHost(host).setPort(port).setSendPresence(true).build();
			SASLAuthentication.registerSASLMechanism(new SASLPlainMechanism());
			XMPPTCPConnection connection = new XMPPTCPConnection(configBuilder);
			connection.connect().login();
			String msg = "heart beat";
			while (true) {
				sendMsg(connection, "admin_pms@" + SERVERNAME3,
						"adminjob@" + SERVERNAME3, msg, Type.chat);
			}
		} catch (XMPPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SmackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void sendMsg(XMPPTCPConnection connection, String sendfrom,
			String sendTo, String msg, Type type) throws Exception {

		try {
			int i = 200;
			Message message = new Message();
			message.setBody(msg);
			message.setTo(sendTo);
			message.setType(type);// 离线支持
			DeliveryReceiptRequest deliveryReceiptRequest = new DeliveryReceiptRequest();
			message.addExtension(deliveryReceiptRequest);
			connection.sendStanza(message);

			try {
				Thread.sleep(1000);
				System.out.println(i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		} catch (NotConnectedException e) {
			e.printStackTrace();
		}
	}
}
