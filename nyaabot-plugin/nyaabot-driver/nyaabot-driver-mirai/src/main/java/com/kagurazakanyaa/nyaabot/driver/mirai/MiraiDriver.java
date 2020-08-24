package com.kagurazakanyaa.nyaabot.driver.mirai;

import com.kagurazakanyaa.nyaabot.api.IDriver;
import com.kagurazakanyaa.nyaabot.api.model.Credential;
import com.kagurazakanyaa.nyaabot.driver.mirai.model.MiraiChannel;

/**
 * @author KagurazakaNyaa <i@kagurazakanyaa.com>
 *
 */
public class MiraiDriver implements IDriver {

	/**
	 * 获取频道
	 * 
	 * @param name 频道名
	 * @return 频道对象
	 */
	@Override
	public MiraiChannel getChannel(String name) {
		return new MiraiChannel(name, this);
	}

	/**
	 * 获取频道
	 * 
	 * @param name              频道名
	 * @param channelCredential 登录凭据
	 * @return 频道对象
	 */
	@Override
	public MiraiChannel getChannel(String name, Credential channelCredential) {
		return new MiraiChannel(name, this, channelCredential);
	}

}
