package com.jpa.hibernate.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.hibernate.models.Customer;
import com.jpa.hibernate.repo.CustomerDao;

@Service
public class CustomerServiceImpl implements CustomerService {
	private CustomerDao customerDao;

	public CustomerServiceImpl(CustomerDao customerDao) {
		super();
		this.customerDao = customerDao;
	}

	@Override
	@Transactional
	public Iterable<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		return customerDao.findAll();
	}

	@Override
	@Transactional
	public Optional<Customer> findCustomerById(String id) {
		// TODO Auto-generated method stub
		return customerDao.findById(id);
	}

	@Override
	@Transactional
	public Optional<Customer> findCustomerByName(String name) {
		// TODO Auto-generated method stub
		return customerDao.findCustomerByCustomerName(name);
	}

	@Override
	@Transactional
	public Customer createCustomer(String name) {
		// TODO Auto-generated method stub
		Customer customer = new Customer(UUID.randomUUID().toString(), name, 0);
		customerDao.save(customer);
		return customer;
	}

	@Override
	public void deleteCustomer(String id) {
		// TODO Auto-generated method stub
		Customer customer = findCustomerById(id).get();
		customerDao.delete(customer);

	}

}
