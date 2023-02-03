//package com.ecom.thingsremembered.testservices;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import com.thingsremembered.dao.ICustomerRepository;
//import com.thingsremembered.dto.CustomerData;
//import com.thingsremembered.model.Customer;
//import com.thingsremembered.services.CustomerService;
//
//
//
//@SpringBootTest
//public class CustomerServiceTest {
//
//	@Autowired
//	private CustomerService customerService;
//	
//	@Autowired
//	private CustomerData customerData;
//	
//	@Autowired
//	private Customer customer;
//	
//	@Autowired
//	private ICustomerRepository customerRepository;
//	
//	
//	@Disabled
//	@BeforeEach()
//    public void beforeEach()
//    {
//		customerData=new CustomerData("vijay","Thalapathy","vt67@gmail.com","9987199222","NHrd","kerla",332556);
//    }
//   
//	@Disabled
//	@Test
//	public void testCreateProduct() {
//		Assertions.assertNotNull(customerService.create(customerData));
//	}
//	
//	@Disabled
//	 @Test
//	 public void testFindAllNotNull() {
//		 Assertions.assertNotNull(customerService.findAll());
//	 }
//	
//	 @Disabled
//	 @Test
//	 public void testFindOneNotNull() {
//		 Long id=(long) 1;
//		 customerData = customerService.findById(id);
//		 System.out.println("id=1 |" + customerData);
//		
//		 Assertions.assertNotNull(customerData);
//	 }
//	 
//	 @Disabled
//	 @Test
//	 	public void testFindOneAndDelete() {
//		 Assertions.assertFalse(customerService.delete((long) 5));
//	 }
//	 
//	 @Disabled
//	 @Test
//	 public void testFindOneAndUpdate() {
//		 Long id=1l;
//		 customerData.setFirstName("twlight");
//		 Assertions.assertNotNull(customerService.updateCustomerById(customerData, id));
//	 }
//}
