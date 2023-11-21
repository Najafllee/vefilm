package com.example.matrix151springboot.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SeriesViewDto {
    private Long id;
    @NotNull
    private String nameOfSeries;
    @NotNull
    private String partOfSeries;
    private LocalDate originDate;
    private LocalDateTime createAt;
    private List<CommentDto> comments;
}

