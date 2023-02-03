//package com.ecom.thingsremembered.testservices;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//import java.util.List;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import com.thingsremembered.dto.ProductData;
//import com.thingsremembered.services.ProductServices;
//
//@SpringBootTest
//public class ProductServiceJunitMockitoTest {
//
//	@Autowired
//	private ProductServices productServices;
//	
//	@Autowired
//	private ProductData productData;
//	
//	@BeforeEach()
//    public void beforeEach()
//    {
//		productData=new ProductData("HP 15s-Ryzen 3","hp15s.jpg",28800,1,"AMD Ryzen 3 3250U (2.6 GHz base clock(2h)");
//    }
//	
//	@Test
//	@DisplayName("save product data to the database")
//	void Save() {
//		productData=productServices.create(productData);
//		Assertions.assertNotNull(productData);
//		assertThat(productData.getProductId()).isNotEqualTo(null);
//	}
//	
//	@Test
//	@DisplayName("get all product")
//	void getAllProduct() {
//		productServices.create(productData);
//		List<ProductData> listProductData=productServices.findAll();
//		Assertions.assertNotNull(listProductData);
//		assertThat(listProductData).isNotNull();
//		assertEquals(1,listProductData.size());
//	}
//	
//	@Test
//	@DisplayName("get  product by id")
//	void getProductById() {
//		Long id=1l;
//		productData=productServices.findById(id);
//		Assertions.assertNotNull(productData);
//		assertEquals("HP 15s-Ryzen 3",productData.getProductName());
//		
//	}
//	
//	@Test
//	@DisplayName("delete Product By Id")
//	void deleteProductById() {
//		Long id=1l;
//		productData=productServices.findById(id);
//		Assertions.assertNotNull(productData);
//		assertEquals("HP 15s-Ryzen 3",productData.getProductName());
//		
//	}
//}
