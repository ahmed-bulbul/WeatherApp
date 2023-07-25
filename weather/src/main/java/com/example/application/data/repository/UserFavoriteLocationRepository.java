package com.example.application.data.repository;


import com.example.application.data.entity.UserFavoriteLocation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserFavoriteLocationRepository extends JpaRepository<UserFavoriteLocation, Long> {

    List<UserFavoriteLocation> findAllByUser_Username(String username);
    boolean existsByLocationIdAndUser_Username(Long locationId, String username);

    long countByLocationIdAndUser_Username(Long locationId, String username);
    long countByUser_Username(String username);
}
