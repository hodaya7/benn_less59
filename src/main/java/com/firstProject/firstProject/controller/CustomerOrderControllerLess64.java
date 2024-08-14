package com.firstProject.firstProject.controller;

import com.firstProject.firstProject.model.CustomerOrder;
import com.firstProject.firstProject.model.CustomerOrderRequest;
import com.firstProject.firstProject.model.CustomerOrderResponse;
import com.firstProject.firstProject.service.CustomerOrderServiceLess64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerOrderControllerLess64 {
    @Autowired
    CustomerOrderServiceLess64 customerOrderService;

    @PostMapping("/customerOrder/create")
    public CustomerOrderResponse createCustomerOrder(@RequestBody CustomerOrderRequest customerOrderRequest) throws Exception {
        return customerOrderService.createCustomerOrder(customerOrderRequest);
    }
    @PutMapping("/customerOrder/update/{customerOrderId}")
    public void updateCustomerOrderById(@PathVariable Long customerOrderId, @RequestBody CustomerOrder customerOrder) throws Exception {
        customerOrderService.updateCustomerOrderById(customerOrderId, customerOrder);
    }
    @DeleteMapping("/customerOrder/delete/{customerOrderId}")
    public void deleteCustomerOrderById(@PathVariable Long customerOrderId) throws Exception {
        customerOrderService.deleteCustomerOrder(customerOrderId);
    }

    //less62
    @GetMapping("/customerOrder/{customerOrderId}")
    public CustomerOrder getCustomerOrderById(@PathVariable Long customerOrderId){
        return customerOrderService.getCustomerOrderById(customerOrderId);
    }
}
