package com.leon.wx.menu;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.leon.wx.constant.WeChatConstants;
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

		String baseOauthUrl = WeChatConstants.PAGE_OAUTH2_URL + "?appid=" + WeChatConstants.getAPP_ID()
		        + "&redirect_uri=";
		String baseOauthUrlEnd = "&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect";
		
		ViewButton vbt1 = new ViewButton();
		vbt1.setUrl(baseOauthUrl + "https://leon.natappvip.cc/wx/news/toNewsList" + baseOauthUrlEnd);
		vbt1.setName("最新活动");
		vbt1.setType("view");
		ViewButton vbt2 = new ViewButton();
		vbt2.setUrl(baseOauthUrl + "https://leon.natappvip.cc/wx/news/toNewsEdit" + baseOauthUrlEnd);
		vbt2.setName("发布活动");
		vbt2.setType("view");

		ViewButton vbt3 = new ViewButton();
		vbt3.setUrl(
		        "http://wx092f9e38cf99.b.qun.hk/b/092f9e38cf99/s/dXNlcnF1bjJkMDEzMzhhMDc2YjExNTMzYzg3YThlOTc3ZWJiYzZl");
		vbt3.setName("通讯录");
		vbt3.setType("view");
		ViewButton vbt4 = new ViewButton();
		vbt4.setUrl(baseOauthUrl + "https://leon.natappvip.cc/wx/job/toJobList" + baseOauthUrlEnd);
		vbt4.setName("招聘信息");
		vbt4.setType("view");
		ViewButton vbt5 = new ViewButton();
		vbt5.setUrl(baseOauthUrl + "https://leon.natappvip.cc/wx/job/toJobNeedList" + baseOauthUrlEnd);
		vbt5.setName("求职信息");
		vbt5.setType("view");
		ViewButton vbt6 = new ViewButton();
		vbt6.setUrl(baseOauthUrl + "https://leon.natappvip.cc/wx/creator/toCreatorItemList" + baseOauthUrlEnd);
		vbt6.setName("创业项目");
		vbt6.setType("view");

		ViewButton vbt7 = new ViewButton();
		vbt7.setUrl(baseOauthUrl + "https://leon.natappvip.cc/wx/vip/toVipCost" + baseOauthUrlEnd);
		vbt7.setName("缴纳会费");
		vbt7.setType("view");
		ViewButton vbt8 = new ViewButton();
		vbt8.setUrl("https://weui.io");
		vbt8.setName("会员列表");
		vbt8.setType("view");
		ViewButton vbt9 = new ViewButton();
		vbt9.setUrl("https://leon.natappvip.cc/jssdk_config.jsp");
		vbt9.setName("LIVE&AI");
		vbt9.setType("view");

		// 二级菜单
		JSONArray sub_button = new JSONArray();
		sub_button.add(JSON.toJSON(vbt1));
		sub_button.add(JSON.toJSON(vbt2));

		JSONArray sub_button2 = new JSONArray();
		sub_button2.add(JSON.toJSON(vbt3));
		sub_button2.add(JSON.toJSON(vbt4));
		sub_button2.add(JSON.toJSON(vbt5));
		sub_button2.add(JSON.toJSON(vbt6));

		JSONArray sub_button3 = new JSONArray();
		sub_button3.add(JSON.toJSON(vbt7));
		sub_button3.add(JSON.toJSON(vbt8));
		sub_button3.add(JSON.toJSON(vbt9));

		// 一级菜单
		JSONObject buttonOne = new JSONObject();
		buttonOne.put("name", "活动");
		buttonOne.put("sub_button", sub_button);

		JSONObject buttonTwo = new JSONObject();
		buttonTwo.put("name", "资源");
		buttonTwo.put("sub_button", sub_button2);

		JSONObject buttonThree = new JSONObject();
		buttonThree.put("name", "更多");
		buttonThree.put("sub_button", sub_button3);

		// 最终结果
		JSONArray button = new JSONArray();
		button.add(buttonOne);
		button.add(buttonTwo);
		button.add(buttonThree);

		JSONObject menujson = new JSONObject();
		menujson.put("button", button);
		System.out.println(menujson);
		String accessToken = "11_KOkTCsagHsKVFpCbgEGF3J79G3cxjV1rdCXRMTMqghZ42Df6HobmH5XMMp6XyRmbzA--bPh-damtCB2-XePMyNste1b8jxA48jVS5bOR27kUSQU3UD4LluO0uL73Gr7Cg8IVTTYqT9xoP1Y1ODFhABATIK";
		String url = MENU_CREATE_URL + "?access_token=" + accessToken;

		try {
			String rs = HttpUtils.sendPostBuffer(url, menujson.toJSONString());
			System.out.println(rs);
		} catch (Exception e) {
			System.out.println("请求错误！");
		}

	}

}