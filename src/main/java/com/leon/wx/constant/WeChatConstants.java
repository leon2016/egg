package com.leon.wx.constant;

import java.util.HashMap;
import java.util.Map;

public class WeChatConstants {
	public static String TOKEN = "leon";
	public static String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token";
	public static String APP_ID = "wxdf8387e2afcf8f85";
	public static String APP_SECRET = "dca5644591bf0b351a988b90ea283612";

	public static Map<String, Object> wxMap = new HashMap<String, Object>();

	public static String getTOKEN() {
		return TOKEN;
	}

	public static void setTOKEN(String tOKEN) {
		TOKEN = tOKEN;
	}

	public static String getACCESS_TOKEN_URL() {
		return ACCESS_TOKEN_URL;
	}

	public static void setACCESS_TOKEN_URL(String aCCESS_TOKEN_URL) {
		ACCESS_TOKEN_URL = aCCESS_TOKEN_URL;
	}

	public static String getAPP_ID() {
		return APP_ID;
	}

	public static void setAPP_ID(String aPP_ID) {
		APP_ID = aPP_ID;
	}

	public static String getAPP_SECRET() {
		return APP_SECRET;
	}

	public static void setAPP_SECRET(String aPP_SECRET) {
		APP_SECRET = aPP_SECRET;
	}

	public static Map<String, Object> getWxMap() {
		return wxMap;
	}

	public static void setWxMap(Map<String, Object> wxMap) {
		WeChatConstants.wxMap = wxMap;
	}

}
