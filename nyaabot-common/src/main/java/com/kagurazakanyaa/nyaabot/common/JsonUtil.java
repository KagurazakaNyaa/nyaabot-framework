package com.kagurazakanyaa.nyaabot.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import lombok.extern.slf4j.Slf4j;

/**
 * @author KagurazakaNyaa
 *
 */
@Slf4j
public class JsonUtil {

	private JsonUtil() {
	}

	private static Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();

	/**
	 * 反序列化，从文件
	 * 
	 * @param <T>   类型
	 * @param file  文件
	 * @param clazz 类
	 * @return 对象
	 */
	public static <T> T fromFile(File file, Class<T> clazz) {
		try {
			return gson.fromJson(new BufferedReader(new FileReader(file)), clazz);
		} catch (Exception e) {
			log.error("反序列化出错", e);
			return null;
		}
	}

	/**
	 * 序列化到文件
	 * 
	 * @param <T>  类型
	 * @param file 文件
	 * @param obj  对象
	 */
	public static <T> void toFile(File file, T obj) {
		try {
			var writer = new FileWriter(file);
			gson.toJson(obj, writer);
		} catch (Exception e) {
			log.error("序列化出错", e);
		}
	}
}
