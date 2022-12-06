package com.RetialBank.TransactionService.Controller;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.RetialBank.TransactionService.Entity.Account;
import com.RetialBank.TransactionService.Entity.Transaction;
import com.RetialBank.TransactionService.Service.TransactionService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class TransactionController {

	@Autowired
	TransactionService transactionService;

	@RequestMapping(value = "/showall", method = RequestMethod.POST)
	public ResponseEntity<ArrayList<Transaction>> getall() {
		return new ResponseEntity<ArrayList<Transaction>>(transactionService.getall(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/getTransactionStatement/{customerid}",method=RequestMethod.GET)
	public ResponseEntity<ArrayList<Transaction>> getTransactionStatement(@PathVariable("customerid") long id)
	{
		return new ResponseEntity<ArrayList<Transaction>>(transactionService.getTransactionStatement(id), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/Deposit", method = RequestMethod.POST)
	public ResponseEntity<Long> transactionStatement(@RequestBody Transaction transaction) {
		return new ResponseEntity<Long>(transactionService.transactionStatement(transaction), HttpStatus.OK);
	}

	@RequestMapping(value = "/Withdraw", method = RequestMethod.POST)
	public ResponseEntity<Long> withdraw(@RequestBody Transaction transaction) {
		return new ResponseEntity<Long>(transactionService.withdraw(transaction), HttpStatus.OK);
	}

}
