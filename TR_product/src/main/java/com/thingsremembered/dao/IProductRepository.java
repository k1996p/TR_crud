package com.thingsremembered.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thingsremembered.model.Product;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {

}
