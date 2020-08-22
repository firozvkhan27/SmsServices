package com.sms.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SmsUtil {
	public static Date convertStringDate(String date) {
		try {
			return new SimpleDateFormat("MM/dd/yyyy").parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;

	}

	public static String convertDateToString(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		return formatter.format(date);
	}

}
