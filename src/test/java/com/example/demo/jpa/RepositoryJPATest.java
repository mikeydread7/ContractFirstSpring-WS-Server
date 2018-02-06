package com.example.demo.jpa;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import javax.annotation.Resource;

import org.example.crm.Customer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.ws.domain.CompanyCustomer;
import com.example.demo.ws.jpa.repository.CrmJpaRepository;
import com.example.demo.ws.service.CrmJpaService;

@SpringBootTest
@Transactional
@ActiveProfiles("h2")
@RunWith(SpringRunner.class)
public class RepositoryJPATest {

	@Resource
	private CrmJpaService crmJpaService;

	@Resource
	private CrmJpaRepository crmJpaRepository;

	@Before
	public void setUp() throws Exception {
		crmJpaService = new CrmJpaService(crmJpaRepository);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCrmJpaServiceOK() {

		String[] array = { "1", "2" };
		for (String a : array) {
			Customer compCust = crmJpaService.findCustomerByIdRequest(a);
			assertThat(compCust.getCustomerName().equals(a));
		}
	}

	@Test
	public void testCrmJpaServiceFail() {

		String[] array = { "11", "12", "21202" };
		for (String a : array) {
			Optional<CompanyCustomer> compCust = crmJpaRepository
					.findByCompanyProductIdReturnStream(Long.valueOf(a, 10)).findAny();
			assertThat(compCust.isPresent()).isFalse();

		}
	}

}
