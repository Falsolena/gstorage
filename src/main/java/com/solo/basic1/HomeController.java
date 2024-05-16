package com.solo.basic1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
  private int count;

  public HomeController() {
    count = -1;
  }
  @GetMapping("/home/main")
  @ResponseBody
  public String showHome() {
    return "안녕하세요";
  }

  @GetMapping("/home/main2")
  @ResponseBody
  public String showHome2() {
    return "환영합니다";
  }

  @GetMapping("/home/main3")
  @ResponseBody
  public String showHome3() {
    return "스프링부트 획기적이다";
  }

  @GetMapping("/home/increase")
  @ResponseBody
  public int showIncrease() {

    count++;
    return count;
  }

}