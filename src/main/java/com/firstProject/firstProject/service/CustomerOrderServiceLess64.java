package com.firstProject.firstProject.service;

import com.firstProject.firstProject.model.Customer;
import com.firstProject.firstProject.model.CustomerOrder;
import com.firstProject.firstProject.model.CustomerOrderRequest;
import com.firstProject.firstProject.model.CustomerOrderResponse;

import java.util.List;

public interface CustomerOrderServiceLess64 {
    CustomerOrderResponse createCustomerOrder(CustomerOrderRequest customerOrderRequest) throws Exception;
    void updateCustomerOrderById(Long customerOrderId, CustomerOrder customerOrder) throws Exception;
    void deleteCustomerOrder(Long id) throws Exception;
    //less62
    CustomerOrder getCustomerOrderById(Long id);
}
