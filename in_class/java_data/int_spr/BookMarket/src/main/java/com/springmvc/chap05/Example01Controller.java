package com.springmvc.chap05;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Example01Controller {

    @RequestMapping(value = "/exam01", method = RequestMethod.GET)
    public void reqestMethod() {
        System.out.println("@Controller 예제입니다");
    }
}
