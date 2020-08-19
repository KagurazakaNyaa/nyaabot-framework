package com.kagurazakanyaa.chatbot;

import java.io.File;
import java.io.FilenameFilter;

import org.pf4j.JarPluginManager;
import org.pf4j.PluginManager;
import com.kagurazakanyaa.chatbot.api.*;

/**
 * 启动类
 * 
 * @author KagurazakaNyaa <i@kagurazakanyaa.com>
 *
 */
public class ChatBotApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PluginManager pluginManager = new JarPluginManager();

		File pluginFolder = new File("./plugins");

		for (File plugin : pluginFolder.listFiles(new PluginFilter())) {
			pluginManager.loadPlugin(plugin.toPath());
		}

		pluginManager.startPlugins();

		for (IDriver driver : pluginManager.getExtensions(IDriver.class)) {
			driver.init();
		}

	}

	static class PluginFilter implements FilenameFilter {
		public boolean accept(File dir, String name) {
			return name.endsWith(".jar");
		}
	}

}
