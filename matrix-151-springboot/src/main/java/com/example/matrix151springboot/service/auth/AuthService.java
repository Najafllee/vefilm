package com.example.matrix151springboot.service.auth;

import com.example.matrix151springboot.dao.authUser.UserEntity;
import com.example.matrix151springboot.mapper.UserMapper;
import com.example.matrix151springboot.model.authDtos.AuthRequestDto;
import com.example.matrix151springboot.model.authDtos.AuthenticationDto;
import com.example.matrix151springboot.model.authDtos.UserRegisterRequestDto;
import com.example.matrix151springboot.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@SuppressWarnings("all")

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authManager;

    public void register(UserRegisterRequestDto requestDto) {
        var user = UserRegisterRequestDto.builder()
                .phoneNumber(requestDto.getPhoneNumber())
                .password(passwordEncoder.encode(requestDto.getPassword()))
                .roles(requestDto.getRoles())
                .build();

        userRepository.save(UserMapper.mapper.mapRegisterRequestDtoToEntity(user));
    }

    public AuthenticationDto authenticate(AuthRequestDto authRequestDto) {
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authRequestDto.getPhoneNumber(),
                        authRequestDto.getPassword()
                )
        );
        UserEntity user = userRepository.findUserByPhoneNumber(authRequestDto.getPhoneNumber()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationDto.builder()
                .token(jwtToken)
                .build();
    }

    public void deleteUser(Integer userId) {
        log.info("ActionLog.deleteUser.start");
        userRepository.deleteById(userId);
        log.info("ActionLog.deleteUser.end");
    }

    public static UserEntity getUser() {
        return (UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
