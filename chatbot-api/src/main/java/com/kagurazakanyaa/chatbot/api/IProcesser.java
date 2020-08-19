package com.kagurazakanyaa.chatbot.api;

import org.pf4j.ExtensionPoint;

/**
 * 处理接口，捕获特定的消息之后进行相应的操作
 * 
 * @author KagurazakaNyaa <i@kagurazakanyaa.com>
 *
 */
public interface IProcesser extends ExtensionPoint {

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

	/***
	 * 检查驱动依赖是否满足
	 * 
	 * @return 驱动依赖满足与否
	 */
	public Boolean checkDriver();
}
