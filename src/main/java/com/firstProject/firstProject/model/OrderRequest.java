package com.firstProject.firstProject.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderRequest {
    private int orderId;
    private String orderName;
    @JsonProperty(value = "customer")
    private String customerName;
    private double orderPrice;

    public OrderRequest(int orderId, String orderName, String customerName, double orderPrice) {
        this.orderId = orderId;
        this.orderName = orderName;
        this.customerName = customerName;
        this.orderPrice = orderPrice;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }
}
