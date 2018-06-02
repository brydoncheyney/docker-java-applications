package spark;

import static spark.Spark.get;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Application {

  private static Configuration configuration;
  private static Logger logger = LoggerFactory.getLogger(Application.class);

  public static void main(String[] args) {
    logger.debug("Initialising spark service...");
    configuration = Configuration.load();
    get("/", (req, res) -> String.format("Spark! [%s|%s]",
                                         configuration.getFoo(),
                                         configuration.getSecret()));
  }
}
