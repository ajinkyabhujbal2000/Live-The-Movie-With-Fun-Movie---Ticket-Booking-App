package com.capg.movieapp.service.impl;

import com.capg.movieapp.model.Customer;
import com.capg.movieapp.exception.InvalidEntityException;
import com.capg.movieapp.dao.CustomerDAO;
import com.capg.movieapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerDAO customerDAO;

    @Autowired
    public CustomerServiceImpl(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Override
    public Customer addCustomer(Customer customer) {
        return customerDAO.addCustomer(customer);
    }

    @Override
    public Customer updateEmailId(String customerId, String emailId) throws InvalidEntityException {
        return customerDAO.updateEmailId(customerId, emailId);
    }

    @Override
    public List<Customer> viewAll() {
        return customerDAO.viewAll();
    }

    @Override
    public Customer viewCustomerByID(String customerId) throws InvalidEntityException {
        return customerDAO.viewCustomerByID(customerId);
    }

    // Add more methods as per your requirements
}
