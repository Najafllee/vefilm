package com.example.matrix151springboot.controller;

import com.example.matrix151springboot.model.SeriesViewDto;
import com.example.matrix151springboot.service.SeriesService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vefilm/series")
@RequiredArgsConstructor
public class SeriesController {
    private final SeriesService seriesService;

    @GetMapping
    public List<SeriesViewDto> getSeriesList() {

        return seriesService.getSeriesList();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addSeries(@RequestBody @Valid SeriesViewDto seriesViewDto) {
        seriesService.addSeries(seriesViewDto);

    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{seriesId}")
    public void updateSeries(@PathVariable Long seriesId,
                             @RequestBody SeriesViewDto seriesViewDto) {
        seriesService.updateSeries(seriesId, seriesViewDto);

    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{seriesId}")
    public void deleteSeries(@PathVariable Long seriesId) {
        seriesService.deleteSeries(seriesId);
    }

    @GetMapping("/{seriesId}")
    public SeriesViewDto getSeries(@PathVariable Long seriesId) {
        return seriesService.getSeries(seriesId);

    }
}
