package com.leon.wx.dispatcher;

import java.util.Map;

import com.leon.wx.util.MessageUtil;

/**
 * ClassName: EventDispatcher
 * 
 * @Description: 事件消息业务分发器
 * @author wangang
 * @date 2018-06-01
 */
public class EventDispatcher {
	public static String processEvent(Map<String, String> map) {
		if (map.get("Event").equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) { // 关注事件
			System.out.println("==============这是关注事件！");
		} else if (map.get("Event").equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) { // 取消关注事件
			System.out.println("==============这是取消关注事件！");
		} else if (map.get("Event").equals(MessageUtil.EVENT_TYPE_SCAN)) { // 扫描二维码事件
			System.out.println("==============这是扫描二维码事件！");
		} else if (map.get("Event").equals(MessageUtil.EVENT_TYPE_LOCATION)) { // 位置上报事件
			System.out.println("==============这是位置上报事件！");
		} else if (map.get("Event").equals(MessageUtil.EVENT_TYPE_CLICK)) { // 自定义菜单点击事件
			System.out.println("==============这是自定义菜单点击事件！");
		} else if (map.get("Event").equals(MessageUtil.EVENT_TYPE_VIEW)) { // 自定义菜单 View 事件
			System.out.println("==============这是自定义菜单 View 事件！");
		} else {
			System.out.println("==============其他事件，Event=" + map.get("Event"));
		}

		return null;
	}
}