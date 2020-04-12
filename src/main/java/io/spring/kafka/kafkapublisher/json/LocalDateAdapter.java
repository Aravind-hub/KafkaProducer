package io.spring.kafka.kafkapublisher.json;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.xml.bind.annotation.adapters.XmlAdapter;



public class LocalDateAdapter extends XmlAdapter<String, LocalDate>{

	@Override
	public LocalDate unmarshal(String string) throws Exception {
		// TODO Auto-generated method stub
		return convert(string, DateTimeFormatter.ISO_LOCAL_DATE);
	}

	@Override
	public String marshal(LocalDate date) throws Exception {
		// TODO Auto-generated method stub
		return convert(date, DateTimeFormatter.ISO_LOCAL_DATE);
	}
	
	public static LocalDate convert(final String dateInput, DateTimeFormatter datePattern) {
		if(null!=dateInput) {
			try {
				return LocalDate.parse(dateInput, datePattern);
			}
			catch(DateTimeException ex) {}
		}
		return null;
	}
	
	public static String convert(final LocalDate dateInput, DateTimeFormatter datePattern) {
		if(null!=dateInput) {
			try {
				return dateInput.format(datePattern);
			}
			catch(DateTimeException ex) {}
		}
		return null;
	}

}
