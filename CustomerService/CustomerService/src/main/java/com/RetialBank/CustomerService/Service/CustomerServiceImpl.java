package com.RetialBank.CustomerService.Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.RetialBank.CustomerService.Entity.Customer;
import com.RetialBank.CustomerService.Entity.User;
import com.RetialBank.CustomerService.Repository.CustomerRepo;
import com.RetialBank.CustomerService.Repository.UserRepo;
import com.RetialBank.CustomerService.Vo.CustomerAccountVo;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepo customerRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	//@Autowired
	//PasswordEncoder bcryptEncoder;
	
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
	 System.out.println(customer);
	 Customer newUser = new Customer();
		newUser.setUsername(customer.getUsername());
		newUser.setPassword(customer.getPassword());
		//newUser.setPassword(bcryptEncoder.encode(customer.getPassword()));
		newUser.setSaluatation(customer.getSaluatation());
		newUser.setFirstname(customer.getFirstname());
		newUser.setLastname(customer.getLastname());
		newUser.setUseremail(customer.getUseremail());
		newUser.setCity(customer.getCity());
		newUser.setAddress(customer.getAddress());
		newUser.setPostalcode(customer.getPostalcode());
		newUser.setStatus(customer.getStatus());
		newUser.setMobilenumber(customer.getMobilenumber());
		if(newUser.getMidlename()!=null && ! newUser.getMidlename().isEmpty()) {
		   newUser.setMidlename(customer.getMidlename());
		}else {
		   newUser.setMidlename("");
		}
		newUser.setRole(customer.getRole());
		newUser.setPan(customer.getPan());
		newUser.setDateOfBirth(customer.getDateOfBirth());
	   
		return customerRepo.save(newUser).getCustomerid();
		
	}

	@Override
	public Boolean checkCustomer(long id) {
		if(customerRepo.existsById(id))
		{
			String as=customerRepo.checkstatus(id);
			if(as.equals("active"))
				return true;
			else
				return false;
		}
		else
			return false;
	}

	@Override
	public ArrayList<Customer> viewallCustomers() {
		ArrayList<Customer> csm=new ArrayList<Customer>();
		csm=(ArrayList<Customer>) customerRepo.findAll();
		return csm;
	}

	@Override
	public int changestatus(String status, long cid) {
		return customerRepo.changestatus(status,cid);
	}

	@Override
	public CustomerAccountVo viewAllCustomerById(long id) {
		return customerRepo.getByCustomerId(id);
	}

	@Override
	public ArrayList<CustomerAccountVo> viewallCustomersInfomation() {
		ArrayList<CustomerAccountVo> csm=new ArrayList<CustomerAccountVo>();
		csm=(ArrayList<CustomerAccountVo>) customerRepo.findAllRecords();
		return csm;
	}

	@Override
	public Customer getFindEmail(Customer customer) {
		String useremail = customer.getUsername();
		Customer cus = customerRepo.getByEmailName(useremail);
		if(cus == null) {
			Customer cus1 = new Customer();
			User user= userRepo.getByEmailName(useremail);
			cus1.setFirstname(user.getFirstname());
			cus1.setLastname(user.getLastname());
			cus1.setSaluatation(user.getSaluatation());
			return cus1;
		}
		return cus;
	}

}
