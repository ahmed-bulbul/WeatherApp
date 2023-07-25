package com.eastnetic.service.service;

import com.eastnetic.service.entity.UserFavoriteLocation;
import com.eastnetic.service.dto.Location;

import java.util.List;

public interface UserFavoriteLocationService {

    List<UserFavoriteLocation> getFavoriteLocationByUser(String username);
    Long saveUserFavoriteLocation(Location location);

    void deleteUserFavoriteLocation(Long favLocationId);

    boolean existsByLocationIdAndUsername(Long locationId, String username);
    long countByLocationIdAndUsername(Long locationId, String username);
    long countByUsername(String username);
}
