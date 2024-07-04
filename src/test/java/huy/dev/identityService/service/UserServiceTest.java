package huy.dev.identityService.service;

import huy.dev.identityService.dto.request.UserCreationRequest;
import huy.dev.identityService.dto.response.UserResponse;
import huy.dev.identityService.entity.User;
import huy.dev.identityService.exception.AppException;
import huy.dev.identityService.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

@SpringBootTest
@TestPropertySource("/test.properties")
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    private UserCreationRequest request;
    private UserResponse userResponse;
    private User user;
    private LocalDate dob;

    @BeforeEach
    void initData() {
        dob = LocalDate.of(1998, 10, 9);

        request = UserCreationRequest.builder()
                .username("huy456")
                .firstName("John")
                .lastName("Credence")
                .password("huy123456")
                .dob(dob)
                .build();

        userResponse = UserResponse.builder()
                .id("7a17292dcdfb")
                .username("huy456")
                .firstName("John")
                .lastName("Credence")
                .dob(dob)
                .build();

        user = User.builder()
                .id("7a17292dcdfb")
                .username("huy456")
                .firstName("John")
                .lastName("Credence")
                .dob(dob)
                .build();
    }

    @Test
    void createUser_validRequest_success() {
        // GIVEN
        when(userRepository.existsByUsername(anyString())).thenReturn(false);
        when(userRepository.save(any())).thenReturn(user);

        // WHEN
        var response = userService.createUser(request);

        // THEN
        Assertions.assertThat(response.getId()).isEqualTo("7a17292dcdfb");
        Assertions.assertThat(response.getUsername()).isEqualTo("huy456");
    }

    @Test
    void createUser_userExisted_fail() {
        // GIVEN
        when(userRepository.existsByUsername(anyString())).thenReturn(true);

        // WHEN
        var exception = assertThrows(AppException.class, () -> userService.createUser(request));

        // THEN
        Assertions.assertThat(exception.getErrorCode().getCode()).isEqualTo(1001);
    }

}
