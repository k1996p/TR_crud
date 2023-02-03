package com.thingsremembered.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Orders")
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long orderId;

	private Date orderDate;

	@OneToOne(cascade = CascadeType.ALL)
	private Customer customer;

	@OneToMany
	private List<OrderItem> orderItem;

	public Orders() {
		super();

	}

	public Orders(long orderId, Date orderDate, Customer customer, List<OrderItem> orderItem) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.customer = customer;
		this.orderItem = orderItem;
	}

	public Orders(Date orderDate, Customer customer, List<OrderItem> orderItem) {
		super();
		this.orderDate = orderDate;
		this.customer = customer;
		this.orderItem = orderItem;
	}

	public Orders(long orderId2) {
		super();
		this.orderId = orderId2;
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
		return "Orders [orderId=" + orderId + ", orderDate=" + orderDate + ", customer=" + customer + ", orderItem="
				+ orderItem + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(orderId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Orders other = (Orders) obj;
		return orderId == other.orderId;
	}

}
