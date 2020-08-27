package com.kagurazakanyaa.nyaabot.driver.mirai.model;

import com.kagurazakanyaa.nyaabot.api.model.Channel;
import com.kagurazakanyaa.nyaabot.driver.mirai.MiraiDriver;

import lombok.extern.slf4j.Slf4j;
import net.mamoe.mirai.Bot;
import net.mamoe.mirai.contact.Group;
import net.mamoe.mirai.message.data.Message;

/**
 * QQ消息频道
 * 
 * @author KagurazakaNyaa <i@kagurazakanyaa.com>
 *
 */
@Slf4j
public class MiraiChannel extends Channel {

	private final Bot bot;

	private final Group group;

	/**
	 * 构造函数
	 * 
	 * @param channelName   频道名，此处应为QQ群号
	 * @param channelDriver 驱动实例
	 */
	public MiraiChannel(String channelName, MiraiDriver channelDriver) {
		super(channelName, channelDriver);
		bot = channelDriver.getBot();
		if (bot == null) {
			throw new IllegalStateException("驱动尚未初始化，请使用login方法进行初始化后再获取频道");
		}
		group = bot.getGroup(Long.parseLong(channelName));
	}

	/**
	 * 发送消息到此频道
	 * 
	 * @param message 消息体，应当为字符串或Mirai的消息类型
	 */
	@Override
	public Boolean sendMessage(Object message) {
		try {
			if (message instanceof String) {
				group.sendMessage((String) message);
			} else if (message instanceof Message) {
				group.sendMessage((Message) message);
			} else {
				log.warn("发送消息失败，消息类型未能识别");
				return false;
			}
			return true;
		} catch (Exception e) {
			log.error("发送消息失败", e);
			return false;
		}
	}
	
	void receiveMessage(Message message) {
		updateMessage(message);
	}

}
