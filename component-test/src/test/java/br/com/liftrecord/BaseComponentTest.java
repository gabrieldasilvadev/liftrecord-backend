package br.com.liftrecord;

import br.com.liftrecord.utils.MigrationPathUtil;
import io.restassured.RestAssured;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.stream.Stream;
import javax.sql.DataSource;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
public abstract class BaseComponentTest {

  private final static Logger logger = LoggerFactory.getLogger(BaseComponentTest.class);


  @Container
  @ServiceConnection
  private final static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:14-alpine");


  @LocalServerPort
  private int port;

  @Autowired
  private DataSource dataSource;

  static {
    postgres.start();
    prepareDatabase();
  }

  @AfterAll
  static void stopContainer() {
    postgres.stop();
  }

  @BeforeEach
  void setUp() throws SQLException {
    logger.info("Server running on port: {}", port);
    RestAssured.port = port;
    truncateTables();
  }

  @AfterEach
  void tearDown() {
    RestAssured.reset();
  }

  @DynamicPropertySource
  static void setUpProperties(DynamicPropertyRegistry registry) {
    registry.add("spring.datasource.url", postgres::getJdbcUrl);
    registry.add("spring.datasource.username", postgres::getUsername);
    registry.add("spring.datasource.password", postgres::getPassword);
  }

  private static void prepareDatabase() {
    logger.info("Initializing population of database");
    try (Connection connection = DriverManager.getConnection(
        postgres.getJdbcUrl(), postgres.getUsername(), postgres.getPassword());
         Statement statement = connection.createStatement();
         Stream<Path> paths = Files.walk(Paths.get(MigrationPathUtil.getMigrationPath()))) {

      paths.filter(Files::isRegularFile)
          .filter(path -> path.toString().endsWith(".sql"))
          .forEach(path -> {
            try {
              String sql = new String(Files.readAllBytes(path));
              statement.execute(sql);
              logger.info("Performed migration: {}", path.getFileName().toString());
            } catch (IOException | SQLException e) {
              logger.error("Error executing migration: " + path.getFileName().toString(), e);
            }
          });
    } catch (IOException | SQLException e) {
      e.printStackTrace();
    }
  }


  private void truncateTables() throws SQLException {
    try (Connection connection = dataSource.getConnection();
         Statement statement = connection.createStatement()) {
      statement.executeUpdate("DO $$ " +
          "DECLARE " +
          "  r RECORD; " +
          "BEGIN " +
          "  FOR r IN (SELECT tablename FROM pg_tables WHERE schemaname = 'public') LOOP " +
          "    EXECUTE 'TRUNCATE TABLE ' || quote_ident(r.tablename) || ' CASCADE'; " +
          "  END LOOP; " +
          "END $$;");
    }
  }
}