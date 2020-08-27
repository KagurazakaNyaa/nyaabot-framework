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
		retriveMessageThread = new Thread(new Runnable() {
			public void run() {
				retriveMessage();
			}
		});
		retriveMessageThread.start();
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
	 * 消息获取线程，应当调用{@link #retriveMessage()}方法并将其设置为后台线程
	 */
	private final Thread retriveMessageThread;

	/**
	 * 发送消息
	 * 
	 * @param message 消息
	 * @return 是否成功
	 */
	public abstract Boolean sendMessage(Message<?> message);

	/**
	 * 获取消息，应当在获取后调用{@link #updateMessage(Message)}方法将消息下发到监听器
	 */
	protected abstract void retriveMessage();

	/**
	 * 添加监听器
	 * 
	 * @param listener 监听器
	 */
	public void addObserver(IMessageListener listener) {
		messageListenerSet.add(listener);
	}

	/**
	 * 获取消息时调用此方法通知监听器
	 * 
	 * @param message 消息
	 */
	protected void updateMessage(Message<?> message) {
		MessageEventObject messageEvent = new MessageEventObject(this);
		for (IMessageListener listener : messageListenerSet) {
			listener.update(messageEvent, message);
		}
	}

}
