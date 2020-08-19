package com.kagurazakanyaa.chatbot.api.model;

import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.kagurazakanyaa.chatbot.api.IDriver;

import lombok.Data;

/**
 * 频道类，包含用于发送消息的数据
 * 
 * @author KagurazakaNyaa <i@kagurazakanyaa.com>
 *
 */
@Data
public abstract class Channel {

	/**
	 * 构造函数
	 * 
	 * @param channelName   频道名
	 * @param channelDriver 频道驱动
	 */
	public Channel(String channelName, IDriver channelDriver) {
		this(channelName, channelDriver, null);
	}

	/**
	 * 构造函数
	 * 
	 * @param channelName       频道名
	 * @param channelDriver     频道驱动
	 * @param channelCredential 登录凭据
	 */
	public Channel(String channelName, IDriver channelDriver, Credential channelCredential) {
		messageQueue = new ConcurrentLinkedQueue<Message>();
		name = channelName;
		driver = channelDriver;
		credential = channelCredential;
		id = UUID.randomUUID();
	}

	/**
	 * 消息队列
	 */
	private Queue<Message> messageQueue;

	/**
	 * 登录凭据
	 */
	private Credential credential;

	/**
	 * 频道驱动
	 */
	private final IDriver driver;

	/**
	 * 频道名称
	 */
	private final String name;

	/**
	 * 频道内部唯一ID
	 */
	private final UUID id;

	/**
	 * 发送消息
	 * 
	 * @param message 消息
	 * @return 是否成功
	 */
	public abstract Boolean sendMessage(Message message);

	/**
	 * 登录
	 * 
	 * @param channelCredential 登录凭据
	 * @return 是否成功
	 */
	public abstract Boolean login(Credential channelCredential);
}
