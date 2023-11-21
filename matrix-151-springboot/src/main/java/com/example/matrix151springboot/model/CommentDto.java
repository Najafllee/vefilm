package com.example.matrix151springboot.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {
    private String userName;
    private String message;
   private Long filmId;


}
