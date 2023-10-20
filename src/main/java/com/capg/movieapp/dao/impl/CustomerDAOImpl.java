package com.capg.movieapp.dao.impl;

import com.capg.movieapp.model.Customer;
import com.capg.movieapp.repository.CustomerRepository;
import com.capg.movieapp.dao.CustomerDAO;
import com.capg.movieapp.exception.InvalidEntityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateEmailId(String customerId, String emailId) throws InvalidEntityException 
    {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);

        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            customer.setEmailId(emailId);
            return customerRepository.save(customer);
        } else {
            throw new InvalidEntityException("Customer not found with ID: " + customerId);
        }
    }

    @Override
    public List<Customer> viewAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer viewCustomerByID(String customerId) throws InvalidEntityException {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);

        if (optionalCustomer.isPresent()) {
            return optionalCustomer.get();
        } else 
        {
            throw new InvalidEntityException("Customer not found with ID: " + customerId);
        }
    }

    // Add more methods as per your requirements
}
