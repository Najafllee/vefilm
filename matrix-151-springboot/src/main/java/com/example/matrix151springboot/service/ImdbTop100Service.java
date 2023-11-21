package com.example.matrix151springboot.service;
import com.example.matrix151springboot.client.ImdbTop100FeignClient;
import com.example.matrix151springboot.model.ImdbTop100.MovieDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ImdbTop100Service {
 private final ImdbTop100FeignClient imdbTop100FeignClient;
    String key = "d50cb67c32msha4a69732f6f3e6fp169b0fjsn556819616184";
    String host = "imdb-top-100-movies.p.rapidapi.com";

    public List<MovieDto> getTop100Movies() {
     return imdbTop100FeignClient.getTopMovies(key,host);
    }

}