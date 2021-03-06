package com.leon.wx.message.req;

/**
 * ClassName: VoiceMessage
 * 
 * @Description: 语音消息
 * @author wangang
 * @date 2018-06-01
 */
public class VoiceMessage extends BaseMessage {
	// 媒体 ID
	private String MediaId;
	// 语音格式
	private String Format;
	// 语言识别结果
	private String Recognition;

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

	public String getFormat() {
		return Format;
	}

	public void setFormat(String format) {
		Format = format;
	}

	public String getRecognition() {
		return Recognition;
	}

	public void setRecognition(String recognition) {
		Recognition = recognition;
	}
	
}