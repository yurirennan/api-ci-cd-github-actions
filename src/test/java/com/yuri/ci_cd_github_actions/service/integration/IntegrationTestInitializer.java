package com.yuri.ci_cd_github_actions.service.integration;


import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@ActiveProfiles("test")
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class IntegrationTestInitializer {

  @Container
  @ServiceConnection
  static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>(
      "postgres:13"
  );

  /**
   * Como esta é apenas uma classe de configuração que servirá para ser estendida por outras classes
   * que realmente terão implementações de Testes, é necessário implementar um teste básico com
   * apenas um Assert.assertTrue(true) para que, durante a execução dos testes, o JUnit não retorne
   * o erro `{java.lang.Exception: No runnable methods}' para esta classe.
   */
  @Test
  public void simpleAssertIntegrationTestInitializer() {
    assertTrue(true);
  }

}
