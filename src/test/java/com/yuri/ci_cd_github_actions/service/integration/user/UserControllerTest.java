package com.yuri.ci_cd_github_actions.service.integration.user;


import com.yuri.ci_cd_github_actions.dto.UserDTO;
import com.yuri.ci_cd_github_actions.service.integration.IntegrationTestInitializer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;

public class UserControllerTest extends IntegrationTestInitializer {

  @Autowired
  private TestRestTemplate testRestTemplate;

  @Test
  @Sql("/database/clear_database.sql")
  public void shouldBeAbleToCreateAnUser() {
    final String resourceLocation = "/api/users";

    final UserDTO userDTO = this.getUserDTO();

    final HttpEntity<UserDTO> httpEntity = new HttpEntity<>(userDTO);

    final ResponseEntity<Void> response = this.testRestTemplate
        .exchange(
            resourceLocation,
            HttpMethod.POST,
            httpEntity,
            Void.class
        );

    Assertions.assertEquals(response.getStatusCode(), HttpStatus.CREATED);
  }

  private UserDTO getUserDTO() {
    UserDTO userDTO = new UserDTO();

    userDTO.setName("Test Name");
    userDTO.setLastName("Test Lastname");

    return userDTO;
  }

}
