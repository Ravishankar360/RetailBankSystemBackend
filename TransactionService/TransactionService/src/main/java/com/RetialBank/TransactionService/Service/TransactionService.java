package com.RetialBank.TransactionService.Service;

import java.util.ArrayList;

import com.RetialBank.TransactionService.Entity.Account;
import com.RetialBank.TransactionService.Entity.Transaction;

public interface TransactionService {


	Long withdraw(Transaction transaction);

	ArrayList<Transaction> getall();

	Long transactionStatement(Transaction transaction);

}
