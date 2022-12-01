package com.RetialBank.CustomerService.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@Table(name = "account")
public class Account {

	@Id
	@Column(name = "accountId")
	private long accountId;
	
	@Column(name = "customerId")
	private long customerId;
	
	@Column(name = "accountType")
	private String accountType;
	
	@Column(name = "balance")
	private double balance;
	
	@Column(name = "accstatus")
	private String accstatus;
	
	@Column(name = "created_at")
	private Date created_at;
	
}
