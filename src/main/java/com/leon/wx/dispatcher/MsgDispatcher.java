package com.leon.wx.dispatcher;

import java.util.Map;

import com.leon.wx.util.MessageUtil;

/**
 * ClassName: MsgDispatcher
 * 
 * @Description: 消息业务处理分发器
 * @author wangang
 * @date 2018-06-01
 */
public class MsgDispatcher {
	public static String processMessage(Map<String, String> map) {
		if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) { // 文本消息
			System.out.println("==============这是文本消息！");
		} else if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) { // 语音消息
			System.out.println("==============这是语音消息！");
		} else if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) { // 图片消息
			System.out.println("==============这是图片消息！");
		} else if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) { // 链接消息
			System.out.println("==============这是链接消息！");
		} else if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) { // 位置消息
			System.out.println("==============这是位置消息！");
		} else if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_VIDEO)) { // 视频消息
			System.out.println("==============这是视频消息！");
		} else if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_SHORTVIDEO)) { // 语音消息
			System.out.println("==============这是小视频消息！");
		} else {
			System.out.println("==============其他消息，MsgType=" + map.get("MsgType"));
		}

		return null;
	}
}