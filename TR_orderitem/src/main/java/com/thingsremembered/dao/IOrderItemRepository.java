package com.thingsremembered.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thingsremembered.model.OrderItem;

public interface IOrderItemRepository extends JpaRepository<OrderItem, Long> {

}
