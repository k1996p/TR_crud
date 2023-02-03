package com.thingsremembered.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thingsremembered.dao.ICustomerRepository;
import com.thingsremembered.dto.CustomerData;
import com.thingsremembered.model.Customer;


@Service
public class CustomerService implements ICustomerService{

	@Autowired
	private ICustomerRepository customerRepository;

	
	private Customer getCustomerEntity(CustomerData customerData) {
		Customer customer = new Customer();
		customer.setCustomerId(customerData.getCustomerId());
		customer.setFirstName(customerData.getFirstName());
		customer.setLastName(customerData.getLastName());
		customer.setEmail(customerData.getEmail());
		customer.setMobile(customerData.getMobile());
		customer.setAddress(customerData.getAddress());
		customer.setCity(customerData.getCity());
		customer.setPincode(customerData.getPincode());
		return customer;
	}


	private CustomerData getCustomerData(Customer customer) {
		CustomerData customerData = new CustomerData();
		
		customerData.setCustomerId(customer.getCustomerId());
		customerData.setFirstName(customer.getFirstName());
		customerData.setLastName(customer.getLastName());
		customerData.setEmail(customer.getEmail());
		customerData.setMobile(customer.getMobile());
		customerData.setAddress(customer.getAddress());
		customerData.setCity(customer.getCity());
		customerData.setPincode(customer.getPincode());

		return customerData;
	}
	
	
	public List<CustomerData> findAll() {
		
		List<CustomerData> customerDataList=new ArrayList<>();
		List<Customer> customers=customerRepository.findAll();
		customers.forEach(customer->{customerDataList.add(getCustomerData(customer));});
		return customerDataList;
	}


	public CustomerData findById(Long id) {
		
		Optional<Customer> customerOptional = customerRepository.findById(id);
		if (customerOptional == null) {
			new EntityNotFoundException("customer Not Found");
		}
		return getCustomerData(customerOptional.get());
	}

	
	public CustomerData create(CustomerData customerData) {
		
		Customer customer=getCustomerEntity(customerData);
		return getCustomerData(customerRepository.save(customer));
	}

	
	public boolean delete(Long id) {
		
		boolean test=findAll().remove(findById(id));
		customerRepository.deleteById(id);		
		return test;
	}
	//added
	public CustomerData updateCustomerById(CustomerData customerData, Long customerId) {
		Customer customer=customerRepository.findById(customerId).get();
        if(customer!=null) {
        	customer.setFirstName(customerData.getFirstName());
    		customer.setLastName(customerData.getLastName());
    		customer.setEmail(customerData.getEmail());
    		customer.setMobile(customerData.getMobile());
    		customer.setAddress(customerData.getAddress());
    		customer.setCity(customerData.getCity());
    		customer.setPincode(customerData.getPincode());

    		customerRepository.save(customer);

            return  getCustomerData(customer);
        }
        else {
            return null;
        }

 

    }
}
