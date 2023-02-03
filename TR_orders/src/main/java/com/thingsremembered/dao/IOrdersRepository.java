package com.thingsremembered.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thingsremembered.model.Orders;

public interface IOrdersRepository extends JpaRepository<Orders, Long>{

}
