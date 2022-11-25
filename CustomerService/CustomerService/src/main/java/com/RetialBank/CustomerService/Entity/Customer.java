package com.RetialBank.CustomerService.Entity;

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

	@Column(name="customerssnid")
	private long customerssnid;
		
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqid-gen")
	@Column(name = "customerid")
	private long customerid;
	
	public long getCustomerid() {
		return customerid;
	}

	@Column(name="customername")
	private String customername;
	
	@Column(name="contactno")
	private long contactno;
	
	@Column(name="city")
	private String city;
	
	@Column(name="email")
	private String email;
	
	@Column(name="status")
	private String status;

}
