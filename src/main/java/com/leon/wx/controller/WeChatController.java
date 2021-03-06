package com.leon.wx.controller;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.leon.wx.constant.WeChatConstants;
import com.leon.wx.dispatcher.EventDispatcher;
import com.leon.wx.dispatcher.MsgDispatcher;
import com.leon.wx.util.JsSdkConfig;
import com.leon.wx.util.MessageUtil;
import com.leon.wx.util.WechatUtils;

@Controller
@RequestMapping(value = "/wx")
public class WeChatController {
	private static Logger logger = Logger.getLogger(WeChatController.class);

	/**
	 * security get请求-验证签名
	 * 
	 * @param signature
	 * @param timestamp
	 * @param nonce
	 * @param echostr
	 * @return
	 */
	@RequestMapping(value = "/security", method = RequestMethod.GET)
	@ResponseBody
	public String doGet(String signature, String timestamp, String nonce, String echostr) {
		logger.debug("TOKEN=" + WeChatConstants.TOKEN + ",signature=" + signature + ",timesamp" + timestamp + ",nonce="
		        + nonce);
		if (StringUtils.isBlank(signature) || StringUtils.isBlank(timestamp) || StringUtils.isBlank(nonce)
		        || StringUtils.isBlank(echostr)) {
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
	@RequestMapping(value = "/security", method = RequestMethod.POST)
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		logger.debug("消息分发...");
		try {
			Map<String, String> map = MessageUtil.parseXml(request);
			String msgtype = map.get("MsgType");
			String respXML = null;
			if (MessageUtil.REQ_MESSAGE_TYPE_EVENT.equals(msgtype)) {
				respXML = EventDispatcher.processEvent(map); // 进入事件处理
			} else {
				respXML = MsgDispatcher.processMessage(map); // 进入消息处理
			}
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			out.print(respXML);
			out.flush();
			out.close();
		} catch (Exception e) {
			logger.error(e, e);
		}

	}

	/**
	 * @Description: 前端获取微信 JSSDK 的配置参数
	 * @param @param
	 *            response
	 * @param @param
	 *            request
	 * @param @param
	 *            url
	 * @param @throws
	 *            Exception
	 */
	@RequestMapping(value = "/jssdk")
	@ResponseBody
	public ModelMap JSSDK_config(@RequestParam(value = "url", required = true) String url) {
		ModelMap map = new ModelMap();
		try {
			logger.debug(url);
			Map<String, String> jsdkConfigMap = JsSdkConfig.jsSDK_Sign(url);
			map.put("jsdconfig", jsdkConfigMap);
			map.put("status", "success");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			map.put("status", "error");
		}
		return map;
	}

}
