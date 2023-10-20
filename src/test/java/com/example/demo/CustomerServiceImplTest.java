package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.capg.movieapp.dao.CustomerDAO;
import com.capg.movieapp.model.Customer;
import com.capg.movieapp.service.impl.CustomerServiceImpl;

class CustomerServiceImplTest {

    @InjectMocks
    private CustomerServiceImpl customerService;

    @Mock
    private CustomerDAO customerDAO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Initialize mocks
    }

    @Test
    void testAddCustomer() {
        // Create a sample customer for testing
        Customer customer = new Customer();
        customer.setCustomerId("123");
        customer.setCustomerName("John");

        // Mock the behavior of customerDAO.addCustomer()
        when(customerDAO.addCustomer(customer)).thenReturn(customer);

        // Call the service method to add a customer
        Customer result = customerService.addCustomer(customer);

        assertNotNull(result); // Check if the result is not null
        assertEquals("123", result.getCustomerId()); // Check if the ID matches
        assertEquals("John", result.getCustomerName()); // Check if the name matches
    }

//    @Test
//    void testUpdateEmailId() {
//        // Create a sample customer ID for testing
//        String customerId = "123";
//
//        // Create a sample email ID for testing
//        String emailId = "john@example.com";
//
//        // Create a sample customer for testing
//        Customer customer = new Customer();
//        customer.setCustomerId(customerId);
//        // Set other properties of the customer
//
//        // Mock the behavior of customerDAO.updateEmailId()
//        when(customerDAO.updateEmailId(customerId, emailId)).thenReturn(customer);
//
//        // Call the service method to update the email ID of a customer
//        Customer result = customerService.updateEmailId(customerId, emailId);
//
//        assertNotNull(result); // Check if the result is not null
//        assertEquals(customerId, result.getCustomerId()); // Check if the ID matches
//        assertEquals(emailId, result.getEmailId()); // Check if the email ID matches
//        // Add additional assertions based on the expected behavior.
//    }

    @Test
    void testViewAll() {
        // Create a list of sample customers for testing
        List<Customer> customers = new ArrayList<>();
        // Add some sample customers to the list

        // Mock the behavior of customerDAO.viewAll()
        when(customerDAO.viewAll()).thenReturn(customers);

        // Call the service method to get a list of customers
        List<Customer> result = customerService.viewAll();

        assertNotNull(result); // Check if the result is not null
        // Add additional assertions based on the expected behavior.
    }

    @Test
    void testViewCustomerByID() {
        // Create a sample customer ID for testing
        String customerId = "123";

        // Create a sample customer for testing
        Customer customer = new Customer();
        customer.setCustomerId(customerId);
        // Set other properties of the customer

        // Mock the behavior of customerDAO.viewCustomerByID()
        when(customerDAO.viewCustomerByID(customerId)).thenReturn(customer);

        // Call the service method to get a customer by ID
        Customer result = customerService.viewCustomerByID(customerId);

        assertNotNull(result); // Check if the result is not null
        assertEquals(customerId, result.getCustomerId()); // Check if the ID matches
        // Add additional assertions based on the expected behavior.
    }

    // You can write additional test cases as needed

}
