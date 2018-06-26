package com.leon.wx.dispatcher;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.leon.wx.constant.WeChatConstants;
import com.leon.wx.message.resp.Article;
import com.leon.wx.message.resp.NewsMessage;
import com.leon.wx.model.WxUserInfo;
import com.leon.wx.util.MessageUtil;
import com.leon.wx.util.WxUserInfoUtils;

/**
 * ClassName: EventDispatcher
 * 
 * @Description: 事件消息业务分发器
 * @author wangang
 * @date 2018-06-01
 */
public class EventDispatcher {

	private static Logger logger = Logger.getLogger(EventDispatcher.class);

	public static String processEvent(Map<String, String> map) {
		String openid = map.get("FromUserName"); // 用户 openid
		String mpid = map.get("ToUserName"); // 公众号原始 ID
		logger.debug("openId=" + openid + ", mpId=" + mpid);

		if (map.get("Event").equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) { // 关注事件
			logger.debug("==============这是关注事件！");
			// 测试
			NewsMessage newmsg = new NewsMessage();
			newmsg.setToUserName(openid);
			newmsg.setFromUserName(mpid);
			newmsg.setCreateTime(new Date().getTime());
			newmsg.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
			try {
				WxUserInfo userinfo = WxUserInfoUtils.getUserInfoByOpenid(openid);
				Article article = new Article();
				article.setDescription("大佬们说，我们应该有一个APP来实现校友们资源共享，互助实现梦想。于是，利用三天工作之余，码出了雏形。欢迎来到上海校友会APP-测试版！地基已经打牢，房型功能就靠大家了，时间有限，只做最有价值的东西，如有建议或bug，请加微信girl5201314z告知，期待你的加入！（注：由于目前是以个人计算机作为服务器，上班下班时段偶尔会无法响应，因为没网..囧。）"); // 图文消息的描述
				article.setPicUrl(userinfo.getHeadimgurl()); // 图文消息图片地址
				article.setTitle("尊敬的：" + userinfo.getNickname() + ",你好！"); // 图文消息标题
				article.setUrl("https://www.baidu.com"); // 图文 url 链接
				List<Article> list = new ArrayList<Article>();
				list.add(article); // 这里发送的是单图文，如果需要发送多图文则在这里 list 中加入多个 Article 即可！
				newmsg.setArticleCount(list.size());
				newmsg.setArticles(list);
			} catch (Exception e) {
				logger.debug(e.getMessage(), e);
			}

			return MessageUtil.newsMessageToXml(newmsg);

		} else if (map.get("Event").equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) { // 取消关注事件
			logger.debug("==============这是取消关注事件！");
		} else if (map.get("Event").equals(MessageUtil.EVENT_TYPE_SCAN)) { // 扫描二维码事件
			logger.debug("==============这是扫描二维码事件！");
		} else if (map.get("Event").equals(MessageUtil.EVENT_TYPE_LOCATION)) { // 位置上报事件
			logger.debug("==============这是位置上报事件！");
		} else if (map.get("Event").equals(MessageUtil.EVENT_TYPE_CLICK)) { // 自定义菜单点击事件
			logger.debug("==============这是自定义菜单点击事件！");
		} else if (map.get("Event").equals(MessageUtil.EVENT_TYPE_VIEW)) { // 自定义菜单 View 事件
			logger.debug("==============这是自定义菜单 View 事件！");
		} else {
			logger.debug("==============其他事件，Event=" + map.get("Event"));
		}

		return null;
	}
}