package com.prince.service;

import com.prince.entity.Customer;

import java.util.List;

public interface CustomerServiceImpl {

    List<Customer> getAllCustomer();

    Customer saveCustomer(Customer customer);

    Customer getCustomerById(Long id);

    Customer updateCustomer(Customer customer);

    void deleteCustomerById(Long id);

    List<Customer> findByKeyword(String keyword);
}
