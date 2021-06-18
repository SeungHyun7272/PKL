package com.web.pkl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

  @RequestMapping("/")
  public String home() {
    return "index.html";
  }

  @RequestMapping("/create")
  public String postCreate() {
    return "post/create.html";
  }
}
