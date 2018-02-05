package com.example.demo.ws.service;

import org.example.crm.Customer;
import org.springframework.stereotype.Service;

import com.example.demo.ws.repository.CrmRepository;

@Service("crmService")
public class CrmService {
	private CrmRepository crmRepository;
	
	public CrmService(CrmRepository crmRepository) {
	
		this.crmRepository = crmRepository;
	}

	public Customer findCustomerByIdRequest(String id) {
		return this.crmRepository.findCustomerByIdRequest(id);
	}

}
