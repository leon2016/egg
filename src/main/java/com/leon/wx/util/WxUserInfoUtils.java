package com.leon.wx.util;

import java.util.HashMap;

import com.alibaba.fastjson.JSONObject;
import com.leon.wx.constant.GlobalConstant;
import com.leon.wx.constant.WeChatConstants;
import com.leon.wx.model.WxUserInfo;

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
	public static WxUserInfo getUserInfoByOpenid(String openid) throws Exception {
		// 调用微信用户api拉取用户信息
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("access_token", WeChatConstants.getAccessToken()); // 定时器中获取到的 token
		params.put("openid", openid); // 需要获取的用户的 openid
		params.put("lang", "zh_CN");
		String subscribers = HttpUtils.sendGet(WeChatConstants.OPENID_USER_INFO_URL, params);

		WxUserInfo userInfo = new WxUserInfo();
		String subscribe = JSONObject.parseObject(subscribers).getString("subscribe");
		userInfo.setSubscribe(subscribe);
		userInfo.setOpenid(openid);
		if(GlobalConstant.NO_VALUE.equals(subscribe)) {
			return userInfo;
		}
		userInfo.setNickname(JSONObject.parseObject(subscribers).getString("nickname"));
		userInfo.setHeadimgurl(JSONObject.parseObject(subscribers).getString("headimgurl"));
		userInfo.setSex(JSONObject.parseObject(subscribers).getString("sex"));
		userInfo.setCity(JSONObject.parseObject(subscribers).getString("city"));
		userInfo.setCountry(JSONObject.parseObject(subscribers).getString("country"));
		userInfo.setProvince(JSONObject.parseObject(subscribers).getString("province"));
		userInfo.setCountry(JSONObject.parseObject(subscribers).getString("country"));
		userInfo.setCountry(JSONObject.parseObject(subscribers).getString("language"));
		
		return userInfo;
	}
}
