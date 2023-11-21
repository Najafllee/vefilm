package com.example.matrix151springboot.client;
import com.example.matrix151springboot.model.ImdbTop100.MovieDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@FeignClient(name = "imdbTop100ApiClient", url = "https://imdb-top-100-movies.p.rapidapi.com")
public interface ImdbTop100FeignClient {
    @GetMapping
    List<MovieDto> getTopMovies(
            @RequestHeader("X-RapidAPI-Key") String apiKey,
            @RequestHeader("X-RapidAPI-Host") String apiHost
    );
}
