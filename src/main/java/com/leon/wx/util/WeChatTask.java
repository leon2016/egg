package com.leon.wx.util;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.leon.wx.constant.WeChatConstants;


/**
 * ClassName: WeChatTask
 * @Description: 微信两小时定时任务体
 */
public class WeChatTask {
    /**
     * @Description: 任务执行体
     * @param @throws Exception
     */
    public void getToken_getTicket() throws Exception {
        Map<String, String> params = new HashMap<String, String>();
        params.put("grant_type", "client_credential");
        params.put("appid", WeChatConstants.getAPP_ID());
        params.put("secret", WeChatConstants.getAPP_SECRET());
        String jstoken = HttpUtils.sendGet(
                WeChatConstants.getACCESS_TOKEN_URL(), params);
        String access_token = JSONObject.parseObject(jstoken).getString(
                "access_token"); // 获取到 token 并赋值保存
        WeChatConstants.wxMap.put("access_token", access_token);
                System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+"token 为=============================="+access_token);
    }

}