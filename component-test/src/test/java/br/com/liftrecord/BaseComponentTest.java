//package br.com.liftrecord;
//
//import br.com.liftrecord.utils.MigrationPathUtil;
//import io.restassured.RestAssured;
//import jakarta.inject.Inject;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.stream.Stream;
//import javax.sql.DataSource;
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.testcontainers.containers.PostgreSQLContainer;
//import org.testcontainers.utility.MountableFile;
//
//@SpringBootTest
//public abstract class BaseComponentTest implements TestPropertyProvider {
//
//  static private final PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:14-alpine");
//
//  @Value("${micronaut.server.port}")
//  private int port;
//
//  @Inject
//  private DataSource dataSource;
//
//  static {
//    prepareDatabase();
//  }
//
//  @BeforeEach
//  void setUp() {
//    RestAssured.port = port;
//  }
//
//  @AfterEach
//  void tearDown() throws SQLException {
//    truncateTables();
//    RestAssured.reset();
//  }
//
//  @AfterAll
//  static void stopContainer() {
//    postgres.stop();
//  }
//
//  @Override
//  public java.util.Map<String, String> getProperties() {
//    postgres.start();
//    return java.util.Map.of(
//        "datasources.default.url", postgres.getJdbcUrl(),
//        "datasources.default.username", postgres.getUsername(),
//        "datasources.default.password", postgres.getPassword()
//    );
//  }
//
//  private static void prepareDatabase() {
//    try (Stream<Path> paths = Files.walk(Paths.get(MigrationPathUtil.getMigrationPath()))) {
//      paths
//          .filter(Files::isRegularFile)
//          .filter(path -> path.toString().endsWith(".sql"))
//          .forEach(path -> {
//            String fileName = path.getFileName().toString();
//            postgres.withCopyFileToContainer(
//                MountableFile.forHostPath(path.toString()),
//                "docker-entrypoint-initdb.d/" + fileName
//            );
//          });
//    } catch (IOException e) {
//      e.printStackTrace();
//    }
//  }
//
//  private void truncateTables() throws SQLException {
//    try (Connection connection = dataSource.getConnection();
//         Statement statement = connection.createStatement()) {
//      statement.executeUpdate("DO $$ " +
//          "DECLARE " +
//          "  r RECORD; " +
//          "BEGIN " +
//          "  FOR r IN (SELECT tablename FROM pg_tables WHERE schemaname = 'public') LOOP " +
//          "    EXECUTE 'TRUNCATE TABLE ' || quote_ident(r.tablename) || ' CASCADE'; " +
//          "  END LOOP; " +
//          "END $$;");
//    }
//  }
//}