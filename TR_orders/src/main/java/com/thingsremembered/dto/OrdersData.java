package com.thingsremembered.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.thingsremembered.model.Customer;
import com.thingsremembered.model.OrderItem;

public class OrdersData {

    private long orderId;
	private Date orderDate;
	private Customer customer;
	private List<OrderItem> orderItem;

	public OrdersData() {
		super();
		
	}

	public OrdersData(long orderId, Date orderDate, Customer customer, List<OrderItem> orderItem) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.customer = customer;
		this.orderItem = orderItem;
	}

	public OrdersData(Date orderDate, Customer customer, List<OrderItem> orderItem) {
		super();
		this.orderDate = orderDate;
		this.customer = customer;
		this.orderItem = orderItem;
	}
	
	

	public OrdersData(long orderId, Date orderDate, Customer customer) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.customer = customer;
	}

	
	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<OrderItem> getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(List<OrderItem> orderItem) {
		this.orderItem = orderItem;
	}

	@Override
	public String toString() {
		return "OrdersData [orderId=" + orderId + ", orderDate=" + orderDate + ", customer=" + customer + ", orderItem="
				+ orderItem + "]";
	}
	
	
	

	
}
