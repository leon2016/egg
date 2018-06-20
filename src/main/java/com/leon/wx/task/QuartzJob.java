package com.leon.wx.task;

import org.apache.log4j.Logger;

import com.leon.wx.util.WeChatTask;

public class QuartzJob {
	private static Logger logger = Logger.getLogger(QuartzJob.class);

	/**
	 * @Description: 任务执行获取 token
	 * @param
	 */
	public static void workForToken() {
		logger.info("开始执行定时任务workForToken...");
		try {
			WeChatTask.getToken_getTicket();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("定时任务workForToken执行完毕。");
	}

}