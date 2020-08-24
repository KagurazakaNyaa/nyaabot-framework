package com.kagurazakanyaa.nyaabot.driver.mirai.model;

import com.kagurazakanyaa.nyaabot.api.model.Message;

/**
 * @author KagurazakaNyaa <i@kagurazakanyaa.com>
 *
 */
public class MiraiMessage extends Message<String> {
	
	public MiraiMessage(MiraiChannel source,String data){
		super(source,data);
	}

}
