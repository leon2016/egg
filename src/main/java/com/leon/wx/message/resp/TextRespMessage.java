package com.leon.wx.message.resp;

/**
 * ClassName: TextMessage
 * 
 * @Description: 普通消息-文本消息消息体
 * @author wangang
 * @date 2018-06-01
 */
public class TextRespMessage extends BaseRespMessage {
	// 回复的消息内容
	private String Content;

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}
}