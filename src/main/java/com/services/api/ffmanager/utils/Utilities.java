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
	
	/*
	 * Metodo que devuelve:
	 * . 0 si son iguales
	 * . >0 si ldt1 es mayor que ldt2
	 * . <= si ldt1 es menor que ldt2
	 * 
	 */
	public static int compareLocalDateTime(LocalDateTime ldt1, LocalDateTime ldt2) {
		int diff = ldt1.compareTo(ldt2);

		if (diff > 0) {
		  return 1;	//Prints it
		} else if (diff < 0) {
		  return -1;
		}
		return 0;
	}
}
