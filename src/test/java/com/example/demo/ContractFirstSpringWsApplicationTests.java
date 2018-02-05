package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.example.crm.GetCustomerByIdRequest;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ClassUtils;
import org.springframework.ws.client.core.WebServiceTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ContractFirstSpringWsApplicationTests {
	private Jaxb2Marshaller marshaller = new Jaxb2Marshaller();

	@LocalServerPort
	private int port = 0;

	@Before
	public void init() throws Exception {
		marshaller.setPackagesToScan(ClassUtils.getPackageName(GetCustomerByIdRequest.class));
		marshaller.afterPropertiesSet();
	}

	@Test
	public void testSendAndReceiveCustomer() {
		WebServiceTemplate ws = new WebServiceTemplate(marshaller);
		GetCustomerByIdRequest request = new GetCustomerByIdRequest();
		request.setId("20202");
		assertThat(ws.marshalSendAndReceive("http://localhost:" + port + "/ws", request)).isNotNull();
	}	
	
	@Test
	public void testSendAndReceiveCompanyCustonerJpa() {
		
		
	}	
	
}
