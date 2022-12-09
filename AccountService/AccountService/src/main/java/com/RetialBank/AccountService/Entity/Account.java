package com.RetialBank.AccountService.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@SequenceGenerator(name = "seqid-gen", sequenceName = "acctid",initialValue = 312456789, allocationSize = 1)
@Table(name = "account")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqid-gen")
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

	public Account(long accountId, long customerId, String accountType, double balance, String accstatus) {
		super();
		this.accountId = accountId;
		this.customerId = customerId;
		this.accountType = accountType;
		this.balance = balance;
		this.accstatus = accstatus;
	}
	
	
	
}
