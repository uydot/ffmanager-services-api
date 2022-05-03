package com.services.api.ffmanager.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Utilities {

	public static Date getDateTimeFromString(String dateTime) throws ParseException {
		SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		return formatter.parse(dateTime);  
	}
	
	public static Date getNowDate() {
		return new Date(); 
	}
	
	public static LocalDateTime getNowLocalDateTime() {
		return LocalDateTime.now();
	}
	
	public static LocalDateTime getLocalDateTimeFromString(String localDateTimeString) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime localDateTime = LocalDateTime.parse(localDateTimeString, formatter);
		return localDateTime;
	}
	
}
