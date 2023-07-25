package com.eastnetic.service.service;


import com.eastnetic.service.model.User;
import com.eastnetic.service.model.UserFavoriteLocation;
import com.eastnetic.service.dto.Location;
import com.eastnetic.service.repository.UserFavoriteLocationRepository;
import com.eastnetic.service.security.AuthenticationService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserFavoriteLocationServiceImpl implements UserFavoriteLocationService {

    private final UserFavoriteLocationRepository userFavoriteLocationRepository;
    private final UserService userService;
    private final AuthenticationService authenticationService;

    public UserFavoriteLocationServiceImpl(
            UserFavoriteLocationRepository userFavoriteLocationRepository,
            UserService userService,
            AuthenticationService authenticationService) {
        this.userFavoriteLocationRepository = userFavoriteLocationRepository;
        this.userService = userService;
        this.authenticationService = authenticationService;
    }

    @Override
    public List<UserFavoriteLocation> getFavoriteLocationByUser(String username) {
        return userFavoriteLocationRepository.findAllByUser_Username(username);
    }

    @Override
    public Long saveUserFavoriteLocation(Location location) {
        UserFavoriteLocation favoriteLocation = new UserFavoriteLocation();
        User user = userService.getUser(authenticationService.getLogedInUsername()).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        favoriteLocation.setLocationId(location.getId());
        favoriteLocation.setLatitude(location.getLatitude());
        favoriteLocation.setLongitude(location.getLongitude());
        favoriteLocation.setUser(user);
        String locationDetails = String.format("%s, %s, %s", location.getName(), location.getAdminDetails(), location.getCountry());
        favoriteLocation.setLocationDetails(locationDetails);

        return userFavoriteLocationRepository.save(favoriteLocation).getId();
    }

    @Override
    public void deleteUserFavoriteLocation(Long favLocationId) {
        userFavoriteLocationRepository.deleteById(favLocationId);
    }

    @Override
    public boolean existsByLocationIdAndUsername(Long locationId, String username) {
        return userFavoriteLocationRepository.existsByLocationIdAndUser_Username(locationId, username);
    }

    @Override
    public long countByLocationIdAndUsername(Long locationId, String username) {
        return userFavoriteLocationRepository.countByLocationIdAndUser_Username(locationId, username);
    }

    @Override
    public long countByUsername(String username) {
        return userFavoriteLocationRepository.countByUser_Username(username);
    }
}
