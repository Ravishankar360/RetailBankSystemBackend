package com.RetialBank.AccountService.Service;

import java.util.ArrayList;

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
