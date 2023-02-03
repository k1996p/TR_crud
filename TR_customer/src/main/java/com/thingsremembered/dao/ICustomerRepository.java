package com.thingsremembered.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thingsremembered.model.Customer;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long>{

}
