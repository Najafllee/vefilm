package com.example.matrix151springboot.repositories;

import com.example.matrix151springboot.dao.FilmEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<FilmEntity, Long> {
}
