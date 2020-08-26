package com.kagurazakanyaa.nyaabot.api.model;

import java.time.LocalDateTime;

import lombok.Data;

/**
 * 消息类
 * 
 * @author KagurazakaNyaa <i@kagurazakanyaa.com>
 *
 */
@Data
public class Message<T> {

	/**
	 * 构造函数
	 * 
	 * @param source 来源频道
	 * @param data   消息内容
	 */
	public Message(Channel source, T data) {
		this.source = source;
		this.data = data;
		this.createTime = LocalDateTime.now();
	}

	/**
	 * 消息的来源频道
	 */
	private final Channel source;

	/**
	 * 消息的创建时间
	 */
	private final LocalDateTime createTime;

	/**
	 * 消息内容
	 */
	private final T data;
}
