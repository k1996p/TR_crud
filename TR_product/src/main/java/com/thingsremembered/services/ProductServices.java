package com.thingsremembered.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thingsremembered.dao.IProductRepository;
import com.thingsremembered.dto.ProductData;
import com.thingsremembered.model.Product;

@Service
public class ProductServices implements IProductServices{

	@Autowired
	private IProductRepository productRepository;

	public Product getProductEntity(ProductData productData) {
		Product product = new Product();
		product.setProductId(productData.getProductId());
		product.setProductName(productData.getProductName());
		product.setProductImage(productData.getProductImage());
		product.setProductPrice(productData.getProductPrice());
		product.setProductQuantity(productData.getProductQuantity());
		product.setProductDescription(productData.getProductDescription());
		return product;
	}


	public ProductData getProductData(Product product) {
		ProductData productData = new ProductData();
		productData.setProductId(product.getProductId());
		productData.setProductName(product.getProductName());
		productData.setProductImage(product.getProductImage());
		productData.setProductPrice(product.getProductPrice());
		productData.setProductQuantity(product.getProductQuantity());
		productData.setProductDescription(product.getProductDescription());

		return productData;
	}
	
	
	@Override
	public List<ProductData> findAll() {
		
		List<ProductData> productDataList=new ArrayList<>();
		List<Product> products=productRepository.findAll();
		products.forEach(product->{productDataList.add(getProductData(product));});
		return productDataList;
	}

	@Override
	public ProductData findById(Long id) {
		
		Optional<Product> productOptional = productRepository.findById(id);
		if (productOptional == null) {
			new EntityNotFoundException("Product Not Found");
		}
		return getProductData(productOptional.get());
	}

	@Override
	public ProductData create(ProductData productData) {
		
		Product product=getProductEntity(productData);
		return getProductData(productRepository.save(product));
	}

	@Override
	public boolean delete(Long id) {
		
		boolean test=findAll().remove(findById(id));
		productRepository.deleteById(id);		
		return test;
	}
	

	
	public ProductData updateProductById(ProductData productData, Long productId) {
		Product product=productRepository.findById(productId).get();
        if(product!=null) {
        	product.setProductName(productData.getProductName());
    		product.setProductImage(productData.getProductImage());
    		product.setProductPrice(productData.getProductPrice());
    		product.setProductQuantity(productData.getProductQuantity());
    		product.setProductDescription(productData.getProductDescription());

        	productRepository.save(product);

            return  getProductData(product);
        }
        else {
            return null;
        }

 

    }


	
}
