package com.capg.movieapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.capg.movieapp.model.Customer;
import com.capg.movieapp.service.CustomerService;
import com.capg.movieapp.exception.InvalidEntityException;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/addCustomer")
    public ResponseEntity<Customer> addCustomer(@Validated @RequestBody Customer customer) {
        Customer addedCustomer = customerService.addCustomer(customer);
        return new ResponseEntity<>(addedCustomer, HttpStatus.CREATED);
    }

    @PutMapping("/updateEmailId/{customerId}/{emailId}")
    public ResponseEntity<Customer> updateEmailId(@PathVariable String customerId, @PathVariable String emailId) {
        try {
            Customer updatedCustomer = customerService.updateEmailId(customerId, emailId);
            return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
        } catch (InvalidEntityException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/viewAll")
    public ResponseEntity<List<Customer>> viewAllCustomers() {
        List<Customer> customers = customerService.viewAll();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("/viewCustomerById/{customerId}")
    public ResponseEntity<Customer> viewCustomerById(@PathVariable String customerId) {
        try {
            Customer customer = customerService.viewCustomerByID(customerId);
            return new ResponseEntity<>(customer, HttpStatus.OK);
        } catch (InvalidEntityException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Add other endpoints as per your requirements

    // Example:
    // @GetMapping("/viewCustomerByCity/{city}")
    // public ResponseEntity<List<Customer>> viewCustomersByCity(@PathVariable String city) {
    //     List<Customer> customers = customerService.viewCustomerByCity(city);
    //     return new ResponseEntity<>(customers, HttpStatus.OK);
    // }

    // Handle other exceptions and validations as needed

    @ExceptionHandler(InvalidEntityException.class)
    public ResponseEntity<String> handleInvalidEntityException(InvalidEntityException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}

