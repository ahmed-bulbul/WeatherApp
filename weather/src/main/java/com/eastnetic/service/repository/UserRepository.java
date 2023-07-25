package com.eastnetic.service.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.eastnetic.service.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    <T> Optional<T> findByUsername(String username, Class<T> clazz);

    boolean existsByUsername(String username);
}
