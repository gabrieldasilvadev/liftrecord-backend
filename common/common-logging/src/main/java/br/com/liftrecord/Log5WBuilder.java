package br.com.liftrecord;

import java.util.LinkedHashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.springframework.util.Assert;

public class Log5WBuilder {
  public static class beLogging {

    private Map<String, String> params = new LinkedHashMap<>();

    public beLogging(String method,
                     String whatHappen,
                     Map<String, String> infos) {

      params.put("method", method);
      params.put("whatHappen", whatHappen);

      params.putAll(infos);
    }

    public beLogging addInfo(String key, String info) {
      Assert.hasText(key, "key must not be null");
      Assert.hasText(info, "info must not be null");
      Assert.isNull(params.get(key), "key already exists");

      params.put(key, info);
      return this;
    }

    public String debug(@NotNull Logger logger) {
      String json = JsonHelper.json(this.params);
      logger.debug(json);

      return json;
    }

    public String info(@NotNull Logger logger) {
      String json = JsonHelper.json(this.params);
      logger.info(json);

      return json;
    }

    public String error(@NotNull Logger logger) {
      String json = JsonHelper.json(this.params);
      logger.error(json);
      return json;
    }

    public String error(@NotNull Logger logger, @NotNull Exception exception) {
      String json = JsonHelper.json(this.params);
      logger.error(json, exception);

      return json;
    }

    public String message() {
      return JsonHelper.json(this.params);
    }
  }

  public static class WhatHappen {

    private String method;
    private String whatHappen;
    private Map<String, String> infos = new LinkedHashMap<>();

    public WhatHappen(String method, String whatHappen) {
      this.method = method;
      this.whatHappen = whatHappen;
    }

    public beLogging addInfo(String key, String info) {
      Assert.hasText(key, "key must not be null");
      Assert.hasText(info, "info must not be null");
      Assert.isNull(infos.get(key), "key already exists");

      infos.put(key, info);
      return new beLogging(method, whatHappen, infos);
    }
  }

  public static class Method {

    private String method;

    public Method(String method) {
      Assert.hasText(method, "method must not be blank");
      this.method = method;
    }

    public WhatHappen whatHappen(String whatHappen) {
      Assert.hasText(whatHappen, "whatHappen must not be blank");
      return new WhatHappen(method, whatHappen);
    }
  }

  public static Method method(String method) {
    return new Method(method);
  }

  public static Method method() {
    StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
    return new Method(stackTrace[2].getMethodName());
  }
}
