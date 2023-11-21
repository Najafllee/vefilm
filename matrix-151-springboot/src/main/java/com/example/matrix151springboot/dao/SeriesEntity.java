package com.example.matrix151springboot.dao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
@Entity
@Table(name = "series")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SeriesEntity {
    @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameOfSeries;
    private String partOfSeries;
    private LocalDate originDate;
    @OneToMany(mappedBy = "seriesEntity", cascade = CascadeType.ALL)
    private List<CommentEntity> comments;
    @CreationTimestamp
    private LocalDateTime createAt;
    @UpdateTimestamp
    private LocalDateTime updateAt;
    @ManyToMany(mappedBy = "watchedSeries")
    private List<PersonEntity> viewers;
}
