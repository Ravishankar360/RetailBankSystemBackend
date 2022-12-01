package com.RetialBank.CustomerService.Vo;

import java.util.Date;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerAccountVo {

	private long customerid;
	private String username;
	private String password;
	private String saluatation;
	private String useremail;
	private String firstname;
	private String lastname;
	private String midlename;
	private String city;
	private String address;
	private long postalcode;
	private String status;
	private String accstatus;
	private long mobilenumber;
	private String role;
	private String pan;
	private Date dateOfBirth;
	private long accountId;
	private long customerId;
	private String accountType;
	private double balance;
	private Date created_at;
	

	public CustomerAccountVo(long customerid,String username, String saluatation, String useremail, String firstname, String lastname,
			String midlename, String city, String address, long postalcode, String status,
			long mobilenumber, String role, String pan, Date dateOfBirth, long accountId, String accountType,
			double balance, Date created_at) {
		super();
		this.customerid=customerid;
		this.username = username;
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
		this.dateOfBirth = dateOfBirth;
		this.accountId = accountId;
		this.accountType = accountType;
		this.balance = balance;
		this.created_at = created_at;
	}
	
	
	
	

}
