package com.thingsremembered.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thingsremembered.dto.OrdersData;
import com.thingsremembered.services.OrdersServices;

@RestController
@RequestMapping("/Orders")

public class OrdersController {

	@Autowired
	private OrdersServices ordersServices;
	
	
	@GetMapping("/getAllOrders")
	public ResponseEntity<List<OrdersData>> findAllOrders() {
		List<OrdersData> list=ordersServices.findAll();
		if(list.size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
		
	}
	
	@GetMapping("/ordersFindById/{id}")
	public ResponseEntity<OrdersData> findById(@PathVariable  Long id) {
		
		OrdersData ordersData =ordersServices.findById(id);
		if(ordersData==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		return ResponseEntity.of(Optional.of(ordersData));
	}
	
	@PostMapping("/ordersCreate")
	public ResponseEntity<OrdersData> create(@RequestBody OrdersData ordersData) {
		OrdersData oIData=null;
		 try {
			 oIData=this.ordersServices.create(ordersData);
			 System.out.println(ordersData);
			 
			 return ResponseEntity.status(HttpStatus.CREATED).build();
		 }
		 catch(Exception e) {
			 e.printStackTrace();
			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		 }
		
		
	}
	
	@DeleteMapping("/ordersDeleteById/{id}")
	public ResponseEntity<Void> deleteOrdersById(@PathVariable Long id) {
		try {
			this.ordersServices.delete(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		catch(Exception e) {
			 e.printStackTrace();
			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}
	
	@PutMapping("//ordersUpdateById/{id}")
	 public ResponseEntity<OrdersData> updateOrdersById(@RequestBody OrdersData ordersData, @PathVariable("id") Long ordersId) {
	      
		try {
			this.ordersServices.updateOrdersById(ordersData, ordersId);
			return ResponseEntity.ok().body(ordersData);
		}
		catch(Exception e) {
			 e.printStackTrace();
			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

  }
}
