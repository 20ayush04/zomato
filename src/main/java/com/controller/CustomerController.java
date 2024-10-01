package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.entity.CustomerEntity;
import com.repository.CustomerRepository;

@RestController
public class CustomerController {

	
	
	@Autowired
	CustomerRepository customerRepository;
	
	
	
	@GetMapping("customers")
	public List<CustomerEntity> getAllCustomers() {
		List<CustomerEntity> allcustomers = customerRepository.findAll();
		return allcustomers;
	}
	
	
	
	@GetMapping("customers/{customerId}")
	public CustomerEntity getCustomerById(@PathVariable("customerId") Integer customerId ) {
		Optional<CustomerEntity> customers = customerRepository.findById(customerId);
		if(customers.isEmpty()) {
			return null;
		}else {
			CustomerEntity customerEntity = customers.get();
			return customerEntity;
		}
		
	}
	
	
	
	@DeleteMapping("customers/{customerId}")
	public CustomerEntity deleteCustomerById(@PathVariable("customerId") Integer customerId , CustomerEntity customerEntity)
	{
		Optional<CustomerEntity> customer = customerRepository.findById(customerId);
		if(customer.isEmpty()) {
			return null;
		}else {
			customerRepository.deleteById(customerId);
			return customerEntity;
		}
	}
	
	
	
	 @PutMapping("customers/{customerId}")
	 public CustomerEntity updateCustomerByID(@PathVariable ("customerId") Integer customerId, @RequestBody CustomerEntity customerEntity) {
	 	customerRepository.save(customerEntity);
	 	return customerEntity;
	 }
	
	
}
