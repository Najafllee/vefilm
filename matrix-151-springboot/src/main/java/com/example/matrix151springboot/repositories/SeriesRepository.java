package com.example.matrix151springboot.repositories;
import com.example.matrix151springboot.dao.SeriesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
public interface SeriesRepository extends JpaRepository<SeriesEntity, Long> {
}
