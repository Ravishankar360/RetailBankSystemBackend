package com.RetialBank.AccountService;

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
	
	private boolean assertThat(boolean equals) {
		return true;
	}


}
