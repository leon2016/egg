package com.leon.wx.constant;

import java.util.HashMap;
import java.util.Map;

import com.leon.wx.util.WeChatTask;

public class WeChatConstants {
	public static final String site_url = "https://api.weixin.qq.com/";
	// 正式环境-leon
//	 public static String APP_ID = "wxdf8387e2afcf8f85";
//	 public static String APP_SECRET = "dca5644591bf0b351a988b90ea283612";
//	 public static String TOKEN = "leon";
	// 测试号-leon
	public static final String APP_ID = "wx1c6e85d9d1614619";
	public static final String APP_SECRET = "ba670721d003c4c302bdbaa75e54f936";
	public static final String TOKEN = "leon";

	// // 正式环境-wanda
	// public static String APP_ID = "wxed732654d1eb43bf";
	// public static String APP_SECRET = "3e278755f71c314d7b7c7b3c5d0762a4";
	// public static String TOKEN = "leon";

	// // 测试环境-wanda
//	 public static String APP_ID = "wx64f38e83158c675e";
//	 public static String APP_SECRET = "3e278755f71c314d7b7c7b3c5d0762a4";
//	 public static String TOKEN = "leon";

	public static final String TIMESTAMP = "timestamp";
	public static final String ACCESS_TOKEN = "access_token";
	public static final String JSAPI_TICKET = "jsapi_ticket";
	public static final String WX_USER_INFO = "wxUserInfo";

	/** 微信接口URL **/
	public static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token";
	public static final String API_TICKET_URL = "https://api.weixin.qq.com/cgi-bin/ticket/getticket";
	public static final String OPENID_USER_INFO_URL = "https://api.weixin.qq.com/cgi-bin/user/info";
	public static final String MENU_CREATE_URL = "https://api.weixin.qq.com/cgi-bin/menu/create";
	public static final String PAGE_OAUTH2_URL = "https://open.weixin.qq.com/connect/oauth2/authorize";
	public static final String SNS_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/access_token";
	public static final Map<String, Object> wxMap = new HashMap<String, Object>();

	public static String getAccessToken() {
		if (!wxMap.containsKey(ACCESS_TOKEN)) {
			WeChatTask.getToken_getTicket();
		}
		return (String) wxMap.get(ACCESS_TOKEN);
	}

	public static String getTOKEN() {
		return TOKEN;
	}

	public static String getACCESS_TOKEN_URL() {
		return ACCESS_TOKEN_URL;
	}

	public static String getAPP_ID() {
		return APP_ID;
	}

	public static String getAPP_SECRET() {
		return APP_SECRET;
	}

	public static Map<String, Object> getWxMap() {
		return wxMap;
	}

}
