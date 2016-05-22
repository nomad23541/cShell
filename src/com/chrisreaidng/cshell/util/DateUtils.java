package com.chrisreaidng.cshell.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Date utils, get current date, time
 */
public class DateUtils {
	
	/**
	 * Get the current date
	 * @return
	 */
	public static String getDate() {
		DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		return format.format(date);
	}
	
	/**
	 * Get the current time
	 * @return
	 */
	public static String getTime() {
		DateFormat format = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date();
		return format.format(date);
	}

}
