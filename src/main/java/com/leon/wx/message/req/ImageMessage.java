package com.leon.wx.message.req;

/**
 * ClassName: ImageMessage
 * @Description: 图片消息
 * @author wangang
 * @date 2018-06-01
 */
public class ImageMessage extends BaseMessage {
    // 图片链接
    private String PicUrl;

    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }
}