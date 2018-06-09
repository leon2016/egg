package com.leon.wx.resp;

import java.util.List;

/**
 * ClassName: NewsMessage
 * 
 * @Description: 普通消息-多图文消息体（新闻）
 * @author wangang
 * @date 2018-06-01
 */
public class NewsMessage extends BaseRespMessage {
	// 图文消息个数，限制为 10 条以内
	private int ArticleCount;
	// 多条图文消息信息，默认第一个 item 为大图
	private List<Article> Articles;

	public int getArticleCount() {
		return ArticleCount;
	}

	public void setArticleCount(int articleCount) {
		ArticleCount = articleCount;
	}

	public List<Article> getArticles() {
		return Articles;
	}

	public void setArticles(List<Article> articles) {
		Articles = articles;
	}
}
