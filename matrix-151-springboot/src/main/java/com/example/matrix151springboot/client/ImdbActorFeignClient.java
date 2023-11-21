package com.example.matrix151springboot.client;
import com.example.matrix151springboot.model.actorbio.ActorDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
@FeignClient(name = "imdbClient", url = "https://imdb8.p.rapidapi.com")
public interface ImdbActorFeignClient {
    @GetMapping("/actors/get-bio?nconst=nm0001667")
    ActorDto getActorBio(
            @RequestHeader("X-RapidAPI-Key") String apiKey,
            @RequestHeader("X-RapidAPI-Host") String apiHost
    );
}
