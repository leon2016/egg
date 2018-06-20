package com.leon.wx.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.leon.wx.constant.WeChatConstants;

/**
 * ClassName: WeChatTask
 * 
 * @Description: 微信两小时定时任务体
 */
public class WeChatTask {
	private static Logger logger = Logger.getLogger(WeChatTask.class);

	/**
	 * @Description: 任务执行体
	 * @param @throws
	 *            Exception
	 */
	public static void getToken_getTicket() {
		Map<String, String> params = new HashMap<String, String>();
		params.put("grant_type", "client_credential");
		params.put("appid", WeChatConstants.getAPP_ID());
		params.put("secret", WeChatConstants.getAPP_SECRET());
		String jstoken;
		try {
			// 生成timestamp
			String timestamp = create_timestamp();
			WeChatConstants.wxMap.put(WeChatConstants.TIMESTAMP, timestamp);
			logger.info("timestamp 为：");
			logger.info(timestamp);

			// 获得access_token
			jstoken = HttpUtils.sendGet(WeChatConstants.getACCESS_TOKEN_URL(), params);
			String access_token = JSONObject.parseObject(jstoken).getString("access_token"); // 获取到 token 并赋值保存
			WeChatConstants.wxMap.put(WeChatConstants.ACCESS_TOKEN, access_token);
			logger.info("token 为：");
			logger.info(access_token);

			// 获得jsapi_ticket
			params.clear();
			params.put("access_token", access_token);
			params.put("type", "jsapi");
			String jsticket = HttpUtils.sendGet(WeChatConstants.API_TICKET_URL, params);
			String jsapi_ticket = JSONObject.parseObject(jsticket).getString("ticket");
			WeChatConstants.wxMap.put(WeChatConstants.JSAPI_TICKET, jsapi_ticket); // 获取到 js-SDK 的 ticket 并赋值保存
			logger.info("jsapi_ticket 为：");
			logger.info(jsapi_ticket);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

	private static String create_timestamp() {
		return Long.toString(System.currentTimeMillis() / 1000);
	}
}