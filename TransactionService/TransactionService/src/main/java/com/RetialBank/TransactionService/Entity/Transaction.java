package com.RetialBank.TransactionService.Entity;

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
@SequenceGenerator(name = "seqid-gen", sequenceName = "transid",initialValue = 500000001)
@Table(name = "transaction")
public class Transaction {

	@Id
	@Column(name="transId")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqid-gen")
	private long transId;
	
	@Column(name = "pbalance")
	private double pbalance;
	
	@Column(name = "abalance")
	private double abalance;
	
	@Column(name = "accountId")
	private long accountId;
	
	@Column(name = "customerId")
	private long customerId;

	@Column(name = "date")
	private Date date;

	@Column(name = "type")
	private String type;

	public Transaction(long transId, double pbalance, double abalance, long accountId, long customerId,
			String type) {
		super();
		this.transId = transId;
		this.pbalance = pbalance;
		this.abalance = abalance;
		this.accountId = accountId;
		this.customerId = customerId;
		this.type = type;
	}
	
	
	

}
