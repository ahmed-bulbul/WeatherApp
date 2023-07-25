package com.example.application.data.service;

import com.example.application.data.entity.User;

import com.example.application.data.dto.UserIdProjection;
import com.example.application.data.repository.UserRepository;
import com.example.application.security.AuthenticationService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final AuthenticationService authenticationService;
    private final UserRepository userRepository;

    public UserServiceImpl(
            AuthenticationService authenticationService,
            UserRepository userRepository
    ) {
        this.authenticationService = authenticationService;
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> getUser(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Long getLogedInUserId() {
        UserDetails user = authenticationService.getAuthenticatedUser()
                .orElseThrow(() -> new UsernameNotFoundException("No logedIn user found"));
        return userRepository.findByUsername(user.getUsername(), UserIdProjection.class)
                .map(UserIdProjection::getId)
                .orElse(0l);
    }
}
