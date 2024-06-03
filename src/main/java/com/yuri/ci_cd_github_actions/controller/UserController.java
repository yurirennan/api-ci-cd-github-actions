package com.yuri.ci_cd_github_actions.controller;

import com.yuri.ci_cd_github_actions.dto.UserDTO;
import com.yuri.ci_cd_github_actions.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(final UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<?> saveUser(@RequestBody final UserDTO userDTO) {
        this.userService.saveUser(userDTO);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
