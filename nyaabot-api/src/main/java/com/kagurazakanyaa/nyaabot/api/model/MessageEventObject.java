package com.kagurazakanyaa.nyaabot.api.model;

import java.util.EventObject;

/**
 * 消息事件对象
 * 
 * @author KagurazakaNyaa <i@kagurazakanyaa.com>
 *
 */
public class MessageEventObject extends EventObject {

	/**
	 * 自动生成序列化ID
	 */
	private static final long serialVersionUID = -207182490360106458L;

	/**
	 * 构造函数
	 * 
	 * @param source 消息源
	 */
	public MessageEventObject(Object source) {
		super(source);
	}

	/**
	 * 构造函数
	 * 
	 * @param channel 频道（作为消息源）
	 */
	public MessageEventObject(Channel channel) {
		super(channel);
	}

	/**
	 * 获取频道
	 * 
	 * @return 频道
	 */
	public Channel getChannel() {
		return (Channel) super.getSource();
	}

}
