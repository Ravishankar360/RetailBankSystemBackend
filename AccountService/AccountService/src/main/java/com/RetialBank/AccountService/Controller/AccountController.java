package com.RetialBank.AccountService.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.RetialBank.AccountService.Entity.Account;
import com.RetialBank.AccountService.Service.AccountService;

@RestController
@CrossOrigin
public class AccountController {
	
	@Autowired
	AccountService accountService;
	
	@RequestMapping(value="/createAccount",method=RequestMethod.POST)
	public ResponseEntity<Long> createAccount(@RequestBody Account account){
		return new ResponseEntity<Long>(accountService.createAccount(account),HttpStatus.OK);
	}
	
	@RequestMapping(value = "/viewAllAccount",method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Account>> viewAllAccount(){
	   return new ResponseEntity<ArrayList<Account>>(accountService.viewAllAccount(),HttpStatus.OK);
	}
	
	@RequestMapping(value="/viewByAccountId",method = RequestMethod.GET)
	public ResponseEntity<Account> viewByAccountId(@RequestParam("accountId") long accid){
		return new ResponseEntity<Account>(accountService.viewAccountByAId(accid),HttpStatus.OK);
	}
	
	@RequestMapping(value="/viewAccByCustId",method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Account>> viewByAccByCustId(@RequestParam("customerId") long cusid){
		return new ResponseEntity<ArrayList<Account>>(accountService.viewAccountByCId(cusid),HttpStatus.OK);
	}
	
	@RequestMapping(value="/checkAccById",method = RequestMethod.GET)
	public ResponseEntity<Boolean> checkAccById(@RequestParam("accountId") long accid){
		return new ResponseEntity<Boolean>(accountService.checkAccountById(accid),HttpStatus.OK);
	}

	@RequestMapping(value="/getBalanceById",method=RequestMethod.POST)
	public ResponseEntity<Double> viewbalance(@RequestParam("accountId") long accid)
	{
		return new ResponseEntity<Double>(accountService.getbalance(accid),HttpStatus.OK);
	}
	
	@RequestMapping(value="/updateAccount",method = RequestMethod.POST)
	public ResponseEntity<Boolean> updateAccount(@RequestBody Account ac){
		boolean ab=accountService.checkAccountById(ac.getAccountId());
		if(ab==true)
		return new ResponseEntity<Boolean>(accountService.updateAccount(ac),HttpStatus.OK);
		else
			return new ResponseEntity<Boolean>(ab,HttpStatus.OK);
	}
	
	

}
