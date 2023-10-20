package com.capg.movieapp.service;

import com.capg.movieapp.model.Customer;
import com.capg.movieapp.exception.InvalidEntityException;

import java.util.List;

public interface CustomerService {

    Customer addCustomer(Customer customer);

    Customer updateEmailId(String customerId, String emailId) throws InvalidEntityException;

    List<Customer> viewAll();

    Customer viewCustomerByID(String customerId) throws InvalidEntityException;

    // Add more methods as per your requirements
}
