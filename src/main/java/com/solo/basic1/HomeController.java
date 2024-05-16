package com.solo.basic1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
  @GetMapping("home/plus")
  @ResponseBody
  //requestParam의 의미
  // 개발자가 스프링부트에게 말한다.
  // int a는 쿼리스트링에서 a파라미터의 값을 얻은 후 정수화 한 값이어야 한다.
  // @RequestParam이라는 값이 생략되어있음
  public int showPlus(@RequestParam(defaultValue = "0") int a,@RequestParam(defaultValue = "0") int b) {
    return a + b;
  }

// home/plus?a=10&b=20
}
