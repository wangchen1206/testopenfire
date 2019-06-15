package com.hp.roam.executor.service;

import java.io.IOException;
import java.util.concurrent.Executor;

import javax.annotation.Resource;

import org.jivesoftware.smack.ConnectionConfiguration.SecurityMode;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.SmackException.NotConnectedException;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Message.Type;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import org.jivesoftware.smack.tcp.XMPPTCPConnectionConfiguration;
import org.jivesoftware.smackx.receipts.DeliveryReceiptRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.hp.roam.model.OfUser;


/**
 * @author ck
 * @date 2019年3月13日 下午5:01:05
 */
@Service
public class ExecutorSercice {

	@Value("${openfire.domain}")
	private String domain;
	@Value("${openfire.host}")
	private String host;
	@Value("${openfire.port}")
	private String port;
	
	@Resource(name="getAsyncExecutor")
	private Executor executor;
	
//	@Autowired
//	private XMPPTCPConnectionConfiguration configBuilder;
	
	@Async
	public void executeAsyncTask(OfUser user){
		System.out.println(Thread.currentThread().getName()+"---"+user.getUsername());
			try {
				XMPPTCPConnectionConfiguration configBuilder;
				configBuilder = XMPPTCPConnectionConfiguration.builder()
						.setXmppDomain(domain)
						.setSecurityMode(SecurityMode.disabled)
//					.setSocketFactory(new DummySSLSocketFactory())
						.setConnectTimeout(60000)
						.setDebuggerEnabled(true)
//					.setCustomSSLContext(SSLContext.getDefault())
//					.setEnabledSSLProtocols(sslProtocols)
						.setUsernameAndPassword(user.getUsername(), "123")
						.setHost(host).setPort(Integer.valueOf(port)).setSendPresence(true).build();
				XMPPTCPConnection connection = new XMPPTCPConnection(configBuilder);
				connection.connect().login();
				//String msg = "heart beat";
				Presence presence = new Presence(Presence.Type.available);
				while (true) {
					if(!connection.isConnected()){
						connection.connect().login();
					}
					if(!connection.isAuthenticated()){
						connection.login();
					}
					System.out.println(Thread.currentThread().getName()+"执行");
					
					connection.sendStanza(presence);
//					sendMsg(connection, user.getUsername()+"@" + domain,
//							"adminjob@"+domain, msg, Type.chat);
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
	
	@Async
	public void executeAsyncTaskStop(OfUser user){
		System.out.println(Thread.currentThread().getName()+"---"+user.getUsername());
			try {
				XMPPTCPConnectionConfiguration configBuilder;
				configBuilder = XMPPTCPConnectionConfiguration.builder()
						.setXmppDomain(domain)
						.setSecurityMode(SecurityMode.disabled)
//					.setSocketFactory(new DummySSLSocketFactory())
						.setConnectTimeout(45000)
//					.setCustomSSLContext(SSLContext.getDefault())
//					.setEnabledSSLProtocols(sslProtocols)
						.setUsernameAndPassword(user.getUsername(), "123")
						.setHost(host).setPort(Integer.valueOf(port)).setSendPresence(true).build();
				XMPPTCPConnection connection = new XMPPTCPConnection(configBuilder);
				connection.connect().login();
				Presence presence = new Presence(Presence.Type.unavailable);
				connection.sendStanza(presence);
				
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
//			message.setTo(sendTo);
			message.setType(type);// 离线支持
			DeliveryReceiptRequest deliveryReceiptRequest = new DeliveryReceiptRequest();
			message.addExtension(deliveryReceiptRequest);
			//Presence presence = new Presence(Presence.Type.unavailable);
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
	
	@Async
	public void testTask1(Integer integer) throws InterruptedException{
		System.out.println(Thread.currentThread().getName()+"任务"+integer);
//		Thread.sleep(2000);
	}
}
