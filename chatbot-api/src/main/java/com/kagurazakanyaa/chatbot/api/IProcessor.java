package com.kagurazakanyaa.chatbot.api;

import java.util.EventListener;

import org.pf4j.ExtensionPoint;

/**
 * 处理接口，捕获特定的消息之后进行相应的操作<br>
 * 处理接口应当提供一个事件监听器，并在接收到特定类型事件后进行处理
 * 
 * @author KagurazakaNyaa <i@kagurazakanyaa.com>
 *
 */
public interface IProcessor extends ExtensionPoint {

	/**
	 * 获取监听器
	 * 
	 * @return 监听器
	 */
	public EventListener getEventListener();

	/***
	 * 检查驱动依赖是否满足
	 * 
	 * @return 驱动依赖满足与否
	 */
	public Boolean checkDriver();
}
