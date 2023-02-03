//package com.ecom.thingsremembered.testservices;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.BeforeAll;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import com.thingsremembered.dao.IProductRepository;
//import com.thingsremembered.dto.ProductData;
//import com.thingsremembered.model.Product;
//import com.thingsremembered.services.ProductServices;
//
//@SpringBootTest
//public class ProductServiceTest {
//
//	@Autowired
//	private ProductServices productServices;
//	
//	@Autowired
//	private ProductData productData;
//	
//	@Autowired
//	private Product product;
//	
//	@Autowired
//	private IProductRepository productRepository;
//	
//	@BeforeAll
//	static void beforeAll() {
//		System.out.println("@BeforeAll");
//	}
//	
//	@Disabled
//	@BeforeEach()
//    public void beforeEach()
//    {
//		productData=new ProductData("Lenova","lenova01.jpg",35000,1,"Lenova market new edition");
//    }
//   
//	@Disabled
//	@Test
//	public void testCreateProduct() {
//		Assertions.assertNotNull(productServices.create(productData));
//	}
//	
//	@Disabled
//	 @Test
//	 public void testFindAllNotNull() {
//		 Assertions.assertNotNull(productServices.findAll());
//	 }
//	
//	 @Disabled
//	 @Test
//	 public void testFindOneNotNull() {
//		 Long id=(long) 1;
//		 productData = productServices.findById(id);
//		 System.out.println("id=1 |" + productData);
//		
//		 Assertions.assertNotNull(productData);
//	 }
//	 
//	 @Disabled
//	 @Test
//	 	public void testFindOneAndDelete() {
//		 Assertions.assertFalse(productServices.delete((long) 5));
//	 }
//	 
//	 @Disabled
//	 @Test
//	 public void testFindOneAndUpdate() {
//		 Long id=1l;
//		 productData.setProductName("HP new123");
//		 Assertions.assertNotNull(productServices.updateProductById(productData, id));
//	 }
//}
