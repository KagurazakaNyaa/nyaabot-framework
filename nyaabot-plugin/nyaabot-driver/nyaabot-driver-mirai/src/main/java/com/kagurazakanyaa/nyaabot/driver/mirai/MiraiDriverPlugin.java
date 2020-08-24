package com.kagurazakanyaa.nyaabot.driver.mirai;

import org.pf4j.Plugin;
import org.pf4j.PluginWrapper;

/**
 * Mirai插件生命周期重载
 * @author KagurazakaNyaa <i@kagurazakanyaa.com>
 *
 */
public class MiraiDriverPlugin extends Plugin {

	/**
	 * 插件类构造函数
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
		System.out.println("MiraiDriverPlugin.start()");
	}

	/**
	 * 停止插件
	 */
	@Override
	public void stop() {
		System.out.println("MiraiDriverPlugin.stop()");
	}

	/**
	 * 删除插件
	 */
	@Override
	public void delete() {
		System.out.println("MiraiDriverPlugin.delete()");
	}

}
