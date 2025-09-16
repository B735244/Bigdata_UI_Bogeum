package com.example.demo.Controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/th")
public class HomeController {
    @GetMapping("/index")

    public String home(){
        System.out.println("GET /");
        log.info("GET /...");
        return "th/index";
    }
}
