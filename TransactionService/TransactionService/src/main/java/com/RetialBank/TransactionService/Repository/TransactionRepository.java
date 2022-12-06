package com.RetialBank.TransactionService.Repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.RetialBank.TransactionService.Entity.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long>{

	@Query(value="select * from transaction WHERE customer_id =?1",nativeQuery=true)
	ArrayList<Transaction> getTransactionStatement(long customerid);

}
