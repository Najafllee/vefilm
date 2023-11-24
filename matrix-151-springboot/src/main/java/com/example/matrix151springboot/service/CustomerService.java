package com.example.matrix151springboot.service;

import com.example.matrix151springboot.model.Customer;
import com.example.matrix151springboot.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerService {
    private final CustomerRepository customerRepository;

    public Customer saveCustomer(Customer customer) {
        log.info("Customer:{}", customer);
        return customerRepository.save(customer);

    }

    public List<Customer> getAllSubscriptions() {
        return customerRepository.findAll();
    }
}
