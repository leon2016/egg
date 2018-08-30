package com.leon.wx.menu;

/**
 * ClassName: ClickButton
 * 
 * @Description: 点击型菜单事件
 * @author wangang
 * @date 2018-06-01
 */
public class ClickButton extends Button {
	private String type;
	private String key;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

}