package com.leon.wx.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.leon.wx.constant.WeChatConstants;
import com.leon.wx.model.WechatOauth2Token;

/**
 * 网页授权
 * 
 * @author wangang
 *
 */
public class Oauth2TokenUtil {
	private static Logger logger = Logger.getLogger(Oauth2TokenUtil.class);

	/**
	 * 获取网页授权凭证
	 * 
	 * 
	 * @param code
	 * @return WeixinAouth2Token
	 * @throws Exception
	 */
	public static WechatOauth2Token getOauth2AccessToken(String code) throws Exception {
		WechatOauth2Token wat = null;
		Map<String, String> params = new HashMap<String, String>();
		params.put("appid", WeChatConstants.getAPP_ID());
		params.put("secret", WeChatConstants.getAPP_SECRET());
		params.put("code", code);
		params.put("grant_type", "authorization_code");
		// 获取网页授权凭证
		String jsOauth = HttpUtils.sendGet(WeChatConstants.SNS_ACCESS_TOKEN_URL, params);
		JSONObject jsonObject = JSONObject.parseObject(jsOauth);
		if (null != jsonObject) {
			try {
				wat = new WechatOauth2Token();
				wat.setAccessToken(jsonObject.getString("access_token"));
				wat.setExpiresIn(jsonObject.getIntValue("expires_in"));
				wat.setRefreshToken(jsonObject.getString("refresh_token"));
				wat.setOpenId(jsonObject.getString("openid"));
				wat.setScope(jsonObject.getString("scope"));
			} catch (Exception e) {
				wat = null;
				int errorCode = jsonObject.getIntValue("errcode");
				String errorMsg = jsonObject.getString("errmsg");
				logger.error("获取网页授权凭证失败 errcode:" + errorCode + " errmsg:" + errorMsg);
			}
		}
		return wat;
	}

}
