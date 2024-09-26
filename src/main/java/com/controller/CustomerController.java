package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.entity.CustomerAddressEntity;
import com.repository.CustomerAddressRepository;

@RestController
public class CustomerController {

	@Autowired
	CustomerAddressRepository customerAddressRepository;
	
	@PostMapping("customeraddress")
	public CustomerAddressEntity customerAddress(@RequestBody CustomerAddressEntity customerAddressEntity) {
		
		customerAddressRepository.save(customerAddressEntity);
		return customerAddressEntity;
	}
	
}
