package com.hp.roam;

import java.security.KeyStore;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManagerFactory;

import org.jivesoftware.smack.ConnectionConfiguration.SecurityMode;
import org.jivesoftware.smack.SmackException.NotConnectedException;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Message.Type;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import org.jivesoftware.smack.tcp.XMPPTCPConnectionConfiguration;
import org.jivesoftware.smackx.receipts.DeliveryReceiptRequest;
import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.hp.roam.model.SysUser;
import com.hp.roam.util.XmppConnection;

/**
 * @author ck
 * @date 2019年2月28日 下午2:38:53
 */
public class TestSecurity {
	
	

	@Test
	public void TestLombok(){
		TestLombok testLombok = TestLombok.builder().age(11).username("jin").build();
		System.out.println(testLombok);
	}
	
	
	@Test
	public void testBCryptPassword(){
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		System.out.println(bCryptPasswordEncoder.encode("admin").trim());
		System.out.println(bCryptPasswordEncoder.encode("abel").trim());
	}
	
	static int port = 5223;
	static String host = "127.0.0.1";
	static String SERVERNAME3 = "wachen7.auth.hpicorp.net";
	static String[] sslProtocols = {"TLS", "TLSv1", "TLSv1.1", "TLSv1.2"};
	

	@Test
	public void testXmpp() throws Exception {
		
		KeyStore trustStore = KeyStore.getInstance("JKS");
        trustStore.load(getClass().getResourceAsStream("C:\\Users\\wachen\\java\\jre\\lib\\security\\jssecacerts"), "changeit".toCharArray());
        TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509");
        tmf.init(trustStore);
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, tmf.getTrustManagers(), null);
		
		
		// @在openfire中是特殊字符需要转义成特殊的字符串\40 ，这里smack会对’\‘当成转义字符，所以再加上一个\.
        HostnameVerifier hostnameVerifier = new HostnameVerifier() {
			
			@Override
			public boolean verify(String SERVERNAME3, SSLSession session) {
				// TODO Auto-generated method stub
				return true;
			}
		};
		XMPPTCPConnectionConfiguration configBuilder;
		configBuilder = XMPPTCPConnectionConfiguration.builder()
				.setXmppDomain(SERVERNAME3)
				.setUsernameAndPassword("dodo1000\\40openfire.com", "123")
				.setSecurityMode(SecurityMode.required)
//				.setSocketFactory(new DummySSLSocketFactory())
				.setConnectTimeout(45000)
				.setCustomSSLContext(sslContext)
				.setHostnameVerifier(hostnameVerifier)
//				.setEnabledSSLProtocols(sslProtocols)
				.setHost(host).setPort(port).setSendPresence(true).build();
		XMPPTCPConnection connection = new XMPPTCPConnection(configBuilder);
		connection.connect().login();
		String msg = "heart beat";
		while (true) {
			sendMsg(connection, "admin_pms@" + SERVERNAME3,
					"adminjob@" + SERVERNAME3, msg, Type.chat);
		}
	}

	public static void sendMsg(XMPPTCPConnection connection, String sendfrom,
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
	
	
	@Test
	public void testTreadTask(){
		SysUser user1 = new SysUser();
		user1.setUsername("admin_pms");
		user1.setPassword("123");
		SysUser user2 = new SysUser();
		user2.setUsername("test@test.com");
		user2.setPassword("123");
		List<SysUser> users = new ArrayList<>();
		users.add(user1);
		users.add(user2);
		Thread thread = new Thread(new ThreadTask(user2));
		thread.start();
//		for (SysUser sysUser : users) {
//		}
	}
	public static void main(String[] args) throws InterruptedException {
//		SysUser user1 = new SysUser();
//		user1.setUsername("admin_pms");
//		user1.setPassword("123");
//		SysUser user2 = new SysUser();
//		user2.setUsername("test@test.com");
//		user2.setPassword("123");
//		List<SysUser> users = new ArrayList<>();
//		users.add(user1);
//		users.add(user2);
//		Thread thread = new Thread(new ThreadTask(user1));
//		thread.start();
//		for (SysUser sysUser : users) {
//			Thread thread = new Thread(new ThreadTask(sysUser));
//			thread.start();
//		}
		
		
		XmppConnection connection = XmppConnection.getInstance();
		System.out.println(connection.login("adminjob", "123"));
		System.out.println(connection.isAuthenticated());
		Thread.sleep(5000);
	}
	
	@Test
	public void test11(){
		SysUser user1 = new SysUser();
		user1.setUsername("admin_pms");
		user1.setPassword("123");
		SysUser user2 = new SysUser();
		user2.setUsername("test\40test.com");
		user2.setPassword("123");
		List<SysUser> users = new ArrayList<>();
		users.add(user1);
		users.add(user2);
		Thread thread = new Thread(new ThreadTask(user1));
		thread.start();
	}
	
	@Test
	public void testXmppConn() throws InterruptedException{
		XmppConnection connection = new XmppConnection();
		System.out.println(connection.login("adminjob", "123"));
		System.out.println(connection.isAuthenticated());
		Thread.sleep(5000);
	}
}
