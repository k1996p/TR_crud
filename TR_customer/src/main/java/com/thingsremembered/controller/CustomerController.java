package com.thingsremembered.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thingsremembered.dto.CustomerData;
import com.thingsremembered.model.Customer;
import com.thingsremembered.services.CustomerService;

@RestController
@RequestMapping(path="/Customers", produces = "application/json")
@CrossOrigin(origins = "*")

public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/getAllCustomers")
	public ResponseEntity<List<CustomerData>> findAllCustomer() {
		List<CustomerData> list=customerService.findAll();
		if(list.size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
		
	}
	
	
	@GetMapping("/Customer/{id}")
	public ResponseEntity<CustomerData> findById(@PathVariable  Long id) {
		
		CustomerData customerData =customerService.findById(id);
		if(customerData==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		return ResponseEntity.of(Optional.of(customerData));
	}
	@PostMapping("/Customer")
	public ResponseEntity<CustomerData> create(@RequestBody CustomerData customerData) {
		CustomerData cData=null;	
		 try {
			 cData=this.customerService.create(customerData);
			 System.out.println(customerData);
			 return ResponseEntity.of(Optional.of(cData));
		 }
		 catch(Exception e) {
			 e.printStackTrace();
			 return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		 }
		
		
	}

	@DeleteMapping("/Customer/{id}")
	public ResponseEntity<Void> deleteCustomerById(@PathVariable Long id) {
		try {
			this.customerService.delete(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		catch(Exception e) {
			 e.printStackTrace();
			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
		
	}
	
	@PutMapping("/customerUpdateById/{id}")
	 public ResponseEntity<CustomerData> updateCustomerById(@RequestBody CustomerData customerData, @PathVariable("id") Long customerId) {
      
		try {
			this.customerService.updateCustomerById(customerData, customerId);
			return ResponseEntity.ok().body(customerData);
		}
		catch(Exception e) {
			 e.printStackTrace();
			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

   }
	
}
