package serviceTests;

import com.lowes3.osp.dao.UserRepository;
import com.lowes3.osp.entity.User;
import com.lowes3.osp.service.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

public class UserServiceImplTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveUser() {
        // Arrange
        User user = new User();
        user.setUserId(1);
        user.setUserName("John");
        when(userRepository.save(any(User.class))).thenReturn(user);

        // Act
        User savedUser = userService.saveUser(user);

        // Assert
        assertNotNull(savedUser);
        assertEquals(user, savedUser);
        verify(userRepository, times(1)).save(user);
    }

    @Test
    void getUserById_existingUserId_shouldReturnUser() {
        // Arrange
        Integer userId = 1;
        User user = new User();
        user.setUserId(1);
        user.setUserName("John");
        when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        // Act
        User retrievedUser = userService.getUserById(userId);

        // Assert
        assertNotNull(retrievedUser);
        assertEquals(user, retrievedUser);
        verify(userRepository, times(1)).findById(userId);
    }

    @Test
    void getUserById_nonExistingUserId_shouldReturnNull() {
        // Arrange
        Integer userId = 2;
        when(userRepository.findById(userId)).thenReturn(Optional.empty());

        // Act
        User retrievedUser = userService.getUserById(userId);

        // Assert
        assertNull(retrievedUser);
        verify(userRepository, times(1)).findById(userId);
    }

    @Test
    void updateUser_existingUser_shouldReturnUpdatedUser() {
        // Arrange
        User user = new User();
        user.setUserId(1);
        user.setUserName("John");
        when(userRepository.existsById(anyInt())).thenReturn(true);
        when(userRepository.save(any(User.class))).thenReturn(user);

        // Act
        User updatedUser = userService.updateUser(user);

        // Assert
        assertNotNull(updatedUser);
        assertEquals(user, updatedUser);
        verify(userRepository, times(1)).existsById(user.getUserId());
        verify(userRepository, times(1)).save(user);
    }

    @Test
    void updateUser_nonExistingUser_shouldReturnNull() {
        // Arrange
        User user = new User();
        user.setUserId(2);
        user.setUserName("Jane");
        when(userRepository.existsById(anyInt())).thenReturn(false);

        // Act
        User updatedUser = userService.updateUser(user);

        // Assert
        assertNull(updatedUser);
        verify(userRepository, times(1)).existsById(user.getUserId());
        verify(userRepository, never()).save(any(User.class));
    }

    @Test
    void deleteUserById_existingUserId_shouldReturnSuccessMessage() {
        // Arrange
        Integer userId = 1;
        when(userRepository.findById(userId)).thenReturn(Optional.of(new User()));

        // Act
        String result = userService.deleteUserById(userId);

        // Assert
        assertEquals("Deleted the User.", result);
        verify(userRepository, times(1)).findById(userId);
        verify(userRepository, times(1)).deleteById(userId);
    }

    @Test
    void deleteUserById_nonExistingUserId_shouldReturnNotFoundMessage() {
        // Arrange
        Integer userId = 2;
        when(userRepository.findById(userId)).thenReturn(Optional.empty());

        // Act
        String result = userService.deleteUserById(userId);

        // Assert
        assertEquals("Could not find User by Id.", result);
        verify(userRepository, times(1)).findById(userId);
        verify(userRepository, never()).deleteById(anyInt());
    }
}
