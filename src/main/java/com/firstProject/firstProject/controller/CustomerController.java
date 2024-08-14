package com.firstProject.firstProject.controller;

import com.firstProject.firstProject.model.Customer;
import com.firstProject.firstProject.service.CustomerServiceLess63;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerServiceLess63 customerService;

    @PostMapping("/customer/create")
    public void createCustomer(@RequestBody Customer customer) throws Exception {
        customerService.createCustomer(customer);
    }
    @PutMapping("/customer/update/{customerId}")
    public void updateCustomerById(@PathVariable Long customerId, @RequestBody Customer customer) throws Exception {
        customerService.updateCustomerById(customerId, customer);
    }
    @DeleteMapping("/customer/delete/{customerId}")
    public void deleteCustomerById(@PathVariable Long customerId) throws Exception {
        customerService.deleteCustomer(customerId);
    }

    //less62
    @GetMapping("/customer/{customerId}")
    public Customer getCustomerById(@PathVariable Long customerId){
            return customerService.getCustomerById(customerId);
    }

    @GetMapping("/customer/all/{firstName}")
    public List<Customer> getCustomersByFirstName(@PathVariable String firstName){//אפשר גם לקבל אותו ברקווסט פאראם ולא בניתוב
        return customerService.getCustomersByFirstName(firstName);
    }

    @GetMapping("/customer/all")
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping("customerId/all/{firstName}")
    public List<Long> getCustomersIdsByFirstName(@PathVariable String firstName){
        return customerService.getCustomersIdsByFirstName(firstName);
    }
}
