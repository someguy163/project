package com.example.fitstproject.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController// RestAPI 컨트롤러 JSON을 반환
//REST컨트롤러와 컨트롤러 차이는 REST는 데이터를 반환한다.
//컨트롤러는 뷰페이지의 html코드를 보여준다.
public class fitstprojectController {

    @GetMapping("/api/hello")
    public String hello(){
        return "hell world";
    }

}
