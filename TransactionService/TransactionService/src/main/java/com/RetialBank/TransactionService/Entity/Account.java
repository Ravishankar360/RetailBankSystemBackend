package com.RetialBank.TransactionService.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Account {
	private long accountId;
	private long customerId;
	private String accountType;
	private double balance;

}
