package com.example.demo.ws.util;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import javax.xml.datatype.XMLGregorianCalendar;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateFormatTest {
	private static final Logger LOG = LoggerFactory.getLogger(DateFormatTest.class);

	@Test
	public void testXMLGregorianCalendarDate() {

		Date dateIn = new Date();
		XMLGregorianCalendar xMLGregorianCalendarDate = DateFormat.getXMLGregorianCalendarDate(dateIn);
		LOG.debug(" {} ", xMLGregorianCalendarDate);
		assertTrue(xMLGregorianCalendarDate.getDay() > -1);

	}

}
