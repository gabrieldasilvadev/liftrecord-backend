package br.com.liftrecord.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonReaderUtil {
  public static final String SRC_TEST_RESOURCES_STUBS = "src/test/resources/stubs/";

  public static String readJsonRequest(String path) {
    try {
      return new String(Files.readAllBytes(Paths.get(String.format(SRC_TEST_RESOURCES_STUBS + "requests/%s", path))));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public static String readJsonResponse(String path) {
    try {
      return new String(Files.readAllBytes(Paths.get(String.format(SRC_TEST_RESOURCES_STUBS + "responses/%s", path))));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}