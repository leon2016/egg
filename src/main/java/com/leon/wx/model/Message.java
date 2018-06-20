package com.leon.wx.model;

public class Message {
	private Object data;

	public static Message success(Object obj) {
		Message message = new Message();
		message.setData(obj);
		return message;
	}
	
	public static Message error() {
		Message message = new Message();
		return message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
