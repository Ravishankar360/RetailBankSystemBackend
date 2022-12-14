package com.login.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.login.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {

	User findByUsername(String username);

	@Query(value="select * from user where username=?1",nativeQuery = true)
	User userEmail(String userEmail);
   


}
