package com.example.demo.Controller.RestController;

import com.example.demo.Dto.MemoDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@Slf4j
@RequestMapping("/rest")
public class RestTestController {

    @GetMapping(value ="/getText",produces = MediaType.TEXT_PLAIN_VALUE)//응답의 헤더에 마인타입??
    public String t1(){
        log.info("GET /rest/getText...");
        return "Hello world!!!";
    }



// 자바에서 만들어 놓은 개체를 Json 타입으로 변환해주겠다.
    //근데 parsing하는 과정에서 제대로 된 의존도구가 없다면 문제가 생김.
    //parser를 연결해야 함.
    @GetMapping(value ="/getJson",produces = MediaType.APPLICATION_JSON_VALUE)//응답의 헤더에 마인타입??
    public MemoDto t2() {
        MemoDto dto = new MemoDto(3L, "text", "writer", LocalDateTime.now());
        log.info("GET /rest/getJson...");
        return dto;
    }

    //XML인데 parsing중에 오류가 뜰꺼임.

    @GetMapping(value ="/getXML",produces = MediaType.APPLICATION_XML_VALUE)//응답의 헤더에 마인타입??
    public MemoDto t3(){
        MemoDto dto = new MemoDto(4L,"text","writer", LocalDateTime.now());
        log.info("GET /rest/getXML...");
        return dto;
    }

}
