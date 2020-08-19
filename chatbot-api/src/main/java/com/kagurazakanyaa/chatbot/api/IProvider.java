package com.kagurazakanyaa.chatbot.api;

import java.util.EventListener;

import org.pf4j.ExtensionPoint;

/**
 * 提供者接口，负责从驱动获取消息和分发消息<br>
 * 提供者应当实现一个消息循环，从驱动获取特定类型的消息并触发特定的事件
 * 
 * @author KagurazakaNyaa <i@kagurazakanyaa.com>
 *
 */
public interface IProvider extends ExtensionPoint {

	/**
	 * 注册事件监听器
	 * 
	 * @param listener 监听器
	 */
	public void addListener(EventListener listener);
}
