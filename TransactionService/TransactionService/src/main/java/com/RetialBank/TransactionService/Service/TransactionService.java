package com.RetialBank.TransactionService.Service;

import java.util.ArrayList;

import com.RetialBank.TransactionService.Entity.Account;
import com.RetialBank.TransactionService.Entity.Transaction;

public interface TransactionService {

	Long deposit(Account account);

	Long withdraw(Account account);

	ArrayList<Transaction> getall();

}
