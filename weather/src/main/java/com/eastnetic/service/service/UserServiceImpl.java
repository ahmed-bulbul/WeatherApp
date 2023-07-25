package com.eastnetic.service.service;

import com.eastnetic.service.model.User;

import com.eastnetic.service.dto.UserIdProjection;
import com.eastnetic.service.repository.UserRepository;
import com.eastnetic.service.security.AuthenticationService;
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
