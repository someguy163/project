package com.example.fitstproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
/*컨트롤러를 사용하려면 @Controller를 import해줘야한다.*/
public class FirstController {


    @GetMapping("/hi") // 접속할 주소를 입력해야한다.
//    GetMapping은 어노테이션이라고 한다.
//    localhost8080/hi를 입력하면 된다.
    public String niceToMeetYou(Model model){
        model.addAttribute("username","박주형");
//        greetings.mustache파일에서 {{username}}변수를 선언했다. 변수에다 값을 넣기 위해서는
//        컨트롤러에 Model model을 입력하고 modle.addAttribute를 사용해서 값을 넣어준다.
        return "greetings"; // templates/greetings.mustache -> 브라우저로 전송해준다.

    }
    @GetMapping("/bye")
    public String seeTouNext(Model model){
        model.addAttribute("nickname","홍길동");
        return "goodbye";

    }

}
