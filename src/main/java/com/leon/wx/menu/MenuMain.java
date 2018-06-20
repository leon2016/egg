package com.leon.wx.menu;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.leon.wx.util.HttpUtils;

/**
 * 菜单快捷操作
 * 
 * @author wangang
 * @date 2018-06-01
 *
 */
public class MenuMain {
	private static String MENU_CREATE_URL = "https://api.weixin.qq.com/cgi-bin/menu/create";

	public static void main(String[] args) {

		ClickButton cbt = new ClickButton();
		cbt.setKey("image");
		cbt.setName("回复图片");
		cbt.setType("click");

		ViewButton vbt = new ViewButton();
		vbt.setUrl("https://leon.natappvip.cc/jssdk_config.jsp");
		vbt.setName("示例");
		vbt.setType("view");

		JSONArray sub_button = new JSONArray();
		sub_button.add(JSON.toJSON(cbt));
		sub_button.add(JSON.toJSON(vbt));

		JSONObject buttonOne = new JSONObject();
		buttonOne.put("name", "菜单");
		buttonOne.put("sub_button", sub_button);

		JSONArray button = new JSONArray();
		button.add(buttonOne);
		button.add(vbt);
		button.add(cbt);

		JSONObject menujson = new JSONObject();
		menujson.put("button", button);
		System.out.println(menujson);
		String url = MENU_CREATE_URL + "?access_token="
		        + "10_lJ-vTZrtWYfYNV6SWK3frgVFGY0YdmFjmre1uEyNxGBZzbrTH9OaGL9tSUSJvoeWYbRF_gC5naqckA1jhQcDdbYorvQLii3eXVqqXtl2-gvFnqOqB-Ro5pd3YOIUQMiAIAQMI";

		try {
			String rs = HttpUtils.sendPostBuffer(url, menujson.toJSONString());
			System.out.println(rs);
		} catch (Exception e) {
			System.out.println("请求错误！");
		}

	}

}