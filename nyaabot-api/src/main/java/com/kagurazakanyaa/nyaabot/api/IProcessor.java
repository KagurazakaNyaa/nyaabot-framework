package com.kagurazakanyaa.nyaabot.api;

import org.pf4j.ExtensionPoint;

import com.kagurazakanyaa.nyaabot.api.model.Message;

/**
 * 处理接口，捕获特定的消息之后进行相应的操作<br>
 * 处理接口应当提供一个事件监听器，并在接收到特定类型事件后进行处理
 * 
 * @author KagurazakaNyaa <i@kagurazakanyaa.com>
 *
 */
public interface IProcessor extends ExtensionPoint {

	/**
	 * 处理消息
	 * @param message 消息
	 */
	public void processMessage(Message<?> message);

}
