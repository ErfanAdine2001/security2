package com.example.spring_security2.service;

import com.example.spring_security2.model.CustomeUserDetail;
import com.example.spring_security2.model.User;
import com.example.spring_security2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserManagement implements UserDetailsService {

    private final UserRepository userRepository ;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("not found user with username:" + username));

        return new CustomeUserDetail(user);
    }
}
