package com.kagurazakanyaa.nyaabot;

import java.io.File;
import java.io.FilenameFilter;

import org.pf4j.JarPluginManager;
import org.pf4j.PluginManager;

import lombok.extern.slf4j.Slf4j;

/**
 * 启动类
 * 
 * @author KagurazakaNyaa <i@kagurazakanyaa.com>
 *
 */
@Slf4j
public class NyaaBotApplication {

	private NyaaBotApplication() {
	}

	private static File pluginFolder = new File("./plugins");
	private static PluginManager pluginManager = new JarPluginManager();

	/**
	 * 入口函数
	 * 
	 * @param args 传入参数，应当有0或1个，<code>args[0]</code>应当为插件的加载路径
	 */
	public static void main(String[] args) {

		if (args.length > 0) {
			try {
				pluginFolder = new File(args[0]);
				if (!pluginFolder.exists()) {
					log.warn("传入的参数不正确，插件文件夹未找到");
					return;
				}
			} catch (Exception ex) {
				ex.printStackTrace();
				return;
			}
		}

		for (File plugin : pluginFolder.listFiles(new PluginFilter())) {
			pluginManager.loadPlugin(plugin.toPath());
		}

		pluginManager.startPlugins();

	}

	static class PluginFilter implements FilenameFilter {
		public boolean accept(File dir, String name) {
			return name.endsWith(".jar") && dir.exists();
		}
	}

}
