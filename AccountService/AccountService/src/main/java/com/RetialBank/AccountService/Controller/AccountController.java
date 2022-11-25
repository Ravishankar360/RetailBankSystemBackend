package com.RetialBank.AccountService.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

}
