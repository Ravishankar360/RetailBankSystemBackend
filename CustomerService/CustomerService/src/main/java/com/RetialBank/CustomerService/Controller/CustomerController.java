package com.RetialBank.CustomerService.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.RetialBank.CustomerService.Entity.Customer;
import com.RetialBank.CustomerService.Service.CustomerService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
//@CrossOrigin(origins = { "http://localhost:4200"})
//@CrossOrigin(origins = "**", allowedHeaders = "**")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value="/createCustomer",method=RequestMethod.POST)
	public ResponseEntity<Long> createCustomer(@RequestBody Customer customer)
	{
//		boolean b=customerService.checkbyssn(customer.getCustomerssnid());//customer id and status active
//		long result=0;
//		if(b==false)//customer donot exists
//		{
//		return new ResponseEntity<Long>(customerService.addCustomer(customer), HttpStatus.OK);
//		}
//		else//customer exists check its status
//		{
//			String status=customerService.checkstatus(customerService.viewbyssnid(customer.getCustomerssnid()).getCustomerid());
//			System.out.println("Status==="+status);
//			if(status.equals("inactive"))
//			{
//				result=-1;//customer id exists but inactive will return -1;
//			}
//			return new ResponseEntity<Long>(result, HttpStatus.OK);//customer exists and active this id cannot be used
//		}
		return new ResponseEntity<Long>(customerService.addCustomer(customer), HttpStatus.OK);
	}
	
	@RequestMapping(value="/checkCustomer",method=RequestMethod.GET)
	public ResponseEntity<Boolean> checkCustomer(@RequestParam("customerid") long id)
	{
		return new ResponseEntity<Boolean>(customerService.checkCustomer(id), HttpStatus.OK);
	}
	@RequestMapping(value="/viewAllCustomers",method=RequestMethod.GET)
	public ResponseEntity<ArrayList<Customer>> viewAllCustomers()
	{
		return new ResponseEntity<ArrayList<Customer>>(customerService.viewallCustomers(), HttpStatus.OK);		
	}
	@RequestMapping(value="/deleteCustomer",method=RequestMethod.GET)
	public ResponseEntity<Boolean> deleteCustomer(@RequestParam("customerid") long id)
	{
		boolean b=customerService.checkCustomer(id);
		if(b==false)//customer donot exists cannot be deleted
		{
			return new ResponseEntity<Boolean>(b, HttpStatus.OK);
		}
		int ab=customerService.changestatus("inactive",id);//customer exists mark it as inactive
		if(ab>0)//ideally it should be 1
		{
			return new ResponseEntity<Boolean>(b, HttpStatus.OK);		
		}
		else
			{b=false;return new ResponseEntity<Boolean>(b, HttpStatus.OK);}		
	}
	@RequestMapping(value="/updateCustomer",method=RequestMethod.POST)
	public ResponseEntity<Boolean> updateCustomer(@RequestBody Customer cm)
	{
		boolean b=customerService.checkCustomer(cm.getCustomerid());
		if(b==true)
		{
			customerService.addCustomer(cm);
		return new ResponseEntity<Boolean>(b, HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<Boolean>(b, HttpStatus.OK);	
		}
	}


}
