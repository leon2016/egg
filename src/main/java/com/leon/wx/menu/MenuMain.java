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
		
		ViewButton vbt1 = new ViewButton();
		vbt1.setUrl("https://weui.io");
		vbt1.setName("最新政策申报");
		vbt1.setType("view");
		ViewButton vbt2 = new ViewButton();
		vbt2.setUrl("http://www.ssme.gov.cn/wechat/index.html#/首页/policy-library");
		vbt2.setName("政策知识库");
		vbt2.setType("view");
		ViewButton vbt3 = new ViewButton();
		vbt3.setUrl("https://leon.natappvip.cc/jssdk_config.jsp");
		vbt3.setName("最新活动");
		vbt3.setType("view");
		ViewButton vbt4 = new ViewButton();
		vbt4.setUrl("http://www.ssme.gov.cn/wechat/index.html#/首页/service-resource-list");
		vbt4.setName("服务资源库");
		vbt4.setType("view");
		ViewButton vbt5 = new ViewButton();
		vbt5.setUrl("https://leon.natappvip.cc/jssdk_config.jsp");
		vbt5.setName("各区旗舰店");
		vbt5.setType("view");
		
		// 二级菜单
		JSONArray sub_button = new JSONArray();
		sub_button.add(JSON.toJSON(vbt1));
		sub_button.add(JSON.toJSON(vbt2));
		
		JSONArray sub_button2 = new JSONArray();
		sub_button2.add(JSON.toJSON(vbt3));
		sub_button2.add(JSON.toJSON(vbt4));
		sub_button2.add(JSON.toJSON(vbt5));
		
		
		// 一级菜单
		JSONObject buttonOne = new JSONObject();
		buttonOne.put("name", "政策服务");
		buttonOne.put("sub_button", sub_button);
		
		ViewButton vbt6 = new ViewButton();
		vbt6.setUrl("http://www.ssme.gov.cn/wechat/index.html");
		vbt6.setName("服务大厅");
		vbt6.setType("view");
		
		JSONObject buttonThree = new JSONObject();
		buttonThree.put("name", "活动服务");
		buttonThree.put("sub_button", sub_button2);
		
		// 最终结果
		JSONArray button = new JSONArray();
		button.add(buttonOne);
		button.add(vbt6);
		button.add(buttonThree);
		
		
		
//		ClickButton cbt = new ClickButton();
//		cbt.setKey("image");
//		cbt.setName("回复图片");
//		cbt.setType("click");
//
//		ViewButton vbt = new ViewButton();
//		vbt.setUrl("https://leon.natappvip.cc/jssdk_config.jsp");
//		vbt.setName("示例");
//		vbt.setType("view");
//
//		JSONArray sub_button = new JSONArray();
//		sub_button.add(JSON.toJSON(cbt));
//		sub_button.add(JSON.toJSON(vbt));
//
//		JSONObject buttonOne = new JSONObject();
//		buttonOne.put("name", "菜单");
//		buttonOne.put("sub_button", sub_button);
//
//		JSONArray button = new JSONArray();
//		button.add(buttonOne);
//		button.add(vbt);
//		button.add(cbt);
//
		JSONObject menujson = new JSONObject();
		menujson.put("button", button);
		System.out.println(menujson);
		String url = MENU_CREATE_URL + "?access_token="
		        + "10_psdK_SZpeZSJB3l7vVV61pqibUZN2KHto9-KcDzoOnKE93hpBsJhpU_aAmrTVzsU6gR13jJMClvRhBHzfdhP3L35uB73wmnXBS4H4VNZXg0zf5fVPuqMRI6uu_kVBEeACALRU";

		try {
			String rs = HttpUtils.sendPostBuffer(url, menujson.toJSONString());
			System.out.println(rs);
		} catch (Exception e) {
			System.out.println("请求错误！");
		}

	}

}