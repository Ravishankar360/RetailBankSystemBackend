package com.RetialBank.CustomerService.Service;

import com.RetialBank.CustomerService.Entity.Customer;

public interface CustomerService {

	boolean checkbyssn(long customerssnid);

	Customer viewbyssnid(long customerssnid);

	String checkstatus(long customerid);

	long addCustomer(Customer customer);


}
