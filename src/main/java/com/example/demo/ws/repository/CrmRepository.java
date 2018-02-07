package com.example.demo.ws.repository;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.example.crm.Customer;
import org.example.crm.Demography;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.example.demo.ws.util.DateFormat;

@Component
public class CrmRepository {
	private static final Map<String, Customer> customers = new HashMap<>();
	private final static Logger log = LoggerFactory.getLogger(CrmRepository.class);

	@PostConstruct
	public void init() throws Exception {
		log.debug("- - - initializing load  CrmRepository bean/ map using @PostConstruct");
		Customer cm = new Customer();
		cm.setEmail("me.you@foo.com");
		cm.setNotes("I Love Jesus");
		cm.setPhone("800-900-8000");
		cm.setDemography(Demography.OTHER);
		cm.setDate(DateFormat.getXMLGregorianCalendarDate(new Date()));
		cm.setCustomerId("20202");// 20202
		cm.setCompanyName("Burger King");
		customers.put("20202", cm);
		log.debug("- - - initializing complete ..");

	}

	@PreDestroy
	public void destroy() throws Exception {
		log.debug("- - - destroying CrmRepository bean using @PreDestroy");
	}

	public Customer findCustomerByIdRequest(String id) {

		Assert.notNull(id, "The customer's id must not be null");
		log.debug("- - - Customer id not found ..");
		return customers.get(id);

	}

}
