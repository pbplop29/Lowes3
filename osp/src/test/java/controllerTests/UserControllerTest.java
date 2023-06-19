package controllerTests;

import com.lowes3.osp.controller.UserController;
import com.lowes3.osp.entity.User;
import com.lowes3.osp.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class UserControllerTest {
    private MockMvc mockMvc;

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    void saveUser() throws Exception {
        User user = new User();
        user.setUserId(1);
        user.setUserEmailAddress("test@example.com");
        user.setUserName("TestUser");
        user.setUserPassword("password");

        when(userService.saveUser(any(User.class))).thenReturn(user);

        mockMvc.perform(post("/saveUser")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"userId\": 1, \"userEmailAddress\": \"test@example.com\", \"userName\": \"TestUser\", \"userPassword\": \"password\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userId").value(1))
                .andExpect(jsonPath("$.userEmailAddress").value("test@example.com"))
                .andExpect(jsonPath("$.userName").value("TestUser"))
                .andExpect(jsonPath("$.userPassword").value("password"));

        verify(userService, times(1)).saveUser(any(User.class));
    }

    @Test
    void getUserById() throws Exception {
        User user = new User();
        user.setUserId(1);
        user.setUserEmailAddress("test@example.com");
        user.setUserName("TestUser");
        user.setUserPassword("password");

        when(userService.getUserById(1)).thenReturn(user);

        mockMvc.perform(get("/getUser/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userId").value(1))
                .andExpect(jsonPath("$.userEmailAddress").value("test@example.com"))
                .andExpect(jsonPath("$.userName").value("TestUser"))
                .andExpect(jsonPath("$.userPassword").value("password"));

        verify(userService, times(1)).getUserById(1);
    }

    @Test
    void updateUser() throws Exception {
        User user = new User();
        user.setUserId(1);
        user.setUserEmailAddress("test@example.com");
        user.setUserName("TestUser");
        user.setUserPassword("password");

        when(userService.updateUser(any(User.class))).thenReturn(user);

        mockMvc.perform(put("/updateUser")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"userId\": 1, \"userEmailAddress\": \"test@example.com\", \"userName\": \"TestUser\", \"userPassword\": \"password\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userId").value(1))
                .andExpect(jsonPath("$.userEmailAddress").value("test@example.com"))
                .andExpect(jsonPath("$.userName").value("TestUser"))
                .andExpect(jsonPath("$.userPassword").value("password"));

        verify(userService, times(1)).updateUser(any(User.class));
    }

    @Test
    void deleteUserById() throws Exception {
        when(userService.deleteUserById(1)).thenReturn("Deleted the User.");

        mockMvc.perform(delete("/deleteUser/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("Deleted the User."));

        verify(userService, times(1)).deleteUserById(1);
    }
}