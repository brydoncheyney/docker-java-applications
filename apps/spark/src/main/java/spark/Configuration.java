package spark;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Configuration {

  private static final String PROPERTIES = "/opt/spark-service/spark-service.properties";
  private static Logger logger = LoggerFactory.getLogger(Configuration.class);

  private String foo;
  private String secret;

  public String getFoo() {
    logger.info("GET foo");
    return foo;
  }

  public void setFoo(String foo) {
    logger.info("Setting foo: {}", foo);
    this.foo = foo;
  }

  public String getSecret() {
    logger.info("GET secret");
    return secret;
  }

  public void setSecret(String secret) {
    logger.info("Setting secret");
    this.secret = secret;
  }

  private static void loadFromProperties(Configuration config) {
    Properties properties = new Properties();
    try {
      properties.load(new FileInputStream(PROPERTIES));
      config.setFoo(properties.getProperty("foo"));
      config.setSecret(properties.getProperty("secret"));
    } catch (IOException e) {
      logger.warn("Unable to read properties file '" + PROPERTIES + "'", e);
    }
  }

  public static Configuration load() {
    Configuration config = new Configuration();
    loadFromProperties(config);
    return config;
  }

}
