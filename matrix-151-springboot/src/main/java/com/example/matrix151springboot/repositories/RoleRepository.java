package com.example.matrix151springboot.repositories;

import com.example.matrix151springboot.dao.authUser.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  RoleRepository extends JpaRepository<RoleEntity, Integer> {
}