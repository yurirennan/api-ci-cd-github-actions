package com.yuri.ci_cd_github_actions.service;

import com.yuri.ci_cd_github_actions.dto.UserDTO;
import com.yuri.ci_cd_github_actions.model.User;
import com.yuri.ci_cd_github_actions.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(final UserDTO userDTO) {
        final User user = userDTO.toUser();

        this.userRepository.save(user);
    }

}
