package com.solo.basic1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

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

  @GetMapping("/home/returnBoolean")
  @ResponseBody
  public boolean showBoolean() {
    return true;
  }

  @GetMapping("/home/returnDouble")
  @ResponseBody
  public Double showDouble() {
    return Math.PI;
  }

  @GetMapping("/home/returnIntList")
  @ResponseBody
  public List<Integer> showIntArray() {
    List<Integer> list = new ArrayList<>() {{
      add(10);
      add(20);
      add(30);
    }};

    return list;

    /* 위의 것과 같은 느낌.
    List<Integer> list = new ArrayList<>() {{
      list.add(10);
      list.add(20);
      list.add(30);
    }};
    */
  }

  @GetMapping("/home/returnMap")
  @ResponseBody
  public Map<String, Object> showReturnMap() {
    Map<String, Object> map = new LinkedHashMap<>(){{
      put("speed", 100);
      put("id", 1);
      put("name", "아반떼");
      put("relatedIds", new ArrayList<>(){{
      add(1);
      add(2);
      add(3);
      }});
    }};
    return map;
  }

//  class Car {
//    private final int speed;
//    private final int id;
//    private final String name;
//    private final List<Integer> relatedIds;
//
//    public Car(int speed, int id, String name, List<Integer> relatedIds) {
//      this.speed = speed;
//      this.id = id;
//      this.name = name;
//      this.relatedIds = relatedIds;
//    }
//  }

  @GetMapping("/home/returnCar")
  @ResponseBody
  public Car showReturnCar() {
    Car car = new Car(1, 100, "아반떼", new ArrayList<>() {{
      add(1);
      add(2);
      add(3);
    }});
    return car;
  }

  class Car {
    private final int id;
    private final int speed;
    private final String name;
    private final List<Integer> relatedIds;

    public Car(int id, int speed, String name, List<Integer> relatedIds) {
      this.id = id;
      this.speed = speed;
      this.name = name;
      this.relatedIds = relatedIds;
    }

    public int getId() {
      return id;
    }

    public int getSpeed() {
      return speed;
    }

    public String getName() {
      return name;
    }

    public List<Integer> getRelatedIds() {
      return relatedIds;
    }
  }

  @GetMapping("/home/returnCar2")
  @ResponseBody
  public CarV2 showReturnCar2() {
    CarV2 car = new CarV2(1, 100, "아반떼", new ArrayList<>() {{
      add(1);
      add(2);
      add(3);
    }});

    car.setName(car.getName() + "V2");

    return car;
  }

  @GetMapping("/home/returnCarMapList")
  @ResponseBody
  public List<Map<String, Object>> showReturnCarMapList() {
    Map<String, Object> carMap1 = new LinkedHashMap<>() {{
      put("id",1);
      put("speed", 100);
      put("name", "아반떼");
      put("relatedIds", new ArrayList<>() {{
        add(2);
        add(3);
        add(4);
      }});
    }};

    Map<String, Object> carMap2 = new LinkedHashMap<>() {{
      put("id", 2);
      put("speed", 200);
      put("name", "산타페");
      put("relatedIds", new ArrayList<>() {{
        add(5);
        add(6);
        add(7);
      }});
    }};

    List<Map<String, Object>> list = new ArrayList<>();

    list.add(carMap1);
    list.add(carMap2);

    return list;
  }


  @GetMapping("/home/returnCarList")
  @ResponseBody
  public List<CarV2> showReturnCarList() {
    CarV2 car1 = new CarV2(1, 100, "아반떼", new ArrayList<>() {{
      add(2);
      add(3);
      add(4);
    }});

    CarV2 car2 = new CarV2(2, 200, "산타페", new ArrayList<>() {{
      add(5);
      add(6);
      add(7);
    }});

    List<CarV2> list = new ArrayList<>();

    list.add(car1);
    list.add(car2);

    return list;
  }


  @AllArgsConstructor
  @Getter
  class CarV2 {

    private final int id;
    private final int speed;
    @Setter
    private String name;
    private final List<Integer> relatedIds;

    public int getId() {
      return id;
    }

    public int getSpeed() {
      return speed;
    }

    public List<Integer> getRelatedIds() {
      return relatedIds;
    }

    public String getName() {
      return name;
    }

  }




}
