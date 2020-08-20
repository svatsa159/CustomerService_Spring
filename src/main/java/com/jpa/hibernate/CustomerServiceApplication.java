package com.jpa.hibernate;

import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jpa.hibernate.models.Customer;
import com.jpa.hibernate.repo.CustomerDao;

@SpringBootApplication
public class CustomerServiceApplication implements CommandLineRunner {

	private CustomerDao customerDao;

	public CustomerServiceApplication(CustomerDao customerDao) {
		super();
		this.customerDao = customerDao;
	}

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		customerDao.save(new Customer(UUID.randomUUID().toString(), "John Doe", 80000.00));
		customerDao.save(new Customer(UUID.randomUUID().toString(), "Mary Kom", 120000.00));
		customerDao.save(new Customer(UUID.randomUUID().toString(), "DK", 200000.00));
	}

}
