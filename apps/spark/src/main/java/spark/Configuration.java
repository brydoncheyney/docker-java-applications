package spark;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Configuration {

  private String foo;
  private String secret;

  public String getFoo() {
    return foo;
  }

  public void setFoo(String foo) {
    this.foo = foo;
  }

  public String getSecret() {
    return secret;
  }

  public void setSecret(String secret) {
    this.secret = secret;
  }

  private static final String PROPERTIES = "/opt/spark-service/spark-service.properties";
  private static Logger logger = LogManager.getLogger(Configuration.class);

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
