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

import com.thingsremembered.dto.OrderItemData;
import com.thingsremembered.services.OrderItemServices;

@RestController
@RequestMapping("/OrderItem")
public class OrderItemController {

	@Autowired
	private OrderItemServices orderItemServices;
	
	
	@GetMapping("/getAllOrderItem")
	public ResponseEntity<List<OrderItemData>> findAllOrderItem() {
		List<OrderItemData> list=orderItemServices.findAll();
		if(list.size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
		
	}
	
	@GetMapping("/orderItemFindById/{id}")
	public ResponseEntity<OrderItemData> findById(@PathVariable  Long id) {
		
		OrderItemData orderItemData =orderItemServices.findById(id);
		if(orderItemData==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		return ResponseEntity.of(Optional.of(orderItemData));
	}
	
	@PostMapping("/orderItemCreate")
	public ResponseEntity<OrderItemData> create(@RequestBody OrderItemData orderItemData) {
		OrderItemData oIData=null;
		 try {
			 oIData=this.orderItemServices.create(orderItemData);
			 System.out.println(orderItemData);
			 
			 return ResponseEntity.status(HttpStatus.CREATED).build();
		 }
		 catch(Exception e) {
			 e.printStackTrace();
			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		 }
		
		
	}
	
	@DeleteMapping("/orderItemDeleteById/{id}")
	public ResponseEntity<Void> deleteOrderItemById(@PathVariable Long id) {
		try {
			this.orderItemServices.delete(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		catch(Exception e) {
			 e.printStackTrace();
			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}
	
	@PutMapping("/productUpdateById/{id}")
	 public ResponseEntity<OrderItemData> updateOrderItemById(@RequestBody OrderItemData orderItemData, @PathVariable("id") Long orderItemId) {
	      
		try {
			this.orderItemServices.updateOrderItemById(orderItemData, orderItemId);
			return ResponseEntity.ok().body(orderItemData);
		}
		catch(Exception e) {
			 e.printStackTrace();
			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

  }
}
