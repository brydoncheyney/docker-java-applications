package spark;

import static spark.Spark.get;

public class Application {

  private static Configuration configuration;

  public static void main(String[] args) {
    configuration = Configuration.load();
    get("/", (req, res) -> String.format("Spark! [%s|%s]",
                                         configuration.getFoo(),
                                         configuration.getSecret()));
  }
}
