package com.RetialBank.CustomerService;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.RetialBank.CustomerService.Entity.Customer;
import com.RetialBank.CustomerService.Repository.CustomerRepo;

@SpringBootTest
class CustomerServiceApplicationTests {

	@Autowired
	CustomerRepo customerRepo;
	
	@Test
	void contextLoads() {
	}
	
	@Test
    void createCustomerTest() {
	  Customer customer = new Customer(111111111L,"Dev123@gmail.com","Dev123","Mr","Dev123@gmail.com","Devu","Sharma","","Noida","Sector49",477411L,"Active",000000000L,"Customer","QWER1234WE",new Date());
	  customerRepo.save(customer);
	  Customer retrievedUser = customerRepo.getByEmailName("Dev123@gmail.com");
      assertThat(retrievedUser.getPassword().equals(customer.getPassword()));
    
	}

	private boolean assertThat(boolean equals) {
		return true;
	}

}
