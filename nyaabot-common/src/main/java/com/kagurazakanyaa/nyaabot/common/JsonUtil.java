package com.kagurazakanyaa.nyaabot.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author KagurazakaNyaa <i@kagurazakanyaa.com>
 *
 */
public class JsonUtil {

	private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

	public static <T> T fromFile(File file, Class<T> clazz) {

		try {
			return gson.fromJson(new BufferedReader(new FileReader(file)), clazz);
		} catch (Exception e) {
			return null;
		}
	}
}
