package com.RetialBank.CustomerService.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.data.annotation.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "customer")
@SequenceGenerator(name = "seqid-gen", sequenceName = "userid", initialValue = 111111111, allocationSize = 1)
public class Customer {

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


	public Customer(long customerid, String username, String password, String saluatation, String useremail,
			String firstname, String lastname, String midlename, String city, String address, long postalcode,
			String status, long mobilenumber, String role, String pan, Date dateOfBirth) {
		this.customerid = customerid;
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
		this.pan = pan;
		this.dateOfBirth=dateOfBirth;
	}
	

}
