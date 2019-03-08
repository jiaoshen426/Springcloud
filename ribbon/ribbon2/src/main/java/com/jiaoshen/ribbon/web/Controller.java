package com.jiaoshen.ribbon.web;

import com.jiaoshen.ribbon.bean.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jiaoshen
 * @date 2019/1/31-${time}
 */
@RestController
public class Controller {
     @GetMapping(value="/person")
      public  String getperson(){
         Person p1 = new Person("23",12,"jiaoshen");
         return  p1.toString();
     }

}
