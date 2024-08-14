package com.firstProject.firstProject.service;

import com.firstProject.firstProject.model.Customer;

import java.util.List;

public interface CustomerServiceLess63 {
    Long createCustomer(Customer customer) throws Exception;
    void updateCustomerById(Long customerId, Customer customer) throws Exception;
    void deleteCustomer(Long id) throws Exception;
    //less62
    Customer getCustomerById(Long id);
    List<Customer> getCustomersByFirstName(String firstName);
    List<Customer> getAllCustomers();
    List<Long> getCustomersIdsByFirstName(String firstName);
}
