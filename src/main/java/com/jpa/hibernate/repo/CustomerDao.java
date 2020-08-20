package com.jpa.hibernate.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpa.hibernate.models.Customer;

@Repository
public interface CustomerDao extends JpaRepository<Customer, String> {
	public Optional<Customer> findCustomerByCustomerName(String name);
}
