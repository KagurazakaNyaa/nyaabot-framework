package com.kagurazakanyaa.nyaabot.api.model;

import lombok.Data;

/**
 * 配置类，用于存储驱动的配置，应当由<code>/app/config/{plugin-id}.json</code>反序列化而来
 * 
 * @author KagurazakaNyaa
 *
 */
@Data
public class Configuration {

	/**
	 * 日志路径，默认值应当是<code>/app/logs/{plugin-id}/</code>
	 */
	private String logPath;
	
	/**
	 * 配置路径，默认值应当是<code>/app/configs/{plugin-id}/</code>
	 */
	private String configPath;

}
