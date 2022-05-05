package com.services.api.ffmanager.utils;

import java.text.ParseException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Utilities {

	public static LocalDateTime getDateTimeFromString(String dateTimeString) throws ParseException {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime dateTime = LocalDateTime.parse(dateTimeString, formatter);
		return dateTime;  
	}
	
	public static Date getNowDate() {
		return new Date(); 
	}
	
	public static LocalDateTime getNowLocalDateTime() {
		return LocalDateTime.now();
	}
	
	public static LocalDateTime getLocalDateTimeFromString(String localDateTimeString) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
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
	
	public static List<Integer> getHoras(LocalDateTime ldt1, LocalDateTime ldt2){
		List<Integer> listaHoras = new ArrayList<Integer>();
		
		long hours = ldt1.until( ldt2, ChronoUnit.HOURS );

		for (int i = 0; i < hours; i++) {
			ldt1.plusHours(i);
			listaHoras.add(ldt1.getHour());
		}
		
		
		return listaHoras;
	}
	

//	
//	public static List<Integer> getHorasFromDates(DateTimeFormatter  start, Date end){
//		List<Integer> listaHoras = new ArrayList<Integer>();
//		Period p = new Period(start, end);
//		int hours = p.getHours();
//		int minutes = p.getMinutes();
//
//		
//		return listaHoras;
//	}
	
	
	public static Date getDateFromLocalDateTime(LocalDateTime ldt) {
		Instant instant = ldt.atZone(ZoneId.of("AGT")).toInstant();
		Date date = Date.from(instant);
		return date;
	}
}
