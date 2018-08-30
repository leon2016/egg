package com.leon.wx.message.event;

/**
 * 自定义菜单事件
 * 
 * @author wangang
 * @date 2018-06-01
 */
public class MenuEvent extends BaseEvent {
	// 事件KEY值，与自定义菜单接口中KEY值对应
	private String EventKey;

	public String getEventKey() {
		return EventKey;
	}

	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}
}
