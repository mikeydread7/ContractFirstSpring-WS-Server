package com.example.demo.ws.jpa.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import com.example.demo.ws.domain.CompanyCustomer;

/*if we want that our query method is executed asynchronously, we have to annotate it with the 
@Async annotation and return a Future<T> object.
Here are some examples of query methods that are executed asynchronously:*/
public interface CrmJpaRepository extends CrudRepository<CompanyCustomer, Long> {

    List<CompanyCustomer> findByEmail(String email);

    List<CompanyCustomer> findByDate(Date date);    
	// custom query example and return a stream
    @Query("select cc from CompanyCustomer cc where cc.email = :email")
    Stream<CompanyCustomer> findByEmailReturnStream(@Param("email") String email);

    //Another custom query example and return a stream
    @Query("select cc from CompanyCustomer cc where cc.companyProductId = :cmpId")
    Stream<CompanyCustomer> findBycompanyProductIdReturnStream(@Param("cmpId") Long cmpId);
    
    /**
	 * Sample default method to work on!!
	 * 
	 * @param customer
	 * @return
	 */
	/*default Optional<CompanyCustomer> findByLastname(CompanyCustomer companyCustomer) {
		return findByCutomerName(companyCustomer == null ? null : companyCustomer.getCutomerName());
    }*/
    
}


