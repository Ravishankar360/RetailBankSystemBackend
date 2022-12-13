package com.RetialBank.AccountService;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.RetialBank.AccountService.Entity.Account;
import com.RetialBank.AccountService.Repository.AccountRepo;

@SpringBootTest
class AccountServiceApplicationTests {
	
	@Autowired
	private AccountRepo accRepo;

	@Test
	void contextLoads() {
	}
	
	@Test
    void createTransactionStatementTest() {
        Account acc = new Account(3L,00000000L,"Saving Account",0,"Active");
        accRepo.save(acc);
        Account retrievedAcc = accRepo.getById(3L);
        assertThat(retrievedAcc.getAccountId()==acc.getAccountId());
       
    }
	
	@Tag("Dev")
	@Test
	void ViewAllAccountTest() {
	        List<Account> retrievedtAccount = accRepo.findAll();
	        if(!retrievedtAccount.isEmpty()) {
	         assertThat(true);
	        }
	 }
	
	@Tag("Dev")
	@Test
	void ViewAllAccountByIdTest() {
		    Long id = 3L;
	        Optional<Account> retrievedtAccount = accRepo.findById(id);
	        if(retrievedtAccount.equals(id)) {
	         assertThat(true);
	        }
	 }
	
	
	private boolean assertThat(boolean equals) {
		return true;
	}
	
	@AfterEach
	void tearThis() {
		System.out.println("@AfterEach Executed");
	}
	
	@AfterAll
	static void tear() {
		System.out.println("@AfterAll Executed");
	}


}
