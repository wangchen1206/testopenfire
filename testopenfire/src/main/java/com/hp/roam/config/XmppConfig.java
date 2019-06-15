package com.hp.roam.config;

import org.jivesoftware.smack.ConnectionConfiguration.SecurityMode;
import org.jivesoftware.smack.tcp.XMPPTCPConnectionConfiguration;
import org.jxmpp.stringprep.XmppStringprepException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class XmppConfig {
	
	@Value("${openfire.domain}")
	private String domain;
	@Value("${openfire.host}")
	private String host;
	@Value("${openfire.port}")
	private String port;
	
	@Bean
	public XMPPTCPConnectionConfiguration createXMPPTCPConnectionConfiguration() throws XmppStringprepException{
		XMPPTCPConnectionConfiguration configBuilder;
		configBuilder = XMPPTCPConnectionConfiguration.builder()
				.setXmppDomain(domain)
				.setSecurityMode(SecurityMode.disabled)
//			.setSocketFactory(new DummySSLSocketFactory())
				.setConnectTimeout(45000)
//			.setCustomSSLContext(SSLContext.getDefault())
//			.setEnabledSSLProtocols(sslProtocols)
				.setHost(host).setPort(Integer.valueOf(port)).setSendPresence(true).build();
		return configBuilder;
	}
}
