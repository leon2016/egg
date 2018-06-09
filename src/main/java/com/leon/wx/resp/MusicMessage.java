package com.leon.wx.resp;

/**
 * ClassName: MusicMessage
 * 
 * @Description: 多媒体消息-音乐消息
 * @author wangang
 * @date 2018-06-01
 */
public class MusicMessage extends BaseRespMessage {
	// 音乐
	private Music Music;

	public Music getMusic() {
		return Music;
	}

	public void setMusic(Music music) {
		Music = music;
	}
}