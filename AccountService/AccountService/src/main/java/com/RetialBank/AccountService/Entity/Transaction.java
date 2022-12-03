package com.RetialBank.AccountService.Entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Transaction {
	
	@Column(name="transId")
	private long transId;
	
	@Column(name = "pbalance")
	private double pbalance;
	
	@Column(name = "abalance")
	private double abalance;
	
	@Column(name = "accountId")
	private long accountId;
	
	@Column(name = "customerId")
	private long customerId;
	
	@Column(name = "type")
	private String type;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "Date")
	Date date;
	
}