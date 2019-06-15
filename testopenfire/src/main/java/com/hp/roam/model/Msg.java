package com.hp.roam.model;
/**
 * @author ck
 * @date 2019年2月27日 下午4:05:22
 */
public class Msg {
	private String title;
	private String content;
	private String etraInfo;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getEtraInfo() {
		return etraInfo;
	}
	public void setEtraInfo(String etraInfo) {
		this.etraInfo = etraInfo;
	}
	public Msg(String title, String content, String etraInfo) {
		super();
		this.title = title;
		this.content = content;
		this.etraInfo = etraInfo;
	}
	
}
