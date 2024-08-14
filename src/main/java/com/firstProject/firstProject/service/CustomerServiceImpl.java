package com.firstProject.firstProject.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.firstProject.firstProject.model.Customer;
import com.firstProject.firstProject.model.CustomerStatus;
import com.firstProject.firstProject.repository.CustomerRepositoryLess61;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerServiceLess63 {
    private static int ALLOWED_VIP_CUSTOMERS_CNT= 10;//אם יש לנו מלא קבועים ונירצה שהם יהיו משומשים על ידי כל מיני מקומות נוכל ליצור מחלקה שתכיל את הכל הקבועים
    @Autowired
    CustomerRepositoryLess61 customerRepository;
    @Autowired
    ObjectMapper objectMapper;//less63 משמש להפוך אובייקט למחרוזת ולהפך


    @Override
    public Long createCustomer(Customer customer) throws Exception {//יצירה עד עשר וי איי פי
        //הפיכה מאובייקט לסטרינג גייסון
        String customerAsString = objectMapper.writeValueAsString(customer);
        System.out.println("customerAsString: " + customerAsString);//עוזר להדפיס את הגייסון שהכנסנו
        Customer customerFromString = objectMapper.readValue(customerAsString, Customer.class);//חזרה מגייסון לאובייקט
        System.out.println("customerFromString: " + customerFromString);
        if (customer.getStatus() == CustomerStatus.VIP) {
            if (isAllowVip())
                return customerRepository.createCustomer(customer);
            else
                throw new Exception("cant create new customer with VIP status, out if limit");
        } else
            return customerRepository.createCustomer(customer);

    }

    @Override
    public void updateCustomerById(Long customerId, Customer customer) throws Exception {
        if (customer.getStatus() == CustomerStatus.VIP && customerRepository.getCustomerById(customerId).getStatus() == CustomerStatus.REGULAR) {
            if (isAllowVip())
                customerRepository.updateCustomerById(customerId, customer);
            else
                throw new Exception("cant update customer to VIP status, out if limit");
        } else
            customerRepository.updateCustomerById(customerId, customer);
    }

    @Override
    public void deleteCustomer(Long id) throws Exception {
        if (customerRepository.getCustomerById(id) != null)
            customerRepository.deleteCustomer(id);
        else
            throw new Exception("customer is not exists");
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerRepository.getCustomerById(id);
    }

    @Override
    public List<Customer> getCustomersByFirstName(String firstName) {
        return customerRepository.getCustomersByFirstName(firstName);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.getAllCustomers();
    }

    @Override
    public List<Long> getCustomersIdsByFirstName(String firstName) {
        return customerRepository.getCustomersIdsByFirstName(firstName);
    }

    private boolean isAllowVip() {
        List<Customer> vipCustomers = customerRepository.getAllCustomersByStatus(CustomerStatus.VIP);//או לבדוק customer.getStatus() אם אנחנו בתוך הפונקציה שלמעלה==
        return vipCustomers.size() < ALLOWED_VIP_CUSTOMERS_CNT;
    }
}
