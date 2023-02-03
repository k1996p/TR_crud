package com.thingsremembered.dto;

import com.thingsremembered.model.Product;

public class OrderItemData {

	private long itemId;
	private Product product;
	private int quantity;

	public OrderItemData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderItemData(long itemId, Product product, int quantity) {
		super();
		this.itemId = itemId;
		this.product = product;
		this.quantity = quantity;
	}

	public OrderItemData(Product product, int quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
	}

	public long getItemId() {
		return itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "OrderItemData [itemId=" + itemId + ", product=" + product + ", quantity=" + quantity + "]";
	}

}
