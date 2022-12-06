package com.RetialBank.TransactionService.Service;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.RetialBank.TransactionService.Entity.Account;
import com.RetialBank.TransactionService.Entity.Transaction;
import com.RetialBank.TransactionService.Repository.TransactionRepository;

import org.springframework.http.ResponseEntity;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionRepository transRepo;

	@Override
	public Long withdraw(Transaction transaction) {
		Transaction te = new Transaction();
		te.setAbalance(transaction.getAbalance());
		te.setPbalance(transaction.getPbalance());
		te.setAccountId(transaction.getAccountId());
		te.setCustomerId(transaction.getCustomerId());
		te.setType(transaction.getType());
		te.setDate(new Date());
		return transRepo.save(te).getTransId();
	}

	@Override
	public ArrayList<Transaction> getall() {
		return (ArrayList<Transaction>) transRepo.findAll();
	}

	@Override
	public Long transactionStatement(Transaction transaction) {
		Transaction te = new Transaction();
		te.setAbalance(transaction.getAbalance());
		te.setPbalance(transaction.getPbalance());
		te.setAccountId(transaction.getAccountId());
		te.setCustomerId(transaction.getCustomerId());
		te.setType(transaction.getType());
		te.setDate(new Date());
		return transRepo.save(te).getTransId();
	}

	@Override
	public ArrayList<Transaction> getTransactionStatement(long customerid) {
		return transRepo.getTransactionStatement(customerid);
	}

}
