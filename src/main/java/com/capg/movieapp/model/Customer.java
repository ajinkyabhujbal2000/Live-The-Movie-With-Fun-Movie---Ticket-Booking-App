package com.capg.movieapp.model;

import java.util.List;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "customer")
public class Customer {
    // Attributes
	
	@Id
	@Column(name = "customer_id") 
    @NotBlank(message = "Provide value for customer_id")
    private String customerId;
	
	@Column(name = "customer_name") 
    @NotBlank(message = "Provide value for customer_name")
    private String customerName;
	
	@Column(name = "contact_number")  
    @Pattern(regexp = "^[6-9]\\d{9}", message = "Contact number is not in the correct format")
    private double contactNumber; 
   
	@Column(name = "email_id")  
	@NotBlank(message = "Provide value for email_id")
	private String emailId;
	
	@Column(name = "city")  
	@NotBlank(message = "Provide value for city")
    private String city;

    // Constructor
	public Customer(){}
    public Customer(String customerId, String customerName, double contactNumber, String emailId, String city)
    {
        this.customerId = customerId;
        this.customerName = customerName;
        this.contactNumber = contactNumber;
        this.emailId = emailId;
        this.city = city;
     //   this.bookingList = bookingList;
    }

    // Getter methods
    public String getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getContactNumber() {
        return contactNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getCity() {
        return city;
    }

    // Setter methods
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setContactNumber(double contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public void setCity(String city) {
        this.city = city;
    }

       }

