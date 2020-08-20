package com.jpa.hibernate.rest;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.hibernate.models.Customer;
import com.jpa.hibernate.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerController {
	private CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}

	@GetMapping("/customers")
	public ResponseEntity<Iterable<Customer>> getAllCustomers() {
		return ResponseEntity.ok(customerService.getAllCustomer());
	}

	@GetMapping("/customer/id/{customer_id}")
	public ResponseEntity<Optional<Customer>> findCustomerById(@PathVariable("customer_id") String id) {
		return ResponseEntity.status(HttpStatus.FOUND).body(customerService.findCustomerById(id));
	}

	@GetMapping("/customer/name/{customer_name}")
	public ResponseEntity<Optional<Customer>> findCustomerByName(@PathVariable("customer_name") String name) {
		return new ResponseEntity<Optional<Customer>>(customerService.findCustomerByName(name), HttpStatus.FOUND);
	}

	@PostMapping("/customer/add")
	public ResponseEntity<Customer> addCustomer(@RequestParam String name) {

		return new ResponseEntity<Customer>(customerService.createCustomer(name), HttpStatus.OK);
	}

	@DeleteMapping("/customer/delete")
	public ResponseEntity<String> deleteCustomer(@RequestParam String id) {
		customerService.deleteCustomer(id);
		return new ResponseEntity<String>("Customer Deleted", HttpStatus.OK);
	}
}
