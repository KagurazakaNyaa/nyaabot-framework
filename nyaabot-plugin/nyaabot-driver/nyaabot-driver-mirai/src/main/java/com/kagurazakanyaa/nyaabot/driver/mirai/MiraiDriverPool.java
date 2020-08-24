package com.kagurazakanyaa.nyaabot.driver.mirai;

/**
 * 驱动池，维护一个可复用的驱动资源池
 * 
 * @author KagurazakaNyaa <i@kagurazakanyaa.com>
 *
 */
public class MiraiDriverPool {

	/**
	 * 单例模式
	 */
	private static MiraiDriverPool instance = null;

	/**
	 * 私有构造函数
	 */
	private MiraiDriverPool() {
	}

	/**
	 * 获取单例
	 * 
	 * @return 单例模式实体
	 */
	public static MiraiDriverPool getInstance() {
		if (instance == null) {
			instance = new MiraiDriverPool();
		}
		return instance;
	}

	/**
	 * 获取新的驱动实例
	 * 
	 * @return 驱动实例
	 */
	public MiraiDriver getDriver() {
		return new MiraiDriver();
	}
}
