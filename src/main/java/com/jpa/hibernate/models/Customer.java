package com.jpa.hibernate.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	@Id
	@Column(name = "customer_id")
	private String customerId;
	@Column(name = "customer_name")
	private String customerName;
	@Column(name = "account_balance")
	private double accountBalance;
}
