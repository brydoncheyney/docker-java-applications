package spark;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static spark.Spark.get;
import static spark.Spark.internalServerError;

public class Application {
  public static void main(String[] args) {
    Properties properties = new Properties();
    try {
      properties.load(new FileInputStream("/opt/spark-service/spark-service.properties"));
    } catch (IOException e) {
      internalServerError((req, res) -> { return e.getMessage(); });
    }

    get("/", (req, res) -> String.format("Spark! [%s|%s]",
                                         properties.getProperty("foo"),
                                         properties.getProperty("secret")));
  }
}
