package com.kagurazakanyaa.nyaabot.driver.mirai.model;

import lombok.Data;

/**
 * @author KagurazakaNyaa <i@kagurazakanyaa.com>
 *
 */
@Data
public class MiraiPluginConfiguration {

	/**
	 * QQ号
	 */
	private long qqNumber;

	/**
	 * 密码
	 */
	private String password;
}
