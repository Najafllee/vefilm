package com.example.matrix151springboot.controller.auth;

import com.example.matrix151springboot.model.authDtos.AuthRequestDto;
import com.example.matrix151springboot.model.authDtos.AuthenticationDto;
import com.example.matrix151springboot.model.authDtos.UserRegisterRequestDto;
import com.example.matrix151springboot.service.auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;


    @PostMapping("/register")
    public void register(
            @RequestBody UserRegisterRequestDto requestDto
    ) {
        authService.register(requestDto);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationDto> login(
            @RequestBody AuthRequestDto authRequestDto
    ) {
        return ResponseEntity.ok(authService.authenticate(authRequestDto));
    }

    @DeleteMapping("/user/{userId}")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public void deleteUser(@PathVariable Integer userId) {
        authService.deleteUser(userId);
    }
}
