package com.eastnetic.service.it.service;

import com.eastnetic.service.model.User;
import com.eastnetic.service.repository.UserRepository;
import com.eastnetic.service.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UserServiceImplTest {

    @Mock
    private UserRepository userRepositoryMock;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    public void testGetUser_ExistingUser() {
        String username = "testUser";
        User testUser = new User();
        testUser.setUsername(username);
        when(userRepositoryMock.findByUsername(username)).thenReturn(Optional.of(testUser));
        Optional<User> result = userService.getUser(username);

        assertTrue(result.isPresent());
        assertEquals(username, result.get().getUsername());

        verify(userRepositoryMock).findByUsername(username);
    }

    @Test
    public void testGetUser_NonExistingUser() {

        String username = "nonExistingUser";
        when(userRepositoryMock.findByUsername(username)).thenReturn(Optional.empty());
        Optional<User> result = userService.getUser(username);
        assertFalse(result.isPresent());
        verify(userRepositoryMock).findByUsername(username);
    }

}
