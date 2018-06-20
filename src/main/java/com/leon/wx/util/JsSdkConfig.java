package com.leon.wx.util;

import java.security.MessageDigest;
import java.util.Formatter;
import java.util.HashMap;
import java.util.UUID;

import org.apache.log4j.Logger;

import com.leon.wx.constant.WeChatConstants;

/**
 * ClassName: JSSDK_Config
 * 
 * @Description: 用户微信前端页面的 jssdk 配置使用
 * @author wangang
 * @date 2018-06-01
 */
public class JsSdkConfig {
	private static Logger logger = Logger.getLogger(JsSdkConfig.class);

	/**
	 * @Description: 前端 jssdk 页面配置需要用到的配置参数
	 * @param @return
	 *            hashmap {appid,timestamp,nonceStr,signature}
	 * @param @throws
	 *            Exception
	 * @author dapengniao
	 * @date 2016 年 3 月 19 日 下午 3:53:23
	 */
	public static HashMap<String, String> jsSDK_Sign(String url) throws Exception {
		String nonce_str = create_nonce_str();
		String timestamp = (String) WeChatConstants.wxMap.get("timestamp");
		String jsapi_ticket = (String) WeChatConstants.wxMap.get("jsapi_ticket");
		// 注意这里参数名必须全部小写，且必须有序
		String string1 = "jsapi_ticket=" + jsapi_ticket + "&noncestr=" + nonce_str + "&timestamp=" + timestamp + "&url="
		        + url;
		logger.debug(string1);
		MessageDigest crypt = MessageDigest.getInstance("SHA-1");
		crypt.reset();
		crypt.update(string1.getBytes("UTF-8"));
		String signature = byteToHex(crypt.digest());
		HashMap<String, String> jssdk = new HashMap<String, String>();
		jssdk.put("appId", WeChatConstants.APP_ID);
		jssdk.put("timestamp", timestamp);
		jssdk.put("nonceStr", nonce_str);
		jssdk.put("signature", signature);
		return jssdk;

	}

	private static String byteToHex(final byte[] hash) {
		Formatter formatter = new Formatter();
		for (byte b : hash) {
			formatter.format("%02x", b);
		}
		String result = formatter.toString();
		formatter.close();
		return result;
	}

	private static String create_nonce_str() {
		return UUID.randomUUID().toString();
	}

}