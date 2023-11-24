package com.example.matrix151springboot.repositories;

import com.example.matrix151springboot.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
