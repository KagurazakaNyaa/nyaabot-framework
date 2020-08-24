package com.kagurazakanyaa.nyaabot.api.model;

import lombok.Data;

/**
 * 消息类
 * 
 * @author KagurazakaNyaa <i@kagurazakanyaa.com>
 *
 */
@Data
public abstract class Message<T> {

	/**
	 * 构造函数
	 * 
	 * @param source 来源频道
	 * @param data   消息内容
	 */
	public Message(Channel source, T data) {
		this.source = source;
		this.data = data;
	}

	/**
	 * 消息的来源频道
	 */
	private final Channel source;

	/**
	 * 消息内容
	 */
	private final T data;
}
