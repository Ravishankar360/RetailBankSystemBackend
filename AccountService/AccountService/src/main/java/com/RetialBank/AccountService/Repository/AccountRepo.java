package com.RetialBank.AccountService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RetialBank.AccountService.Entity.Account;

@Repository
public interface AccountRepo extends JpaRepository<Account,Long>{

}
