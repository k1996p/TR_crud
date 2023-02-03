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

import com.thingsremembered.dto.ProductData;
import com.thingsremembered.model.Product;
import com.thingsremembered.services.ProductServices;

@RestController
@RequestMapping("/Product")
public class ProductController {

	@Autowired
	private ProductServices productService;
	
	@GetMapping("/getAllProduct")
	public ResponseEntity<List<ProductData>> findAllCustomer() {
		List<ProductData> list=productService.findAll();
		if(list.size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
		
	}
	@GetMapping("/productFindId/{id}")
	public ResponseEntity<ProductData> findById(@PathVariable  Long id) {
		
		ProductData productData =productService.findById(id);
		if(productData==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		return ResponseEntity.of(Optional.of(productData));
	}
	@PostMapping("/ProductCreate")
	public ResponseEntity<ProductData> create(@RequestBody ProductData productData) {
		ProductData pData=null;
		 try {
			 pData=this.productService.create(productData);
			 System.out.println(productData);
			 
			 return ResponseEntity.status(HttpStatus.CREATED).build();
		 }
		 catch(Exception e) {
			 e.printStackTrace();
			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		 }
		
		
	}
	@DeleteMapping("/ProductDeleteId/{id}")
	public ResponseEntity<Void> deleteCustomerById(@PathVariable Long id) {
		try {
			this.productService.delete(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		catch(Exception e) {
			 e.printStackTrace();
			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
		
	}
	@PutMapping("/productUpdateById/{id}")
	 public ResponseEntity<ProductData> updateProductById(@RequestBody ProductData productData, @PathVariable("id") Long productId) {
	      
		try {
			this.productService.updateProductById(productData, productId);
			return ResponseEntity.ok().body(productData);
		}
		catch(Exception e) {
			 e.printStackTrace();
			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

   }
}
