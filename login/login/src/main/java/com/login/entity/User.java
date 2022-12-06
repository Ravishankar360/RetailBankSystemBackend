package com.login.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="user")
public class User {

	  
	   @Id
       @Column(name="userid")
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       private long userid;
	  
       @Column(name="username")
	   private String username;
       
	   @Column(name="password")
	   @JsonIgnore
	   private String password;
	   
	   @Column(name="saluatation")
	   private String saluatation;
	   
	   @Column(name="useremail")
	   private String useremail;
	   
	   @Column(name="firstname")
	   private String firstname;
	   
	   @Column(name="lastname")
	   private String lastname;
	   
	   @Column(name="midlename")
	   private String midlename;
	   
	   @Column(name="city")
	   private String city;
	   
	   @Column(name="address")
	   private String address;
	   
	   @Column(name="postalcode")
	   private long postalcode;
	   
	   @Column(name="status")
	   private String status;
	   
       @Column(name="mobilenumber")
	   private long mobilenumber;
       
       @Column(name="role")
	   private String role;

	public User(long userid ,String username, String password, String saluatation, String useremail,
			String firstname, String lastname, String midlename, String city, String address, Long postalcode,
			String status, Integer mobilenumber, String role) {
		// TODO Auto-generated constructor stub
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.saluatation = saluatation;
		this.useremail = useremail;
		this.firstname = firstname;
		this.lastname = lastname;
		this.midlename = midlename;
		this.city = city;
		this.address = address;
		this.postalcode = postalcode;
		this.status = status;
		this.mobilenumber = mobilenumber;
		this.role = role;
	}
       
       
	   
}
