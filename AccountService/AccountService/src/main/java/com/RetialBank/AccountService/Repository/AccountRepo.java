package com.RetialBank.AccountService.Repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.RetialBank.AccountService.Entity.Account;

@Repository
public interface AccountRepo extends JpaRepository<Account,Long>{

	@Query(value="select * from account where CUSTOMER_ID=?1",nativeQuery = true)
	ArrayList<Account> viewAccountByCId(long cusid);

	@Query(value="select balance from account where account_Id=?1",nativeQuery=true)
	Double viewbalance(long accid);

}
