package com.firstProject.firstProject.model;

public class CustomerOrderRequest {//less64
    private Customer customer;
    private CustomerOrder customerOrder;

    public CustomerOrderRequest(Customer customer, CustomerOrder customerOrder) {
        this.customer = customer;
        this.customerOrder = customerOrder;
    }

    public Customer getCustomer() {
        return customer;
    }

    public CustomerOrder getCustomerOrder() {
        return customerOrder;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setCustomerOrder(CustomerOrder customerOrder) {
        this.customerOrder = customerOrder;
    }
    public CustomerOrder toCustomerOrder(){// פה מחליטים מה יכנס לדאטה בייס- הפיכה מרקווסט לקסטומר אורדר
        return new CustomerOrder(
                this.customerOrder.getId(),
                this.customer.getId(),
                this.customerOrder.getItemName(),
                this.customerOrder.getPrice(),
                this.customerOrder.getCurrency()
        );
    }
}
