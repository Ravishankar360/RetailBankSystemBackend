package com.RetialBank.CustomerService.Service;

import java.util.ArrayList;

import com.RetialBank.CustomerService.Entity.Customer;

public interface CustomerService {

	boolean checkbyssn(long customerssnid);

	Customer viewbyssnid(long customerssnid);

	String checkstatus(long customerid);

	long addCustomer(Customer customer);

	Boolean checkCustomer(long id);

	ArrayList<Customer> viewallCustomers();

	int changestatus(String string, long id);


}
