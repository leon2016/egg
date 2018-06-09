package com.leon.wx.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import com.leon.wx.constant.WeChatConstants;

/**
 * 微信开发者工具
 * 
 * @author leon
 *
 */
public class WechatUtils {

	/**
	 * 检验signature
	 * 
	 * @param signature
	 *            微信签名（结合了token,timestamp,nonce）
	 * @param timestamp
	 *            时间戳
	 * @param nonce
	 *            随机数
	 * @return
	 */
	public static Boolean checkSignature(String signature, String timestamp, String nonce) {
		String[] strs = new String[] { WeChatConstants.TOKEN, timestamp, nonce };
		Arrays.sort(strs);
		StringBuffer content = new StringBuffer();
		for (int i = 0; i < strs.length; i++) {
			content.append(strs[i]);
		}
		// 生成sha1签名
		MessageDigest md = null;
		String tmpStr = null;
		try {
			md = MessageDigest.getInstance("SHA-1");
			byte[] digest = md.digest(content.toString().getBytes());
			tmpStr = byteToHxStr(digest);
			System.out.println("tmpStr=" + tmpStr);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return signature != null ? signature.toUpperCase().equals(tmpStr.toUpperCase()) : false;
	}

	// /**
	// * 获取access_token
	// * access_token_url =
	// "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	// * @param appid 凭证
	// * @param appsecret 密钥
	// * @return
	// */
	// public static AccessToken getAccessToken(String appid, String appsecret) {
	// AccessToken accessToken = null;
	// String requestUrl = ACCESS_TOKEN_URL.replace("APPID",
	// appid).replace("APPSECRET", appsecret);
	// JSONObject jsonObject = httpRequest(requestUrl, "GET", null);
	// if (null != jsonObject) {
	// try {
	// accessToken = new AccessToken();
	// accessToken.setAccessToken(jsonObject.getString("access_token"));
	// accessToken.setExpiresIn(jsonObject.getIntValue("expires_in"));
	// } catch (JSONException e) {
	// accessToken = null;
	// // 获取token失败
	// log.error("获取token失败 errcode:{} errmsg:{}", jsonObject.getInteger("errcode"),
	// jsonObject.getString("errmsg"));
	// }
	// }
	// return accessToken;
	// }
	/**
	 * 子节转16进制字符
	 * 
	 * @param digest
	 * @return
	 */
	public static String byteToHxStr(byte[] digest) {
		StringBuffer hexstr = new StringBuffer();
		String shaHex = "";
		for (int i = 0; i < digest.length; i++) {
			shaHex = Integer.toHexString(digest[i] & 0xFF);
			if (shaHex.length() < 2) {
				hexstr.append(0);
			}
			hexstr.append(shaHex);
		}
		return hexstr.toString();
	}
}
