package com.kagurazakanyaa.nyaabot.api;

import org.pf4j.ExtensionPoint;

import com.kagurazakanyaa.nyaabot.api.model.Channel;
import com.kagurazakanyaa.nyaabot.api.model.Credential;

/**
 * 驱动接口，所有消息驱动插件应当实现此接口<br>
 * 驱动应当被提供者调用并接收和发送消息
 * 
 * @author KagurazakaNyaa <i@kagurazakanyaa.com>
 *
 */
public interface IDriver extends ExtensionPoint {

	/**
	 * 获取频道
	 * 
	 * @param name 频道名
	 * @return 频道对象
	 */
	public Channel getChannel(String name);

	/**
	 * 登录
	 * 
	 * @param channelCredential 登录凭据
	 * @return 是否成功
	 */
	public Boolean login(Credential channelCredential);
}
