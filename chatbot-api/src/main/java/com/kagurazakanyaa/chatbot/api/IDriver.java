package com.kagurazakanyaa.chatbot.api;

import org.pf4j.ExtensionPoint;

/**
 * 驱动接口，所有消息驱动插件应当实现此接口<br>
 * 驱动应当被提供者调用并接收和发送消息
 * 
 * @author KagurazakaNyaa <i@kagurazakanyaa.com>
 *
 */
public interface IDriver extends ExtensionPoint {

	/**
	 * 初始化消息驱动
	 */
	public void init();
}
