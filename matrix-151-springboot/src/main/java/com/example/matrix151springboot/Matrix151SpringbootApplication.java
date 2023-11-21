package com.example.matrix151springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Matrix151SpringbootApplication {
    public static void main(String[] args) {
        SpringApplication.run(Matrix151SpringbootApplication.class, args);
    }
}
