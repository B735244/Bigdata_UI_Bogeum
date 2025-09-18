package com.example.demo.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/th")
public class ThymeleafController {

//    @GetMapping("/test1")
//    public void t1(Model model){
//        log.info("GET /th/test1...");
//        model.addAttribute("name","SON");
//        //DTO 형
//        MemoDto dto = new MemoDto(1L,"Contents1","dig05252@gmail.com");
//        model.addAttribute("dto",dto);
//
//        //List형
//        List<MemoDto> list = new ArrayList();
//        for(long i =1; i<=10; i++){
//            MemoDto tmp = new MemoDto(i,"text"+i,"Writer"+i);
//            list.add(tmp);
//
//
//        }
//        model.addAttribute("list", list);
//        //True or False
//        model.addAttribute("isAuth","false");
//
//    }
}
