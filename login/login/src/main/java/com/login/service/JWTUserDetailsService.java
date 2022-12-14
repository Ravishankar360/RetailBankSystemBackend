package com.login.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.login.DTO.UserDTO;
import com.login.entity.User;
import com.login.repo.UserRepo;

@Service
public class JWTUserDetailsService implements UserDetailsService {
	
	@Autowired
	UserRepo userRepo;

	@Autowired
	PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				new ArrayList<>());
	}
	
	public User save(com.login.DTO.UserDTO user) {
		User newUser = new User();
		newUser.setUsername(user.getUsername());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		newUser.setSaluatation(user.getSaluatation());
		newUser.setFirstname(user.getFirstname());
		newUser.setLastname(user.getLastname());
		newUser.setUseremail(user.getUseremail());
		newUser.setCity(user.getCity());
		newUser.setAddress(user.getAddress());
		newUser.setPostalcode(user.getPostalcode());
		newUser.setStatus(user.getStatus());
		newUser.setMobilenumber(user.getMobilenumber());
		if(newUser.getMidlename()!=null && ! newUser.getMidlename().isEmpty()) {
		   newUser.setMidlename(user.getMidlename());
		}else {
		   newUser.setMidlename("");
		}
		newUser.setRole(user.getRole());
		return userRepo.save(newUser);
	}

	public ArrayList<User> viewallCustomers() {
		ArrayList<User> user = new ArrayList<>();
		user=(ArrayList<User>) userRepo.findAll();
		return user;
	}

	public User getByUserEmail(UserDTO user) {
		String username = user.getUsername();
		return userRepo.userEmail(username);
	}

	public Optional<User> viewAllUserById(Integer id) {
		return userRepo.findById(id);
	}
}