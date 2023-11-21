package com.example.matrix151springboot.model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserDto {
    private String phoneNumber;
    private Double balance;
    private String email;
}