package com.example.spring_security2.Bootstrap;


import com.example.spring_security2.model.Role;
import com.example.spring_security2.model.User;
import com.example.spring_security2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class Bootstrap implements CommandLineRunner {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public void run(String... args) throws Exception {

        User erfan = User.builder()
                .username("erfan")
                .password(passwordEncoder.encode("test123"))
                .roles(Set.of(Role.STUDENT))
                .isEnabled(true)
                .build();
        User admin = User.builder()
                .username("admin")
                .password(passwordEncoder.encode("test123"))
                .roles(Set.of(Role.ADMIN ))
                .isEnabled(true)
                .build();

        userRepository.saveAll(List.of(admin,erfan));

    }
}
