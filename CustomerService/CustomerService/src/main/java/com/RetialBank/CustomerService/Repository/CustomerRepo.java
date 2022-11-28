package com.RetialBank.CustomerService.Repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.RetialBank.CustomerService.Entity.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,Long> {

	@Query(value="select customerid from customer where customerssnid=?1",nativeQuery = true)
	Object checkbyssnid(long ssn);

	@Query(value = "select status from customer where customerid=?1",nativeQuery = true)
	String checkstatus(long id);

	@Query(value="select * from customer where customerssnid=?1",nativeQuery = true)
	Customer viewCustomerBySsnid(long ssnid);

	@Modifying
	@Transactional
	@Query(value="update customer SET status =?1 WHERE customerid =?2",nativeQuery=true)
	int changestatus(String status, long cid);

}
