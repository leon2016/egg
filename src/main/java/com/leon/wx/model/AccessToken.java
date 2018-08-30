package com.leon.wx.model;

/**
 * access_token
 * 
 * @see https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140183
 * @author wangang
 * @date 2018-06-01
 *
 */
public class AccessToken {
	private String AccessToken;// 获取到的凭证
	private int ExpiresIn;// 凭证有效时间，单位：秒

	public String getAccessToken() {
		return AccessToken;
	}

	public void setAccessToken(String accessToken) {
		AccessToken = accessToken;
	}

	public int getExpiresIn() {
		return ExpiresIn;
	}

	public void setExpiresIn(int expiresIn) {
		ExpiresIn = expiresIn;
	}

}
