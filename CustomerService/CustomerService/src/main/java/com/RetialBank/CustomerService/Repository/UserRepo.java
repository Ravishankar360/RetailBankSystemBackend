package com.RetialBank.CustomerService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.RetialBank.CustomerService.Entity.Customer;
import com.RetialBank.CustomerService.Entity.User;

public interface UserRepo extends JpaRepository<User, Long>{

	@Query(value="select * from user WHERE useremail =?1",nativeQuery=true)
	User getByEmailName(String useremail);

}
