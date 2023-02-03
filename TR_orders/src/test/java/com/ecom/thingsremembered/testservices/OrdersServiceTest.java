//package com.ecom.thingsremembered.testservices;
//
//import java.util.Date;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.thingsremembered.dao.IOrdersRepository;
//import com.thingsremembered.dto.CustomerData;
//import com.thingsremembered.dto.OrdersData;
//import com.thingsremembered.model.Customer;
//import com.thingsremembered.model.Orders;
//import com.thingsremembered.services.CustomerService;
//import com.thingsremembered.services.OrdersServices;
//
//
//
//public class OrdersServiceTest {
//
//	@Autowired
//	private OrdersServices ordersServices;
//	
//	@Autowired
//	private OrdersData ordersData;
//	
//	@Autowired
//	private Orders orders;
//	
//	@Autowired
//	private IOrdersRepository ordersRepository;
//	
//	
//	@Autowired
//	private ProductServices productServices;
//	
//	@Autowired
//	private ProductData productData;
//	
//	@Autowired
//	private CustomerData customerData;
//	
//	@Autowired
//	private CustomerService customerservice;
//
//	@Autowired
//	private Customer customer;
//	
//	 @BeforeEach()
//	    public void beforeEach() {
//	    	Long oId=1l;
//	    	Date orderDate1=new Date();
//	    	CustomerData customerData=customerservice.findById(13l);
//	    	customer =new Customer(customerData.getCustomerId());
//	    	ordersData=new OrdersData(oId,orderDate1,customer);
//	    }
//	 
//	    @Test
//	    public void testCreateOrders() {
//	        Assertions.assertNotNull(ordersServices.create(ordersData));
//	    }
//
//
//	    @Disabled
//	    @Test
//	    public void testFindAllNotNull() {
//	        Assertions.assertNotNull(ordersServices.findAll());
//	    }
//
//	    @Disabled
//	    @Test
//	    public void testFindOneNotNull() {
//	    	ordersData = ordersServices.findById(61l);
//	        Assertions.assertNotNull(orders);
//	        System.out.println("id=6 |" + orders);
//	    }
//
//
//	    @Disabled 
//	    @Test
//	    public void testFindOneAndDelete() {
//	        Assertions.assertTrue(ordersServices.delete(64l));
//	    }
//
//	    @Disabled
//	    @Test
//	    public void testFindOneAndUpdate() {
//	    	Date orderDate=new Date();
//	    	ordersData.setOrderDate(orderDate);
//	        Assertions.assertNotNull(ordersServices.updateOrdersById(ordersData,13l));
//	    }
//	
//}
