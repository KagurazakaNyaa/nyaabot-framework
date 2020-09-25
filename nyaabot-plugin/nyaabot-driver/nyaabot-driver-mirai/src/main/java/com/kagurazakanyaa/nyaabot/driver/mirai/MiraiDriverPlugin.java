package com.kagurazakanyaa.nyaabot.driver.mirai;

import java.io.File;
import java.nio.file.Path;

import org.pf4j.Plugin;
import org.pf4j.PluginWrapper;

import com.kagurazakanyaa.nyaabot.common.JsonUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * Mirai插件生命周期重载
 * 
 * @author KagurazakaNyaa
 *
 */
@Slf4j
public class MiraiDriverPlugin extends Plugin {

	/**
	 * 插件类构造函数
	 * 
	 * @param wrapper
	 */
	public MiraiDriverPlugin(PluginWrapper wrapper) {
		super(wrapper);
	}

	/**
	 * 启动插件
	 */
	@Override
	public void start() {
		log.info("MiraiDriverPlugin Startted");
	}

	/**
	 * 停止插件
	 */
	@Override
	public void stop() {
		File configFile;
		configFile = Path.of(MiraiDriver.config.getConfigPath(), "config.json").toFile();
		JsonUtil.toFile(configFile, MiraiDriver.pluginConfig);
		log.info("MiraiDriverPlugin Stopped");
	}

	/**
	 * 删除插件
	 */
	@Override
	public void delete() {
		log.info("MiraiDriverPlugin Deleted");
	}

}
