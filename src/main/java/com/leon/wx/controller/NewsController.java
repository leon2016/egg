package com.leon.wx.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.leon.wx.bo.NewsInfo;
import com.leon.wx.constant.GlobalConstant;
import com.leon.wx.constant.WeChatConstants;
import com.leon.wx.model.WechatOauth2Token;
import com.leon.wx.model.WxUserInfo;
import com.leon.wx.service.INewsInfoService;
import com.leon.wx.util.MessageUtil;
import com.leon.wx.util.Oauth2TokenUtil;
import com.leon.wx.util.WxUserInfoUtils;

/**
 * 信息发布-活动、招聘、公告等
 * 
 * @author leon
 *
 */
@Controller
@RequestMapping(value = "/wx/news/")
public class NewsController {
	private static Logger logger = Logger.getLogger(NewsController.class);
	@Autowired
	private INewsInfoService newsInfoService;

	@RequestMapping(value = "/toNewsEdit")
	public String toNewsEdit(HttpServletRequest request) throws Exception {
		String code = request.getParameter("code");
		logger.debug("code=" + code);
		// 用户同意授权
		if (!"authdeny".equals(code)) {
			WechatOauth2Token wechatOauth2Token = Oauth2TokenUtil.getOauth2AccessToken(code);
			String openid = wechatOauth2Token.getOpenId();
			WxUserInfo userInfo = WxUserInfoUtils.getUserInfoByOpenid(openid);
			request.setAttribute("openid", openid);
			request.setAttribute("userInfo", userInfo);
		}
		return "wx/news/news_edit";
	}

	@RequestMapping(value = "/addNews", method = RequestMethod.POST)
	public String addNews(HttpServletRequest request, NewsInfo newsInfo) throws Exception {

		Date nowDate = new Date();
		if (StringUtils.isBlank(newsInfo.getId())) {
			newsInfo.setCreateTime(nowDate);
		}
		newsInfo.setModifyTime(nowDate);
		newsInfo.setValid(GlobalConstant.YES_VALUE);
		newsInfoService.add(newsInfo);

		return "wx/news/news_list";
	}
}