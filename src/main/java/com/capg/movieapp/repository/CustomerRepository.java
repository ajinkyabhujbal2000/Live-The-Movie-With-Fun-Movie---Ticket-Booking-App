package com.capg.movieapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.capg.movieapp.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
    // You can define custom queries here if needed.
}

