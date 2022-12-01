package com.RetialBank.CustomerService.Repository;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.RetialBank.CustomerService.Entity.Customer;
import com.RetialBank.CustomerService.Vo.CustomerAccountVo;

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

	@Query(value="select new com.RetialBank.CustomerService.Vo.CustomerAccountVo(c.customerid,c.username,c.saluatation,c.useremail,c.firstname,c.lastname,"
			+ "c.midlename,c.city,c.address,c.postalcode,c.status,c.mobilenumber,c.role,c.pan,c.dateOfBirth,a.accountId,a.accountType,a.balance,a.created_at)"
			+ " from Customer c join Account a on a.customerId=c.customerid where c.status='Active' ")
	ArrayList<CustomerAccountVo> findAllRecords();

	@Query(value="select new com.RetialBank.CustomerService.Vo.CustomerAccountVo(c.customerid,c.username,c.saluatation,c.useremail,c.firstname,c.lastname,"
			+ "c.midlename,c.city,c.address,c.postalcode,c.status,c.mobilenumber,c.role,c.pan,c.dateOfBirth,a.accountId,a.accountType,a.balance,a.created_at)"
			+ " from Customer c join Account a on a.customerId=c.customerid where c.status='Active' and c.customerid=?1 ")
	CustomerAccountVo getByCustomerId(long id);

	@Query(value="select * from customer WHERE username =?1",nativeQuery=true)
	Customer getByEmailName(String useremail);

}
