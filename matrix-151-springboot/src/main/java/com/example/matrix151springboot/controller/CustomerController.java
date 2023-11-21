package com.example.matrix151springboot.controller;

import com.example.matrix151springboot.model.Customer;
import com.example.matrix151springboot.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/subscriptions")
public class CustomerController {
    private final CustomerService customerService;
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("customer")
    public Customer subscribe(@RequestBody @Valid Customer customer) {
        if (customer.getName() == null || customer.getName().trim().isEmpty()) {

            throw new IllegalArgumentException("Name is required");
        }
        return customerService.saveCustomer(customer);
    }
   @GetMapping("/all")
    public List<Customer> getAllSubscriptions() {
        return customerService.getAllSubscriptions();
    }

}
