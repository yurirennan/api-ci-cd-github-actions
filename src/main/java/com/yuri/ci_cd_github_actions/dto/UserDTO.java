package com.yuri.ci_cd_github_actions.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yuri.ci_cd_github_actions.model.User;
import lombok.Data;

@Data
public class UserDTO {

    private String name;
    @JsonProperty("last_name")
    private String lastName;

    public User toUser() {
        final User user = new User();

        user.setName(this.getName());
        user.setLastName(this.getLastName());

        return user;
    }

}
