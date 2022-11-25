package com.RetialBank.CustomerService.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RetialBank.CustomerService.Entity.Customer;
import com.RetialBank.CustomerService.Repository.CustomerRepo;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepo customerRepo;
	
	public boolean checkbyssn(long ssn)
	{
		Object ab=customerRepo.checkbyssnid(ssn);// we have taken object as return type because we are not sure whether an entry exits here or not
		if(ab!=null)
		{
			System.out.println(ssn);//if id exists already it will print its value
			return true;
		}
		return false;
	}
	
	public String checkstatus(long id)
	{
		return customerRepo.checkstatus(id);
	}
	
	public Customer viewbyssnid(long ssnid)
	{
		return customerRepo.viewCustomerBySsnid(ssnid);
	}
	
	public long addCustomer(Customer customer)
	{
	 customer.setStatus("active");	
	 return  customerRepo.save(customer).getCustomerid();
		
	}

}
