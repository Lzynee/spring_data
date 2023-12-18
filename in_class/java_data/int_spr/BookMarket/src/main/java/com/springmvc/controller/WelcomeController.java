package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WelcomeController {

    // 클라이언트의 요청 URL이 /home이면 WelcomeController의 welcome() 메서드에 매핑한다.
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String welcome(Model model) {  // 요청 처리 메서드
        // Model 타입 객체의 멤버 메서드를 이용하여 뷰에 전달할 정보를 담는다.
        model.addAttribute("greeting", "Welcome to BookMarket");
        model.addAttribute("strapline", "Welcome to Web Shopping Mall!");
        return "welcome";  // 클라이언트 요청 URL에 대해 처리된 결과를 사용자에게 보여 주는 뷰 => welcome.jsp
    }
}
