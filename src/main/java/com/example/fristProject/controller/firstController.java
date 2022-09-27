package com.example.fristProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class firstController {

    @GetMapping("/hi")
    public String niceToMeetYou(Model model){
        model.addAttribute("username", "지윤");
        return "greetings"; // templates/greetings.mustache -> 브라우저로 전송
    }

    @GetMapping("/bye")
    public String seeYouNext(Model model){
        model.addAttribute("username", "지윤");
        return "goodbye"; // templates/greetings.mustache -> 브라우저로 전송
    }
}
