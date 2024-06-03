package com.yuri.ci_cd_github_actions.service;

import com.yuri.ci_cd_github_actions.model.User;
import com.yuri.ci_cd_github_actions.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Test
    void saveUser() {
        User user = new User();
        user.setName("Name");
        user.setLastName("LastName");

        this.userRepository.save(user);

        verify(userRepository).save(user);
    }

}