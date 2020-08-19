package com.kagurazakanyaa.chatbot.api;

import org.pf4j.ExtensionPoint;

/**
 * 驱动接口，所有消息驱动插件应当实现此接口
 * 
 * @author KagurazakaNyaa <i@kagurazakanyaa.com>
 *
 */
public interface IDriver extends ExtensionPoint {

	/**
	 * 载入已保存的配置
	 * 
	 * @param filePath 配置文件路径
	 * @return 是否成功
	 */
	public Boolean loadConfig(String filePath);

	/**
	 * 创建默认配置
	 * 
	 * @param filePath 文件路径
	 * @return 是否成功
	 */
	public Boolean createConfig(String filePath);
}
