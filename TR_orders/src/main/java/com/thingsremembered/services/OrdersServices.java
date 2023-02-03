package com.thingsremembered.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thingsremembered.dao.IOrdersRepository;
import com.thingsremembered.dto.OrdersData;
import com.thingsremembered.model.Customer;
import com.thingsremembered.model.Orders;

@Service
public class OrdersServices {

	@Autowired
	private IOrdersRepository ordersRepository;
	
	public Orders getOrdersEntity(OrdersData ordersData) {

		Orders orders = new Orders();
		orders.setOrderId(ordersData.getOrderId());
		orders.setOrderDate(ordersData.getOrderDate());
		orders.setCustomer(ordersData.getCustomer());
		orders.setOrderItem(ordersData.getOrderItem());
		return orders;

	}

	public OrdersData getOrdersData(Orders orders) {
		OrdersData ordersData = new OrdersData();
		ordersData.setOrderId(orders.getOrderId());
		ordersData.setOrderDate(orders.getOrderDate());
		ordersData.setCustomer(orders.getCustomer());
		ordersData.setOrderItem(orders.getOrderItem());
		return ordersData;
	}

	public List<OrdersData> findAll() {

		List<OrdersData> ordersDataDataList = new ArrayList<>();
		List<Orders> orders1 = ordersRepository.findAll();
		orders1.forEach(orders -> {
			ordersDataDataList.add(getOrdersData(orders));
		});
		return ordersDataDataList;
	}

	public OrdersData findById(Long id) {

		Optional<Orders> ordersOptional = ordersRepository.findById(id);
		if (ordersOptional == null) {
			new EntityNotFoundException("orderIteml Not Found");
		}
		return getOrdersData(ordersOptional.get());
	}

	public OrdersData create(OrdersData ordersData) {

		Orders orders = getOrdersEntity(ordersData);
		return getOrdersData(ordersRepository.save(orders));
	}

	public boolean delete(Long id) {

		boolean test = findAll().remove(findById(id));
		ordersRepository.deleteById(id);
		return test;
	}

	public OrdersData updateOrdersById(OrdersData ordersData, Long ordersId) {
		Orders orders = ordersRepository.findById(ordersId).get();
		if (orders != null) {

			orders.setOrderDate(ordersData.getOrderDate());
			orders.setCustomer(ordersData.getCustomer());

			ordersRepository.save(orders);

			return getOrdersData(orders);
		} else {
			return null;
		}

	}

}
