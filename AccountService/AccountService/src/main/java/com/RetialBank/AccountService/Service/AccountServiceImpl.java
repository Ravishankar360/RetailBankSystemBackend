package com.RetialBank.AccountService.Service;

import java.util.ArrayList;
import java.util.Date;

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
		 Account account1 = new Account();
		 account1.setAccountType(account.getAccountType());
		 account1.setCustomerId(account.getCustomerId());
		 account1.setBalance(0.0);
		 account1.setAccstatus("Active");
		 account1.setCreated_at(new Date());
		 return  accountRepo.save(account1).getAccountId();
	}

	@Override
	public ArrayList<Account> viewAllAccount() {
		return (ArrayList<Account>) accountRepo.findAll();
	}

	@Override
	public Account viewAccountByAId(long accid) {
		Account ac = null;
		ac = accountRepo.findById(accid).get();
		if(ac!=null) {
			return ac;
		}
		return ac;
	}

	@Override
	public ArrayList<Account> viewAccountByCId(long cusid) {
		return accountRepo.viewAccountByCId(cusid);
	}

	@Override
	public Boolean checkAccountById(long accid) {
		return accountRepo.existsById(accid);
	}

	@Override
	public Double getbalance(long accid) {
		return accountRepo.viewbalance(accid);
	}

	@Override
	public Boolean updateAccount(Account ac) {
		Account as=accountRepo.save(ac);
		if(as==null)return false;
		return true;
	}

}
