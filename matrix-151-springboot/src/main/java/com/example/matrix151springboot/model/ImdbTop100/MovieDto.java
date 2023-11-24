package com.example.matrix151springboot.model.ImdbTop100;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDto {
    private Integer rank;
    private String title;
    private String description;
    private String image;
    private List<String> genre;
    private String thumbnail;
    private String rating;
    private String id;
    private Integer year;

}
