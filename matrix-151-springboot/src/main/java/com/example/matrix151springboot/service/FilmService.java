package com.example.matrix151springboot.service;

import com.example.matrix151springboot.exception.NotFoundException;
import com.example.matrix151springboot.mapper.FilmMapper;
import com.example.matrix151springboot.model.FilmViewDto;
import com.example.matrix151springboot.repositories.FilmRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class FilmService {
    private final FilmRepository filmRepository;
    private final FilmMapper filmMapper;

    public List<FilmViewDto> getFilmList() {
        var filmEntityList = filmRepository.findAll();
        return filmEntityList.stream().map(filmMapper::entityToDto).collect(Collectors.toList());

    }

    public void addFilm(FilmViewDto filmViewDto) {
        log.info("FilmViewDto:{}",filmViewDto);
        var filmEntity = filmMapper.dtoToEntity(filmViewDto);
        log.info("FilmEntity:{}",filmEntity);
        filmRepository.save(filmEntity);

    }

    public void updateFilm(Long filmId, FilmViewDto filmViewDto) {
        var filmEntity = filmMapper.dtoToEntity(filmId, filmViewDto);
        filmRepository.save(filmEntity);
    }

    public void deleteFilm(Long filmId) {
        filmRepository.deleteById(filmId);
    }

    public FilmViewDto getFilm(Long filmId) {
        var filmEntity = filmRepository.findById(filmId).orElseThrow(() -> new NotFoundException("FIlM_NOT_FOUND"));
        return filmMapper.entityToDto(filmEntity);
    }
}




