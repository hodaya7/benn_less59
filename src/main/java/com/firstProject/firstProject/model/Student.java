package com.firstProject.firstProject.model;

public class Student {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private StudentPaymentMethod paymentMethod;

    public Student(Long id, String firstName, String lastName, String email, StudentPaymentMethod paymentMethod) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.paymentMethod = paymentMethod;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public StudentPaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPaymentMethod(StudentPaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
