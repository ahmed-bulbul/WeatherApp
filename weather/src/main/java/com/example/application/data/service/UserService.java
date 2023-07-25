package com.example.application.data.service;


import com.example.application.data.entity.User;

import java.util.Optional;

public interface UserService {

    Optional<User> getUser(String username);

    Long getLogedInUserId();
}
