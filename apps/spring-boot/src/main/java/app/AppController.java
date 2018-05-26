package app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class AppController {

  @Value("${foo}")
  private String foo;

  @Value("${secret}")
  private String secret;

  @RequestMapping("/")
  public String index() {
    return String.format("Application [%s|%s] FTW!", foo, secret);
  }

}
