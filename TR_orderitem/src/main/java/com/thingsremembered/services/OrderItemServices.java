package com.thingsremembered.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thingsremembered.dao.IOrderItemRepository;
import com.thingsremembered.dto.OrderItemData;
import com.thingsremembered.model.OrderItem;

@Service
public class OrderItemServices {

	@Autowired
	private IOrderItemRepository orderItemRepository;
	
	public OrderItem getOrderItemEntity(OrderItemData orderItemData) {
		
		OrderItem orderItem=new OrderItem();
		orderItem.setItemId(orderItemData.getItemId());
		orderItem.setProduct(orderItemData.getProduct());
		orderItem.setQuantity(orderItemData.getQuantity());
		
		return orderItem;
		

	}
	
	public OrderItemData getOrderItemData(OrderItem orderItem) {
		OrderItemData orderItemData = new OrderItemData();
		
		orderItemData.setItemId(orderItem.getItemId());
		orderItemData.setProduct(orderItem.getProduct());
		orderItemData.setQuantity(orderItem.getQuantity());
		
		return orderItemData;
	}
	
	public List<OrderItemData> findAll() {
		
		List<OrderItemData> orderItemDataDataList=new ArrayList<>();
		List<OrderItem> orderItems=orderItemRepository.findAll();
		orderItems.forEach(orderItem->{orderItemDataDataList.add(getOrderItemData(orderItem));});
		return orderItemDataDataList;
	}
	
	public OrderItemData findById(Long id) {
		
		Optional<OrderItem> orderItemOptional = orderItemRepository.findById(id);
		if (orderItemOptional == null) {
			new EntityNotFoundException("orderItemDataOptionalorderItemDataOptional Not Found");
		}
		return getOrderItemData(orderItemOptional.get());
	}
	

	public OrderItemData create(OrderItemData orderItemData) {
		
		OrderItem orderItem=getOrderItemEntity(orderItemData);
		return getOrderItemData(orderItemRepository.save(orderItem));
	}
	
	public boolean delete(Long id) {
		
		boolean test=findAll().remove(findById(id));
		orderItemRepository.deleteById(id);		
		return test;
	}
	
	public OrderItemData updateOrderItemById(OrderItemData orderItemData, Long orderItemId) {
		OrderItem orderItem=orderItemRepository.findById(orderItemId).get();
        if(orderItem!=null) {
        	
        	orderItem.setProduct(orderItemData.getProduct());
    		orderItem.setQuantity(orderItemData.getQuantity());
    		

    		orderItemRepository.save(orderItem);

            return  getOrderItemData(orderItem);
        }
        else {
            return null;
        }

 

    }

}
