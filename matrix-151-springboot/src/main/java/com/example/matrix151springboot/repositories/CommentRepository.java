package com.example.matrix151springboot.repositories;

import com.example.matrix151springboot.dao.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<CommentEntity,Long> {
}
