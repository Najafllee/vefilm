package com.example.matrix151springboot.service;
import com.example.matrix151springboot.repositories.CustomerRepository;
import com.example.matrix151springboot.model.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Customer> getAllSubscriptions() {
        return customerRepository.findAll();
    }
}
