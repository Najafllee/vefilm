package com.example.matrix151springboot.service;

import com.example.matrix151springboot.client.ImdbActorFeignClient;
import com.example.matrix151springboot.model.actorbio.ActorDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ActorService {
    private final ImdbActorFeignClient imdbActorFeignClient;
    @Value("${imdb.api-key}")
    private String key;
    @Value("${imdb.api-host}")
    private String host;

    public ActorDto getActorBio() {

        return imdbActorFeignClient.getActorBio(key, host);
    }

    public ActorDto getActorBioV2(String id) {

        return imdbActorFeignClient.getActorBioV2(key, host, id);
    }
}
