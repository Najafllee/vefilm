package com.example.matrix151springboot.controller;

import com.example.matrix151springboot.model.ImdbTop100.MovieDto;
import com.example.matrix151springboot.service.ImdbTop100Service;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/films")
@RequiredArgsConstructor
public class ImdbTop100Controller {
    private final ImdbTop100Service imdbTop100Service;

    @GetMapping
    public List<MovieDto> getFilms() {
        return imdbTop100Service.getTop100Movies();
    }
}
