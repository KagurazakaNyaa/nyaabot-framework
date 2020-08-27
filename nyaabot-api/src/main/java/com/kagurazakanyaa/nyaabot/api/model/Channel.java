package com.kagurazakanyaa.nyaabot.api.model;

import java.util.HashSet;
import java.util.Set;

import com.kagurazakanyaa.nyaabot.api.IDriver;
import com.kagurazakanyaa.nyaabot.api.IMessageListener;

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
		name = channelName;
		driver = channelDriver;
		messageListenerSet = new HashSet<>();
	}

	/**
	 * 消息监听器列表
	 */
	private Set<IMessageListener> messageListenerSet;

	/**
	 * 频道驱动
	 */
	private final IDriver driver;

	/**
	 * 频道名称
	 */
	private final String name;

	/**
	 * 发送消息
	 * 
	 * @param message 消息
	 * @return 是否成功
	 */
	public abstract Boolean sendMessage(Object message);

	/**
	 * 添加监听器
	 * 
	 * @param listener 监听器
	 */
	public final void addObserver(IMessageListener listener) {
		messageListenerSet.add(listener);
	}

	/**
	 * 获取消息时调用此方法通知监听器
	 * 
	 * @param message 消息
	 */
	protected final void updateMessage(Object message) {
		for (IMessageListener listener : messageListenerSet) {
			listener.update(new MessageEventObject(this), message);
		}
	}

}
