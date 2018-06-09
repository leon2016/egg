package com.leon.wx.task;

import com.leon.wx.util.WeChatTask;

public class QuartzJob{
    /**
     * @Description: 任务执行获取 token
     * @param    
     */
    public void workForToken() {
        try {
            WeChatTask timer = new WeChatTask();
            timer.getToken_getTicket();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}