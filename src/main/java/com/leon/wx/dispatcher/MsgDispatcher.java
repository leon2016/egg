package com.leon.wx.dispatcher;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.leon.wx.message.resp.Article;
import com.leon.wx.message.resp.NewsMessage;
import com.leon.wx.message.resp.TextRespMessage;
import com.leon.wx.util.MessageUtil;

/**
 * ClassName: MsgDispatcher
 * 
 * @Description: 消息业务处理分发器
 * @author wangang
 * @date 2018-06-01
 */
public class MsgDispatcher {

	private static Logger logger = Logger.getLogger(MsgDispatcher.class);

	public static String processMessage(Map<String, String> map) {

		String msgType = map.get("MsgType");// 消息类型
		String openid = map.get("FromUserName"); // 用户 openid
		String mpid = map.get("ToUserName"); // 公众号原始 ID
		logger.debug("msgType="+msgType+", openId=" + openid + ", mpId=" + mpid);

		if (MessageUtil.REQ_MESSAGE_TYPE_TEXT.equals(msgType)) { // 文本消息
			logger.debug("==============这是文本消息！");

			// 普通文本消息
			TextRespMessage txtmsg = new TextRespMessage();
			txtmsg.setToUserName(openid);
			txtmsg.setFromUserName(mpid);
			txtmsg.setCreateTime(new Date().getTime());
			txtmsg.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
			txtmsg.setContent("你好，这里是万刚个人账号！");
			String result = MessageUtil.messageToXml(txtmsg);
			logger.debug("xml=" + result);
			return result;

		} else if (MessageUtil.REQ_MESSAGE_TYPE_VOICE.equals(msgType)) { // 语音消息
			logger.debug("==============这是语音消息！");
			String mediaId = map.get("MediaId");
			String format = map.get("Format");
			String recognition = map.get("Recognition");
			logger.debug("语音内容："+recognition);
			// TODO 处理语言请求
		} else if (MessageUtil.REQ_MESSAGE_TYPE_IMAGE.equals(msgType)) { // 图片消息
			logger.debug("==============这是图片消息！");

			// 对图文消息
			NewsMessage newmsg = new NewsMessage();
			newmsg.setToUserName(openid);
			newmsg.setFromUserName(mpid);
			newmsg.setCreateTime(new Date().getTime());
			newmsg.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);

			if (MessageUtil.REQ_MESSAGE_TYPE_IMAGE.equals(msgType)) { // 图片消息
				logger.debug("==============这是图片消息！");
				Article article = new Article();
				article.setDescription("这是图文消息 1"); // 图文消息的描述
				article.setPicUrl("http://www.xinhuanet.com/photo/2018-06/07/1122953979_15283768500761n.jpg"); // 图文消息图片地址
				article.setTitle("图文消息 1-标题"); // 图文消息标题
				article.setUrl("https://www.baidu.com"); // 图文 url 链接

				Article article2 = new Article();
				article2.setDescription("这是图文消息 2"); // 图文消息的描述
				article2.setPicUrl("http://www.ssme.gov.cn/images/logo_cs_cloud.png"); // 图文消息图片地址
				article2.setTitle("图文消息 2-企服云欢迎你"); // 图文消息标题
				article2.setUrl("http://www.ssme.gov.cn"); // 图文 url 链接
				
				Article article3 = new Article();
				article3.setDescription("这是图文消息 3"); // 图文消息的描述
				article3.setPicUrl("http://www.ssme.gov.cn/images/logo_cs_cloud.png"); // 图文消息图片地址
				article3.setTitle("图文消息 3-企服云欢迎你"); // 图文消息标题
				article3.setUrl("http://www.ssme.gov.cn"); // 图文 url 链接
				
				List<Article> list = new ArrayList<Article>();
				list.add(article);
				list.add(article2);
				list.add(article3);
				newmsg.setArticleCount(list.size());
				newmsg.setArticles(list);
				String result = MessageUtil.messageToXml(newmsg);
				logger.debug("xml=" + result);
				return result;
			}

		} else if (MessageUtil.REQ_MESSAGE_TYPE_LINK.equals(msgType)) { // 链接消息
			logger.debug("==============这是链接消息！");
		} else if (MessageUtil.REQ_MESSAGE_TYPE_LOCATION.equals(msgType)) { // 位置消息
			logger.debug("==============这是位置消息！");
		} else if (MessageUtil.REQ_MESSAGE_TYPE_VIDEO.equals(msgType)) { // 视频消息
			logger.debug("==============这是视频消息！");
		} else {
			logger.debug("==============其他消息，MsgType=" + map.get("MsgType"));
		}

		return null;
	}
}