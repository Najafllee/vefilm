package com.example.matrix151springboot.controller;

import com.example.matrix151springboot.model.FilmViewDto;
import com.example.matrix151springboot.service.FilmService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vefilm/films")
@RequiredArgsConstructor
public class FilmController {
    private final FilmService filmService;

    @GetMapping
    public List<FilmViewDto> getFilmList() {
        return filmService.getFilmList();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public void addFilm(@RequestBody @Valid FilmViewDto filmViewDto) {
        filmService.addFilm(filmViewDto);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{filmId}")
    public void updateFilm(@PathVariable Long filmId,
                           @RequestBody FilmViewDto filmViewDto) {
        filmService.updateFilm(filmId, filmViewDto);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{filmId}")
    public void deleteFilm(@PathVariable Long filmId) {
        filmService.deleteFilm(filmId);
    }

    @GetMapping("/{filmId}")
    public FilmViewDto getFilm(@PathVariable Long filmId) {
        return filmService.getFilm(filmId);

    }
}
