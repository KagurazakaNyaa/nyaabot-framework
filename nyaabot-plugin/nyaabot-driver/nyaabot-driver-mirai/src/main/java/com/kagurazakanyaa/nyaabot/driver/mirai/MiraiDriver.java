package com.kagurazakanyaa.nyaabot.driver.mirai;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import com.kagurazakanyaa.nyaabot.api.IDriver;
import com.kagurazakanyaa.nyaabot.api.model.Configuration;
import com.kagurazakanyaa.nyaabot.common.JsonUtil;
import com.kagurazakanyaa.nyaabot.driver.mirai.model.MiraiChannel;
import com.kagurazakanyaa.nyaabot.driver.mirai.model.MiraiPluginConfiguration;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.mamoe.mirai.Bot;
import net.mamoe.mirai.BotFactoryJvm;
import net.mamoe.mirai.contact.Group;
import net.mamoe.mirai.utils.BotConfiguration;

/**
 * @author KagurazakaNyaa <i@kagurazakanyaa.com>
 *
 */
@Slf4j
public class MiraiDriver implements IDriver {

	private Map<String, MiraiChannel> channelMap = new HashMap<>();


	@Getter
	private Bot bot = null;

	BotConfiguration config = null;

	/**
	 * 获取频道
	 * 
	 * @param name 频道名
	 * @return 频道对象
	 */
	@Override
	public MiraiChannel getChannel(String name) {
		if (bot == null) {
			log.error("获取频道失败，请先登录");
			return null;
		}
		if (!channelMap.containsKey(name)) {
			updateChannelList();
		}
		return channelMap.get(name);
	}

	@Override
	public Boolean login(Configuration configuration) {
		try {
			config = new BotConfiguration();
			config.fileBasedDeviceInfo(Path.of(configuration.getConfigPath(), "deviceInfo.json").toString());
			MiraiPluginConfiguration pluginConfig=JsonUtil.fromFile(Path.of(configuration.getConfigPath(), "config.json").toFile(),MiraiPluginConfiguration.class);
			bot = BotFactoryJvm.newBot(pluginConfig.getQqNumber(), pluginConfig.getPassword(), config);
			bot.login();
			updateChannelList();
			return true;
		} catch (Exception e) {
			log.error("登录时发生错误", e);
			return false;
		}
	}

	private void updateChannelList() {
		if (bot == null) {
			log.error("获取频道失败，请先登录");
			return;
		}
		for (Group group : bot.getGroups()) {
			String name = String.valueOf(group.getId());
			if (!channelMap.containsKey(name)) {
				channelMap.put(name, new MiraiChannel(name, this));
			}
		}
	}

}
