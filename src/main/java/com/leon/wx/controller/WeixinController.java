package com.leon.wx.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.leon.wx.constant.WeChatConstants;
import com.leon.wx.util.MessageUtil;
import com.leon.wx.util.WechatUtils;

@Controller
@RequestMapping(value = "/wx")
public class WeixinController {
	private static Logger logger = Logger.getLogger(WeixinController.class);

	/**
	 * security get请求-验证签名
	 * 
	 * @param signature
	 * @param timestamp
	 * @param nonce
	 * @param echostr
	 * @return
	 */
	@RequestMapping(value = "security", method = RequestMethod.GET)
	@ResponseBody
	public String doGet(String signature, String timestamp, String nonce, String echostr) {
		logger.debug("TOKEN=" + WeChatConstants.TOKEN + ",signature=" + signature + ",timesamp" + timestamp + ",nonce=" + nonce);
		if (StringUtils.isBlank(signature)||StringUtils.isBlank(timestamp)||StringUtils.isBlank(nonce)||StringUtils.isBlank(echostr)) {
			logger.info("参数为空！");
			return "";
		}
		String result = WechatUtils.checkSignature(signature, timestamp, nonce) ? echostr : "";
		logger.debug("echostr=" + result);
		return result;
	}

	/**
	 * security post请求-用于接收微信服务端消息
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "security", method = RequestMethod.POST)
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		logger.debug("开始接收用户消息...");
		try {
			Map<String, String> map = MessageUtil.parseXml(request);
			System.out.println("=============================" + map.get("Content"));
		} catch (Exception e) {
			logger.error(e, e);
		}
	}
}