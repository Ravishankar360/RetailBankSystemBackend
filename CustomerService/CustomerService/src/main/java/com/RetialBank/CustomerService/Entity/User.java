package com.RetialBank.CustomerService.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name="user")
public class User {
	
	   @Id
       @Column(name="userid")
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
       
	   
}
