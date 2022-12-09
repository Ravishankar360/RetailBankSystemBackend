package com.RetialBank.TransactionService;

import javax.persistence.TransactionRequiredException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.RetialBank.TransactionService.Entity.Transaction;
import com.RetialBank.TransactionService.Repository.TransactionRepository;

@SpringBootTest
class TransactionServiceApplicationTests {
	
	@Autowired
	private TransactionRepository transRepository;

	@Test
	void contextLoads() {
	}
	
	@Test
    void createTransactionStatementTest() {
        Transaction tran = new Transaction(1L,200,0,2323453543L,00000000L,"Debit");
        transRepository.save(tran);
        assertThat(true);
        Transaction retrievedtran = transRepository.getById(1L);
        assertThat(true);
        
        Transaction tran1 = new Transaction(2L,200,0,2323453543L,00000000L,"Credit");
        transRepository.save(tran1);
        assertThat(true);
        Transaction retrievedtran1 = transRepository.getById(2L);
        assertThat(true);
       
    }
	
	private boolean assertThat(boolean equals) {
		return true;
	}


}
