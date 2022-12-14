package com.login.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.login.DTO.UserDTO;
import com.login.config.JwtTokenUtil;
import com.login.entity.JwtRequest;
import com.login.entity.JwtResponse;
import com.login.entity.User;
import com.login.service.JWTUserDetailsService;


@RestController
//@CrossOrigin(origins = "*")
@CrossOrigin(origins="http://localhost:4200")
public class UserController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JWTUserDetailsService userDetailsService;

	//@PostMapping("/login")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new JwtResponse(token));
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody UserDTO user) throws Exception {
		return ResponseEntity.ok(userDetailsService.save(user));
	}

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
	
	@RequestMapping(value="/viewAllUsers",method=RequestMethod.GET)
	public ResponseEntity<ArrayList<User>> viewAllCustomers()
	{
		return new ResponseEntity<ArrayList<User>>(userDetailsService.viewallCustomers(), HttpStatus.OK);		
	}
	
	//@RequestMapping(value="/getByUserEmail/{username}", method = RequestMethod.GET)
	@RequestMapping(value = "/getByUserEmail", method = RequestMethod.POST)
	public ResponseEntity<User> getByUserEmail(@RequestBody UserDTO user)
	{
		return new ResponseEntity<User> (userDetailsService.getByUserEmail(user), HttpStatus.OK);
	}
	
	@RequestMapping(value="/viewAllUserById/{userid}",method=RequestMethod.GET)
	public ResponseEntity<User> viewAllCustomerById(@PathVariable("userid") Integer id)
	{
		return new ResponseEntity<User>(HttpStatus.OK);		
	}
}