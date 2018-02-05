package com.example.demo.ws.service;

import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.ws.domain.CompanyCustomer;
import com.example.demo.ws.jpa.repository.CrmJpaRepository;

@Service("CrmJpaService")
public class CrmJpaService {
	

    @Autowired
    private CrmJpaRepository crmJpaRepository;
	
	public CrmJpaService(CrmJpaRepository crmJpaRepository) {
	
		this.crmJpaRepository = crmJpaRepository;
	}
	
	@Transactional(readOnly = true)
	public  Stream<CompanyCustomer> findCustomerByIdRequest(String productId)  throws RuntimeException{
	
		return this.crmJpaRepository.findBycompanyProductIdReturnStream( Long.parseLong(productId,10));
	}
    

}
