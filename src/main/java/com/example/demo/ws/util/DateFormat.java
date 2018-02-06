package com.example.demo.ws.util;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class DateFormat {

	public static XMLGregorianCalendar getXMLGregorianCalendarDate(Date dateIn) throws RuntimeException {
		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		gregorianCalendar.setTime(dateIn);
		XMLGregorianCalendar xMLGregorianCalendar = null;
		try {
			xMLGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
		} catch (DatatypeConfigurationException e) {

			throw new RuntimeException(e.getMessage());
		}
		return xMLGregorianCalendar;
	}
}
