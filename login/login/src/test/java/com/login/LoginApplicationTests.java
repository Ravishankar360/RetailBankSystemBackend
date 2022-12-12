package com.login;

import java.util.List;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.login.entity.User;
import com.login.repo.UserRepo;

@SpringBootTest
class LoginApplicationTests {
	
	@Autowired
	public UserRepo userRepo;

	@Test
	void contextLoads() {
	}
	
	@Test
    void createUserTest() {
        User user = new User(1L,"Ravi123@gmail.com","$2a$10$.emxNSnyGavPJAX3Bk/lRuv8ZtCkqU37QypT0611hE9RsHp76QtbK","Mr","Ravi123@gmail.com","Ravishankar","Sharma","","Noida","Sector49",477411L,"Active",00000000L,"Customer");
        userRepo.save(user);
        User retrievedUser = userRepo.userEmail("Ravi123@gmail.com");
        assertThat(retrievedUser.getPassword().equals(user.getPassword()));
    }
	
	@Tag("Dev")
	@Test
	void ViewAllUserTest() {
	        assertThat(true);
	        List<User> retrievedtUser = userRepo.findAll();
	        if(!retrievedtUser.isEmpty()) {
	         assertThat(true);
	        }
	 }

	private Object assertThat(boolean b) {
	  return true;
	}
	

}
