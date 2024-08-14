package com.firstProject.firstProject.repository;

import com.firstProject.firstProject.model.Customer;
import com.firstProject.firstProject.model.CustomerStatus;

import java.util.List;

public interface CustomerRepositoryLess61 {
    Long createCustomer(Customer customer);
    void updateCustomerById(Long customerId, Customer customer);
    void deleteCustomer(Long id);
    //less62
    Customer getCustomerById(Long id);
    List<Customer> getCustomersByFirstName(String firatName);
    List<Customer> getAllCustomers();
    List<Long> getCustomersIdsByFirstName(String firstName);
    List<Customer> getAllCustomersByStatus(CustomerStatus status);
}
