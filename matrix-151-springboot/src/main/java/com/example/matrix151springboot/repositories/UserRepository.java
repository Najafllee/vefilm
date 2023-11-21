package com.example.matrix151springboot.repositories;

import com.example.matrix151springboot.dao.authUser.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Integer>, JpaSpecificationExecutor<UserEntity> {
    Optional<UserEntity> findUserByPhoneNumber(String phoneNumber);
}