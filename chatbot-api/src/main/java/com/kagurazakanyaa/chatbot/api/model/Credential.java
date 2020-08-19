package com.kagurazakanyaa.chatbot.api.model;

import lombok.Data;

/**
 * 凭据类，用于登录指定的频道
 * 
 * @author KagurazakaNyaa <i@kagurazakanyaa.com>
 *
 */
@Data
public abstract class Credential {

	/**
	 * 用户名
	 */
	private final String user;

	/**
	 * 密码
	 */
	private final String password;

	/**
	 * 登录令牌
	 */
	private final String token;

}
