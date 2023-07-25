package com.eastnetic.service.service;


import com.eastnetic.service.entity.User;

import java.util.Optional;

public interface UserService {

    Optional<User> getUser(String username);

    Long getLogedInUserId();
}
