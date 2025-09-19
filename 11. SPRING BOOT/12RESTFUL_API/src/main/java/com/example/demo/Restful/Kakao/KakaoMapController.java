package com.example.demo.Restful.Kakao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("th/Kakao")
@Slf4j
@Controller
public class KakaoMapController {

    @GetMapping("/map")
    public void map(){
        log.info("GET /kakao/map...");
    }
}
