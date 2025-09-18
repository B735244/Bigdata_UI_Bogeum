package com.example.demo.Controller.RestController;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
@RequestMapping("/rest2")
public class RestTest1Controller {

    @GetMapping("/test1")
    @ResponseBody // ResponseBody를 넣어주면 page를 찾는게 아니라 Body를 읽어서 하단에 있는 함수가 출력된다. -> web에 Hello world!!! 출력됨.
    public String t1(){
        log.info("GET /rest2/test1");
        return "Hello World!!!"; // 이렇게하면 rest2안에 test1이라는 페이지를 찾기 때문에 오류가 뜬다. (동기 처리)
    }
}
