package com.leon.wx.util;

import java.util.HashMap;

import com.alibaba.fastjson.JSONObject;
import com.leon.wx.constant.WeChatConstants;

public class WxUserInfoUtils {
	/**
	 * @Description: 通过 openid 获取用户微信信息
	 * @param @param
	 *            openid
	 * @param @return
	 * @param @throws
	 *            Exception
	 * @author wangang
	 * @date 2018-06-01
	 */
	public static HashMap<String, String> getUserInfoByOpenid(String openid) throws Exception {
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("access_token", WeChatConstants.getAccessToken()); // 定时器中获取到的 token
		params.put("openid", openid); // 需要获取的用户的 openid
		params.put("lang", "zh_CN");
		String subscribers = HttpUtils.sendGet(WeChatConstants.OPENID_USER_INFO_URL, params);
		System.out.println(subscribers);
		params.clear();
		// 这里返回参数只取了昵称、头像、和性别
		params.put("nickname", JSONObject.parseObject(subscribers).getString("nickname")); // 昵称
		params.put("headimgurl", JSONObject.parseObject(subscribers).getString("headimgurl")); // 图像
		params.put("sex", JSONObject.parseObject(subscribers).getString("sex")); // 性别
		return params;
	}
}
