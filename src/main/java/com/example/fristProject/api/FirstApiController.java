package com.example.fristProject.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // JSON 반환
// 일반 컨트롤러는 html 코드를 반환
public class FirstApiController {

    @GetMapping("/api/hello")
    public String hello(){
        return("hello world");
    }
}
