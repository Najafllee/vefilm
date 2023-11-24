package com.example.matrix151springboot.controller;

import com.example.matrix151springboot.model.actorbio.ActorDto;
import com.example.matrix151springboot.service.ActorService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/vefilm/actors")
public class ActorController {
    private final ActorService actorService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public ActorDto getActor() {

        return actorService.getActorBio();
    }


    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/bio/{id}")
    public ActorDto getActorBio(@PathVariable("id") String id) {
        return actorService.getActorBioV2(id);
    }
}
