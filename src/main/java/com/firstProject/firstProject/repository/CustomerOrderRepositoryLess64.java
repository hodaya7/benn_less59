package com.firstProject.firstProject.repository;

import com.firstProject.firstProject.model.CustomerOrder;

import java.util.List;

public interface CustomerOrderRepositoryLess64 {
    void createCustomerOrder(CustomerOrder customerOrder) throws Exception;
    void updateCustomerOrderById(Long customerOrderId, CustomerOrder customerOrder) throws Exception;
    void deleteCustomerOrder(Long id) throws Exception;
    //less62
    CustomerOrder getCustomerOrderById(Long id);
    List<CustomerOrder> getAllCustomerOrdersByCustomerId(long customerId);
}
