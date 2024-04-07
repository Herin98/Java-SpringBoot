package com.webapp.springdemo.service;

import com.webapp.springdemo.entity.Customer;

import java.util.List;

public interface CustomerService {
    public List<Customer> getCustomers();
    public void saveCustomer(Customer theCustomer);

    Customer getCustomer(int theId);

    void delete(int id);
}
