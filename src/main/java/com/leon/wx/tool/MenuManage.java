package com.leon.wx.tool;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.leon.wx.constant.WeChatConstants;
import com.leon.wx.menu.Button;
import com.leon.wx.menu.ComplexButton;
import com.leon.wx.menu.Menu;
import com.leon.wx.menu.ViewButton;
import com.leon.wx.util.HttpUtils;

/**
 * 菜单快捷操作
 * 
 * @author wangang
 * @date 2018-06-01
 *
 */
public class MenuManage {

	// private static String HOST_URL = "http://47.75.147.142/";
	private static String HOST_URL = "https://leon.natappvip.cc/";

	private static String MENU_CREATE_URL = "https://api.weixin.qq.com/cgi-bin/menu/create";

	public static void main(String[] args) {

		String baseOauthUrl = WeChatConstants.PAGE_OAUTH2_URL + "?appid=" + WeChatConstants.getAPP_ID()
		        + "&redirect_uri=";
		String baseOauthUrlEnd = "&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect";

		// 所有按钮
		ViewButton bt0 = new ViewButton();
		bt0.setUrl("http://60xq.cust.edu.cn");
		bt0.setName("校庆官网");
		bt0.setType("view");

		ViewButton bt1 = new ViewButton();
		bt1.setUrl(baseOauthUrl + HOST_URL + "wx/news/toNewsList" + baseOauthUrlEnd);
		bt1.setName("最新活动");
		bt1.setType("view");

		ViewButton bt2 = new ViewButton();
		bt2.setUrl(baseOauthUrl + HOST_URL + "wx/news/toNewsEdit" + baseOauthUrlEnd);
		bt2.setName("发布活动");
		bt2.setType("view");

		ViewButton bt3 = new ViewButton();
		bt3.setUrl(
		        "http://wx092f9e38cf99.b.qun.hk/b/092f9e38cf99/s/dXNlcnF1bjJkMDEzMzhhMDc2YjExNTMzYzg3YThlOTc3ZWJiYzZl");
		bt3.setName("通讯录");
		bt3.setType("view");

		ViewButton bt4 = new ViewButton();
		bt4.setUrl(baseOauthUrl + HOST_URL + "wx/job/toJobList" + baseOauthUrlEnd);
		bt4.setName("招聘信息");
		bt4.setType("view");

		ViewButton bt5 = new ViewButton();
		bt5.setUrl(baseOauthUrl + HOST_URL + "wx/job/toJobNeedList" + baseOauthUrlEnd);
		bt5.setName("求职信息");
		bt5.setType("view");

		ViewButton bt6 = new ViewButton();
		bt6.setUrl(baseOauthUrl + HOST_URL + "wx/creator/toCreatorItemList" + baseOauthUrlEnd);
		bt6.setName("创业项目");
		bt6.setType("view");

		ViewButton bt7 = new ViewButton();
		bt7.setUrl(baseOauthUrl + HOST_URL + "wx/vip/toVipCost" + baseOauthUrlEnd);
		bt7.setName("缴纳会费");
		bt7.setType("view");

		ViewButton bt8 = new ViewButton();
		bt8.setUrl("https://weui.io");
		bt8.setName("会员列表");
		bt8.setType("view");

		ViewButton bt9 = new ViewButton();
		bt9.setUrl(HOST_URL + "jssdk_config.jsp");
		bt9.setName("LIVE&AI");
		bt9.setType("view");

		// 复合按钮
		ComplexButton cbt0 = new ComplexButton();
		cbt0.setName("活动");
		cbt0.setSub_button(new Button[] { bt0, bt1, bt2 });

		ComplexButton cbt1 = new ComplexButton();
		cbt1.setName("资源");
		cbt1.setSub_button(new Button[] { bt3, bt4, bt5, bt6 });

		ComplexButton cbt2 = new ComplexButton();
		cbt2.setName("更多");
		cbt2.setSub_button(new Button[] { bt7, bt8, bt9 });

		// 组成菜单
		Menu menu = new Menu();
		menu.setButton(new Button[] { cbt0, cbt1, cbt2 });

		// 将菜单对象转为json字符串
		String menujson = JSON.toJSONString(menu);
		System.out.println(menujson);

		String accessToken = getAccessToken();
		System.out.println("accessToken=" + accessToken);
		String url = MENU_CREATE_URL + "?access_token=" + accessToken;

		try {
			String rs = HttpUtils.sendPostBuffer(url, menujson);
			System.out.println(rs);
		} catch (Exception e) {
			System.out.println("请求错误！");
		}

	}

	/**
	 * 获得access_token
	 * 
	 * @return
	 */
	public static String getAccessToken() {
		Map<String, String> params = new HashMap<String, String>();
		params.put("grant_type", "client_credential");
		params.put("appid", WeChatConstants.getAPP_ID());
		params.put("secret", WeChatConstants.getAPP_SECRET());
		String jstoken = null;
		String access_token = null;
		try {
			jstoken = HttpUtils.sendGet(WeChatConstants.getACCESS_TOKEN_URL(), params);
			access_token = JSONObject.parseObject(jstoken).getString("access_token"); // 获取到 token 并赋值保存
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return access_token;
	}

}