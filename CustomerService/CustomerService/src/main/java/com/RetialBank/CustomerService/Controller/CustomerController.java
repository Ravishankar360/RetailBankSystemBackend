package com.RetialBank.CustomerService.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.RetialBank.CustomerService.Entity.Customer;
import com.RetialBank.CustomerService.Service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value="/createCustomer",method=RequestMethod.POST)
	public ResponseEntity<Long> createCustomer(@RequestBody Customer customer)
	{
		boolean b=customerService.checkbyssn(customer.getCustomerssnid());//customer id and status active
		long result=0;
		if(b==false)//customer donot exists
		{
		return new ResponseEntity<Long>(customerService.addCustomer(customer), HttpStatus.OK);
		}
		else//customer exists check its status
		{
			String status=customerService.checkstatus(customerService.viewbyssnid(customer.getCustomerssnid()).getCustomerid());
			System.out.println("Status==="+status);
			if(status.equals("inactive"))
			{
				result=-1;//customer id exists but inactive will return -1;
			}
			return new ResponseEntity<Long>(result, HttpStatus.OK);//customer exists and active this id cannot be used
		}
	}

}
