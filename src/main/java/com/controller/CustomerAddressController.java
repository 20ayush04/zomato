package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.entity.CustomerAddressEntity;
import com.repository.CustomerAddressRepository;
import com.repository.CustomerRepository;

@RestController
public class CustomerAddressController {

	@Autowired
	CustomerAddressRepository customerAddressRepository;
	
	@Autowired
	CustomerRepository customerRepository;
	
	
	@PostMapping("customeraddress")	
	public CustomerAddressEntity customerAddress(@RequestBody CustomerAddressEntity customerAddressEntity){ 
		customerAddressRepository.save(customerAddressEntity);
		return customerAddressEntity;
	}
	
	
	@GetMapping("customeraddress")
	public List<CustomerAddressEntity> getAllCustomer(){
		List<CustomerAddressEntity> customerAddress = customerAddressRepository.findAll();
		if(customerAddress.isEmpty()) {
			return null;
		}else {
		    return customerAddress;
		}
	}
		
	
	
	@GetMapping("customeraddress/{customerId}")
	public CustomerAddressEntity getCustomerAddressById(@PathVariable("customerId") Integer customerId){
		Optional<CustomerAddressEntity> customerAddress = customerAddressRepository.findById(customerId);
		if(customerAddress.isEmpty()) {
			return null;
		}else {
			CustomerAddressEntity customerAddressEntity = customerAddress.get();
		    return customerAddressEntity;
		}
	}
	
	@DeleteMapping("customeraddress/{customeraddressId}")
	public String deleteCustomerAddress(@PathVariable("customeraddressId") Integer customeraddressId){
		Optional<CustomerAddressEntity> customerAddress = customerAddressRepository.findById(customeraddressId);
		if(customerAddress.isEmpty()) {
			return "Record Not Found";
		}else {
			return "Record Deleted";
		}
	}
	
	
	@PutMapping("customeraddress/{customeraddressId}")
	public CustomerAddressEntity updateCustomerAddress(@PathVariable("customeraddressId") Integer customeraddressId, @RequestBody CustomerAddressEntity customerAddressEntity){
			
			customerAddressRepository.save(customerAddressEntity);
			return customerAddressEntity;
		
	}
	
}
