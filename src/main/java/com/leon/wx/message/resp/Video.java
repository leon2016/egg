package com.leon.wx.message.resp;

/**
 * ClassName: Video
 * 
 * @Description: 视频消息体
 * @author wangang
 * @date 2018-06-01
 */
public class Video {

	private String MediaId;
	private String Title;
	private String Description;

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

}