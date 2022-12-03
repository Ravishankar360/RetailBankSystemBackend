package com.RetialBank.AccountService.Service;

import java.util.ArrayList;

import com.RetialBank.AccountService.Entity.Account;

public interface AccountService {

	Long createAccount(Account account);

	ArrayList<Account> viewAllAccount();

	Account viewAccountByAId(long accid);

	ArrayList<Account> viewAccountByCId(long cusid);

	Boolean checkAccountById(long accid);

	Double getbalance(long accid);

	Boolean updateAccount(Account ac);

	Object updatebalance(double d, long accountId);

}
