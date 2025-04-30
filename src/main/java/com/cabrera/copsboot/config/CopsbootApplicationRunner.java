package com.cabrera.copsboot.config;

import com.cabrera.copsboot.domain.*;
import com.cabrera.copsboot.repository.*;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class CopsbootApplicationRunner implements ApplicationRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public CopsbootApplicationRunner(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(ApplicationArguments args) {
        if (userRepository.count() == 0) {
            User user = new User(
                new UserId(java.util.UUID.randomUUID()),
                "cabrademontes@gmail.com",
                passwordEncoder.encode("1234"),
                Set.of(UserRole.OFFICER)
            );
            userRepository.save(user);
            System.out.println("usuario de prueba creado cabrademontes@gmail.com");
        }
    }
}