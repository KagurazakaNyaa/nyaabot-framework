package com.kagurazakanyaa.nyaabot.api;

import java.util.EventListener;

import com.kagurazakanyaa.nyaabot.api.model.MessageEventObject;

/**
 * 消息事件监听接口
 * 
 * @author KagurazakaNyaa <i@kagurazakanyaa.com>
 *
 */
public interface IMessageListener extends EventListener {

	public void update(MessageEventObject o, Object arg);
}
