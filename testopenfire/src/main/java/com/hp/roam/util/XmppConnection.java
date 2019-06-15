package com.hp.roam.util;


 
import java.io.IOException;
import java.net.InetAddress;

import org.jivesoftware.smack.AbstractXMPPConnection;
import org.jivesoftware.smack.ConnectionConfiguration.SecurityMode;
import org.jivesoftware.smack.SmackConfiguration;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smack.roster.Roster;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import org.jivesoftware.smack.tcp.XMPPTCPConnectionConfiguration;
import org.jivesoftware.smackx.iqregister.AccountManager;
import org.jxmpp.jid.parts.Localpart;
import org.jxmpp.stringprep.XmppStringprepException;
 
/**
 * XmppConnection 工具类
 */
public class XmppConnection {
	
	
    private int SERVER_PORT = 5222;
    private String SERVER_HOST = "114.215.135.121";
    private String SERVER_NAME = "test";
    private AbstractXMPPConnection connection = null;
    private static XmppConnection xmppConnection = new XmppConnection();
 
    /**
     * 单例模式
     *
     * @return XmppConnection
     */
    public synchronized static XmppConnection getInstance() {
        return xmppConnection;
    }
 
    /**
     * 创建连接
     */
    public AbstractXMPPConnection getConnection() {
        if (connection == null) {
            // 开线程打开连接，避免在主线程里面执行HTTP请求
            // Caused by: android.os.NetworkOnMainThreadException
            new Thread(new Runnable() {
                @Override
                public void run() {
                    openConnection();
                }
            }).start();
        }
        return connection;
    }
 
    /**
     * 判断是否已连接
     */
    public boolean checkConnection() {
        return null != connection && connection.isConnected();
    }
 
    /**
     * 打开连接
     */
    public boolean openConnection() {
        try {
            if (null == connection || !connection.isAuthenticated()) {
                SmackConfiguration.DEBUG = true;
                XMPPTCPConnectionConfiguration.Builder config = XMPPTCPConnectionConfiguration.builder();
                //设置openfire主机IP
                config.setHostAddress(InetAddress.getByName(SERVER_HOST));
                //设置openfire服务器名称
                config.setXmppDomain(SERVER_NAME);
                //设置端口号：默认5222
                config.setPort(SERVER_PORT);
                //禁用SSL连接
                config.setSecurityMode(SecurityMode.disabled);
                //设置Debug
                config.setDebuggerEnabled(true);
                //设置离线状态
                config.setSendPresence(false);
                //设置开启压缩，可以节省流量
                config.setCompressionEnabled(true);
 
                //需要经过同意才可以添加好友
                Roster.setDefaultSubscriptionMode(Roster.SubscriptionMode.manual);
 
                // 将相应机制隐掉
                //SASLAuthentication.blacklistSASLMechanism("SCRAM-SHA-1");
                //SASLAuthentication.blacklistSASLMechanism("DIGEST-MD5");
 
                connection = new XMPPTCPConnection(config.build());
                connection.connect();// 连接到服务器
                return true;
            }
        } catch (XMPPException | SmackException | IOException | InterruptedException xe) {
            xe.printStackTrace();
            connection = null;
        }
        return false;
    }
 
 
    /**
     * 判断连接是否通过了身份验证
     * 即是否已登录
     *
     * @return
     */
    public boolean isAuthenticated() {
        return connection != null && connection.isConnected() && connection.isAuthenticated();
    }
 
    /**
     * 登录
     *
     * @param account  登录帐号
     * @param password 登录密码
     * @return true登录成功
     */
    public boolean login(String account, String password) {
        try {
            if (getConnection() == null)
                return false;
 
            getConnection().login(account, password);
 
            // 更改在线状态
            setPresence(0);
 
            // 添加连接监听
//            connectionListener = new XMConnectionListener(account, password);
//            getConnection().addConnectionListener(connectionListener);
            return true;
        } catch (XMPPException | IOException | SmackException | InterruptedException xe) {
            xe.printStackTrace();
        }
        return false;
    }
 
    /**
     * 注册
     *
     * @param account  注册帐号
     * @param password 注册密码
     * @return 1、注册成功 0、注册失败
     */
    public String register(String account, String password) {
        if (getConnection() == null)
            return "0";
        try {
            AccountManager.getInstance(connection).createAccount(Localpart.from(account), password);
        } catch (XmppStringprepException | InterruptedException | XMPPException | SmackException e) {
            e.printStackTrace();
            return "0";
        }
 
        return "1";
    }

    /**
     * 更改用户状态
     */
    public void setPresence(int code) {
        XMPPConnection con = getConnection();
        if (con == null)
            return;
        Presence presence;
        try {
            switch (code) {
                case 0:
                    presence = new Presence(Presence.Type.available);
                    con.sendStanza(presence);
                   // Log.v("state", "设置在线");
                    break;
                case 1:
                    presence = new Presence(Presence.Type.available);
                    presence.setMode(Presence.Mode.chat);
                    con.sendStanza(presence);
                  //  Log.v("state", "设置Q我吧");
                    break;
                case 2:
                    presence = new Presence(Presence.Type.available);
                    presence.setMode(Presence.Mode.dnd);
                    con.sendStanza(presence);
                  //  Log.v("state", "设置忙碌");
                    break;
                case 3:
                    presence = new Presence(Presence.Type.available);
                    presence.setMode(Presence.Mode.away);
                    con.sendStanza(presence);
                   // Log.v("state", "设置离开");
                    break;
                case 4:
//                    Roster roster = con.getRoster();
//                    Collection<RosterEntry> entries = roster.getEntries();
//                    for (RosterEntry entry : entries) {
//                        presence = new Presence(Presence.Type.unavailable);
//                        presence.setPacketID(Packet.ID_NOT_AVAILABLE);
//                        presence.setFrom(con.getUser());
//                        presence.setTo(entry.getUser());
//                        con.sendPacket(presence);
//                        Log.v("state", presence.toXML());
//                    }
//                    // 向同一用户的其他客户端发送隐身状态
//                    presence = new Presence(Presence.Type.unavailable);
//                    presence.setPacketID(Packet.ID_NOT_AVAILABLE);
//                    presence.setFrom(con.getUser());
//                    presence.setTo(StringUtils.parseBareAddress(con.getUser()));
//                    con.sendStanza(presence);
//                    Log.v("state", "设置隐身");
//                    break;
                case 5:
                    presence = new Presence(Presence.Type.unavailable);
                    con.sendStanza(presence);
                   // Log.v("state", "设置离线");
                    break;
                default:
                    break;
            }
        } catch (SmackException.NotConnectedException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}