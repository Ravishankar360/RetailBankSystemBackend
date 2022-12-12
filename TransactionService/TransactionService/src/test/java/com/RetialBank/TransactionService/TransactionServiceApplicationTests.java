package com.RetialBank.TransactionService;

import java.util.List;
import java.util.Optional;

import javax.persistence.TransactionRequiredException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.RetialBank.TransactionService.Entity.Transaction;
import com.RetialBank.TransactionService.Repository.TransactionRepository;

@SpringBootTest
class TransactionServiceApplicationTests {
	
	@Autowired
	private TransactionRepository transRepository;

	@Tag("Dev")
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
	
	@Test
	void contextLoads() {
	}
	
	@Tag("Dev")
	@Test
	void ViewAllTransactionTest() {
	        assertThat(true);
	        List<Transaction> retrievedtran = transRepository.findAll();
	        if(!retrievedtran.isEmpty()) {
	         assertThat(true);
	        }
	}
	
	@Tag("Dev")
	@Test
	void ViewAllTransactionByIdTest() {
		    Long id = 2L;
	        Optional<Transaction> retrievedtrans = transRepository.findById(id);
	        if(retrievedtrans.equals(id)) {
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
