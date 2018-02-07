package com.example.demo.ws.jpa.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.ws.domain.CompanyCustomer;

/*if we want that our query method is executed asynchronously, 
 * we have to annotate it with the @Async annotation and return a Future<T> object.
 * Here are some examples of query methods that are executed asynchronously:
 */
@Repository
public interface CrmJpaRepository extends CrudRepository<CompanyCustomer, Long> {

	List<CompanyCustomer> findByEmail(String email);

	List<CompanyCustomer> findByDate(Date date);

	@Query("select cc from CompanyCustomer cc where cc.email = :email")
	Stream<CompanyCustomer> findByEmailReturnStream(@Param("email") String email);
	
	@Query("select cc from CompanyCustomer cc where cc.companyProductId = :cmpId")
	Stream<CompanyCustomer> findByCompanyProductIdReturnStream(@Param("cmpId") Long cmpId);

	@Query("select cc from CompanyCustomer cc where cc.companyName = :cmpName")
	Stream<CompanyCustomer> findByCompanyCustomerByNameReturnStream(@Param("cmpName") String cmpName);

	/**
	 * Sample default method to do ...something
	 * 
	 * @param customer
	 * @return
	 */
	default Optional<CompanyCustomer> findByLastname(Long cid) {

		return null;
	}

}
