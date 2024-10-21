package br.com.liftrecord.utils;

import java.nio.file.Path;
import java.nio.file.Paths;

public class MigrationPathUtil {
  static private final Path ROOT_PATH = Paths.get(System.getProperty("user.dir")).getParent();
  static private final Path DATAACCESS_MIGRATION_PATH = Paths.get("infrastructure", "database", "src", "main", "resources", "db", "migration");
  static private final String FINAL_MIGRATION_PATH = ROOT_PATH.resolve(DATAACCESS_MIGRATION_PATH).toString();

  public static String getMigrationPath() {
    return FINAL_MIGRATION_PATH;
  }
}