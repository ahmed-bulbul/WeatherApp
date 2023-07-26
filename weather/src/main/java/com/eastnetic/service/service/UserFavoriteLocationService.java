package com.eastnetic.service.service;

import com.eastnetic.service.model.UserFavoriteLocation;
import com.eastnetic.service.dto.Location;

import java.util.List;

public interface UserFavoriteLocationService {

    List<UserFavoriteLocation> getFavoriteLocationByUser(String username);
    Long saveUserFavoriteLocation(Location location);

    void deleteUserFavoriteLocation(Long favLocationId);

    boolean existsByLocationIdAndUsername(Long locationId, String username);
}
