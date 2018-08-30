package com.leon.wx.menu;

/**
 * ClassName: ComplexButton
 * 
 * @Description: 复合类型的按钮
 * @author wangang
 * @date 2018-06-01
 */
public class ComplexButton extends Button {
	private Button[] sub_button;

	public Button[] getSub_button() {
		return sub_button;
	}

	public void setSub_button(Button[] sub_button) {
		this.sub_button = sub_button;
	}
}
