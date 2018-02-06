package com.example.demo.ws.service;

import java.util.Optional;

import org.example.crm.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.ws.domain.CompanyCustomer;
import com.example.demo.ws.jpa.repository.CrmJpaRepository;
import com.example.demo.ws.util.DateFormat;

@Service("CrmJpaService")
public class CrmJpaService {

	@Autowired
	private CrmJpaRepository crmJpaRepository;

	public CrmJpaService(CrmJpaRepository crmJpaRepository) {

		this.crmJpaRepository = crmJpaRepository;
	}

	@Transactional(readOnly = true)
	public Customer findCustomerByIdRequest(String productId) throws RuntimeException {

		Optional<CompanyCustomer> compCust = this.crmJpaRepository
				.findByCompanyProductIdReturnStream(Long.parseLong(productId, 10)).findAny();
		Customer outgoing;
		if (compCust.isPresent()) {
			outgoing = new Customer();
			outgoing.setCompanyProductId(compCust.get().getCompanyProductId());
			outgoing.setCompanyName(compCust.get().getCompanyName());
			outgoing.setCustomerName(compCust.get().getCutomerName());
			outgoing.setDemography(org.example.crm.Demography.valueOf(compCust.get().getDemography()));
			outgoing.setNotes(compCust.get().getNotes());
			outgoing.setPhone(compCust.get().getPhone());
			outgoing.setDate(DateFormat.getXMLGregorianCalendarDate(compCust.get().getDate()));
			outgoing.setCustomerId(compCust.get().getId().toString());
		} else {
			outgoing = new Customer();

		}
		return outgoing;
	}

}
