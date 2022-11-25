package com.RetialBank.AccountService.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RetialBank.AccountService.Entity.Account;
import com.RetialBank.AccountService.Repository.AccountRepo;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountRepo accountRepo;

	@Override
	public Long createAccount(Account account) {
		 return  accountRepo.save(account).getAccountId();
	}

}
