package com.kagurazakanyaa.nyaabot.driver.mirai;

import java.util.HashMap;
import java.util.Map;

import com.kagurazakanyaa.nyaabot.api.IDriver;
import com.kagurazakanyaa.nyaabot.api.model.Credential;
import com.kagurazakanyaa.nyaabot.driver.mirai.model.MiraiChannel;

/**
 * @author KagurazakaNyaa <i@kagurazakanyaa.com>
 *
 */
public class MiraiDriver implements IDriver {

	private Map<String, MiraiChannel> channelMap = new HashMap<>();

	/**
	 * 获取频道
	 * 
	 * @param name 频道名
	 * @return 频道对象
	 */
	@Override
	public MiraiChannel getChannel(String name) {
		if (!channelMap.containsKey(name)) {
			channelMap.put(name, new MiraiChannel(name, this));
		}
		return channelMap.get(name);
	}

	@Override
	public Boolean login(Credential channelCredential) {
		// TODO Auto-generated method stub
		return null;
	}

}
