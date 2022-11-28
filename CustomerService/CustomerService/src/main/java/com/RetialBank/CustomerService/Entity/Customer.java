package com.RetialBank.CustomerService.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "customer")
@SequenceGenerator(name = "seqid-gen", sequenceName = "userid", initialValue = 111111111, allocationSize = 1)
public class Customer {

	@Column(name = "customerssnid")
	private long customerssnid;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqid-gen")
	@Column(name = "customerid")
	private long customerid;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "saluatation")
	private String saluatation;

	@Column(name = "useremail")
	private String useremail;

	@Column(name = "firstname")
	private String firstname;

	@Column(name = "lastname")
	private String lastname;

	@Column(name = "midlename")
	private String midlename;

	@Column(name = "city")
	private String city;

	@Column(name = "address")
	private String address;

	@Column(name = "postalcode")
	private long postalcode;

	@Column(name = "status")
	private String status;

	@Column(name = "mobilenumber")
	private long mobilenumber;

	@Column(name = "role")
	private String role;

	@Column(name = "pan")
	private String pan;

	@Column(name = "dob")
	private Date dateOfBirth;

}
