package com.RetialBank.AccountService.Entity;

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
	
}