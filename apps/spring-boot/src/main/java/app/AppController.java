package app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class AppController {

  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  @Value("${foo}")
  private String foo;

  @Value("${secret}")
  private String secret;

  @RequestMapping("/")
  public String index() {
    logger.info("Spring Boot! [{}|{}]", foo, secret);
    return String.format("Spring Boot! [%s|%s]", foo, secret);
  }

}
