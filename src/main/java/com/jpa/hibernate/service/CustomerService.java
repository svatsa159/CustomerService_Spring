package com.jpa.hibernate.service;

import java.util.Optional;

import com.jpa.hibernate.models.Customer;

public interface CustomerService {
	public Iterable<Customer> getAllCustomer();

	public Optional<Customer> findCustomerById(String id);

	public Optional<Customer> findCustomerByName(String name);

	public Customer createCustomer(String name);

	public void deleteCustomer(String id);
}
