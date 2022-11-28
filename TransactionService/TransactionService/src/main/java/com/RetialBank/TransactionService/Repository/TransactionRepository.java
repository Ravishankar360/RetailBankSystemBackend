package com.RetialBank.TransactionService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RetialBank.TransactionService.Entity.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long>{

}
