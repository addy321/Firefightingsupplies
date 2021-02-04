package com.jdbc.tool;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

public class Util {

	/**
	 * 将长时间格式字符串转换为时间 yyyy-MM-dd HH:mm:ss
	 * 
	 * @param strDate
	 * @return
	 */
	public static Date getNow(String strDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		ParsePosition pos = new ParsePosition(0);
		Date strtodate = formatter.parse(strDate, pos);
		return strtodate;
	}

	public static String uniqId() {
		Random random = new Random(); 
		String nanoRandom = System.nanoTime() + "" + random.nextInt(99999);
		int hash = Math.abs(UUID.randomUUID().hashCode());
		int needAdd = 19 - String.valueOf(hash).length() + 1;
		String uid = hash + "" + nanoRandom.substring(needAdd);
		return String.valueOf(uid);
	}
	
}
