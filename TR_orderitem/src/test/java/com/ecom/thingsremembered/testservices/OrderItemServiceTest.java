//package com.ecom.thingsremembered.testservices;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.thingsremembered.dao.IOrderItemRepository;
//import com.thingsremembered.dto.OrderItemData;
//import com.thingsremembered.dto.OrdersData;
//import com.thingsremembered.dto.ProductData;
//import com.thingsremembered.model.OrderItem;
//import com.thingsremembered.model.Orders;
//import com.thingsremembered.model.Product;
//import com.thingsremembered.services.OrderItemServices;
//import com.thingsremembered.services.OrdersServices;
//import com.thingsremembered.services.ProductServices;
//
//
//
//public class OrderItemServiceTest {
//
//	@Autowired
//	private OrderItemServices orderItemServices;
//	
//	@Autowired
//	private OrderItemData orderItemData;
//	
//	@Autowired
//	private OrderItem orderItem;
//	
//	
//	@Autowired
//	private ProductData productData;
//	
//	@Autowired
//	private ProductServices productServices;
//	
//	@Autowired
//	private Product product;
//
//	@Autowired
//	private Orders orders;
//	
//	@Autowired
//	private OrdersServices ordersServices;
//	
//	@Autowired
//	private OrdersData ordersData;
//
//	
//	
//	@BeforeEach()
//    public void beforeEach() {
//		Long prodcutId= 1L;
//		productData = productServices.findById(prodcutId);
//		//product=new Product(productData.getProductId());
//		
//        int quantity = 7;
//        //double totalPrice = quantity *  productData.getProductPrice();
//        
//        ordersData=ordersServices.findById(2l);
//       // orders=new Orders(ordersData.getOrderId());
//        
//        orderItemData = new OrderItemData(2l,productData,quantity,ordersData);
//       
//    }
//	
//		
//	    @Test
//	    public void testCreateOrderItem() {
//	        Assertions.assertNotNull(orderItemServices.create(orderItemData));
//	    }
//
//	 
//
//	    @Disabled
//	    @Test
//	    public void testFindAllNotNull() {
//	        Assertions.assertNotNull(orderItemServices.findAll());
//	    }
//
//	 
//
//	    @Disabled
//	    @Test
//	    public void testFindOneNotNull() {
//	    	Long id=61l;
//	    	orderItemData = orderItemServices.findById(id);
//	        Assertions.assertNotNull(orderItemData);
//	        System.out.println("id=6 |" + orderItemData);
//	    }
//
//	 
//
//	    @Disabled 
//	    @Test
//	    public void testFindOneAndDelete() {
//	    	Long id=61l;
//	        Assertions.assertTrue(orderItemServices.delete(id));
//	    }
//
//	 
//
//	    @Disabled
//	    @Test
//	    public void testFindOneAndUpdate() {
//	    	Long id=61l;
//	    	orderItemData.setQuantity(12);;
//	        Assertions.assertNotNull(orderItemServices.updateOrderItemById( orderItemData,id));
//	    }
//}
