package com.RetialBank.AccountService.Repository;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.RetialBank.AccountService.Entity.Account;

@Repository
public interface AccountRepo extends JpaRepository<Account,Long>{

	@Query(value="select * from account where customer_id=?1",nativeQuery = true)
	ArrayList<Account> viewAccountByCId(long cusid);

	@Query(value="select balance from account where account_Id=?1",nativeQuery=true)
	Double viewbalance(long accid);

	@Modifying
	@Transactional
	@Query(value="update account set balance=?1 where account_id=?2",nativeQuery=true)
	Object updatebalance(double bal, long accountId);

}
