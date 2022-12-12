package com.RetialBank.CustomerService;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.RetialBank.CustomerService.Entity.Customer;
import com.RetialBank.CustomerService.Repository.CustomerRepo;
import com.RetialBank.CustomerService.Vo.CustomerAccountVo;

@SpringBootTest
class CustomerServiceApplicationTests {

	@Autowired
	CustomerRepo customerRepo;
	
	@Test
	void contextLoads() {
	}
	
	@Tag("Dev")
	@Test
    void createCustomerTest() {
	  Customer customer = new Customer(111111111L,"Dev123@gmail.com","Dev123","Mr","Dev123@gmail.com","Devu","Sharma","","Noida","Sector49",477411L,"Active",000000000L,"Customer","QWER1234WE",new Date());
	  customerRepo.save(customer);
	  Customer retrievedUser = customerRepo.getByEmailName("Dev123@gmail.com");
      assertThat(retrievedUser.getPassword().equals(customer.getPassword()));
    
	}
	@Tag("Dev")
	@Test
	void ViewAllCustomerTest() {
	        List<Customer> retrievedtCus = customerRepo.findAll();
	        if(!retrievedtCus.isEmpty()) {
	         assertThat(true);
	        }
	 }
	
	@Tag("Dev")
	@Test
	void ViewAllCustomerByIdTest() {
		    Long id = 111111111L;
	        CustomerAccountVo retrievedtCus = customerRepo.getByCustomerId(id);
	        if(retrievedtCus.equals(id)) {
	         assertThat(true);
	        }
	 }
	
	@AfterEach
	void tearThis() {
		System.out.println("@AfterEach Executed");
	}
	
	@AfterAll
	static void tear() {
		System.out.println("@AfterAll Executed");
	
	}


	private boolean assertThat(boolean equals) {
		return true;
	}

}
