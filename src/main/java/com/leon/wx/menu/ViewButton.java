package com.leon.wx.menu;

/**
 * ClassName: ViewButton
 * 
 * @Description: 视图型菜单事件
 * @author wangang
 * @date 2018-06-01
 */
public class ViewButton extends Button {
	private String type;
	private String url;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}