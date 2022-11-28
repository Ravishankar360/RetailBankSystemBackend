package com.RetialBank.TransactionService.Controller;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.RetialBank.TransactionService.Entity.Account;
import com.RetialBank.TransactionService.Entity.Transaction;
import com.RetialBank.TransactionService.Service.TransactionService;

@RestController
@CrossOrigin
public class TransactionController {

	@Autowired
	TransactionService transactionService;

	@RequestMapping(value = "/showall", method = RequestMethod.POST)
	public ResponseEntity<ArrayList<Transaction>> getall() {
		return new ResponseEntity<ArrayList<Transaction>>(transactionService.getall(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/Deposit", method = RequestMethod.POST)
	public ResponseEntity<Long> deposit(@RequestBody Account account) {
		return new ResponseEntity<Long>(transactionService.deposit(account), HttpStatus.OK);
	}

	@RequestMapping(value = "/Withdraw", method = RequestMethod.POST)
	public ResponseEntity<Long> withdraw(@RequestBody Account account) {
		return new ResponseEntity<Long>(transactionService.withdraw(account), HttpStatus.OK);
	}

}
