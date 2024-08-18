package com.firstProject.firstProject.service;

import com.firstProject.firstProject.model.Customer;
import com.firstProject.firstProject.model.CustomerOrder;
import com.firstProject.firstProject.model.CustomerOrderRequest;
import com.firstProject.firstProject.model.CustomerOrderResponse;
import com.firstProject.firstProject.repository.CustomerOrderRepositoryLess64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerOrderServiceImpl implements CustomerOrderServiceLess64 {
    @Autowired
    CustomerOrderRepositoryLess64 customerOrderRepository;
    @Autowired
    CustomerServiceLess63 customerService;//בין סרביסים נשתמש בסרביס ולא רפוזיטורי

    @Override
    public CustomerOrderResponse createCustomerOrder(CustomerOrderRequest customerOrderRequest) throws Exception {
        Customer selectedCustomer = customerOrderRequest.getCustomer();
        Customer customerForResponse = null;
        if (selectedCustomer != null) {//אם הוכנס לקוח
            if (selectedCustomer.getId() != null) {//אם יש איי די
                Customer existingCustomer = customerService.getCustomerById(selectedCustomer.getId());
                if (existingCustomer != null) {//ניצור הזמנה ונשייך ללקוח כי יש לקוח עם מזהה כזה
                    customerOrderRepository.createCustomerOrder(customerOrderRequest.toCustomerOrder());
                    customerForResponse = existingCustomer;
                } else {//אין לקוח עם מזהה כזה
                    throw new Exception("cant create customerOrder with non existing customer id:  " + selectedCustomer.getId());
                }
            } else {//נכניס לקוח חדש למערכת
                Long createdCustomerId = customerService.createCustomer(selectedCustomer);
                CustomerOrder customerOrderToCreate = customerOrderRequest.toCustomerOrder();
                customerOrderToCreate.setCustomerId(createdCustomerId);//מעדכן איי די לאחר היצירה
                customerOrderRepository.createCustomerOrder(customerOrderToCreate);
                customerForResponse = customerService.getCustomerById(createdCustomerId);
            }

        } else
            throw new Exception("cant create customerOrder with customer null");

        List<CustomerOrder> customerOrderList = customerOrderRepository.getAllCustomerOrdersByCustomerId(customerForResponse.getId());
        CustomerOrderResponse customerOrderResponse = customerOrderRequest.getCustomerOrder().toCustomerOrderResponse(customerForResponse, customerOrderList);

        return customerOrderResponse;
    }

    @Override
    public void updateCustomerOrderById(Long customerOrderId, CustomerOrder customerOrder) throws Exception {
        customerOrderRepository.updateCustomerOrderById(customerOrderId, customerOrder);
    }

    @Override
    public void deleteCustomerOrder(Long id) throws Exception {
        customerOrderRepository.deleteCustomerOrder(id);
    }

    @Override
    public CustomerOrder getCustomerOrderById(Long id) {
        return customerOrderRepository.getCustomerOrderById(id);
    }
}
