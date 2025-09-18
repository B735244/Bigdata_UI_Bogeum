package com.example.demo.Controller.RestController;

import com.example.demo.Dto.MemoDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/rest")
public class RestTest2Controller {

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

    //XMLList로 저장해서 출력해보자
    @GetMapping(value ="/getXMLList",produces = MediaType.APPLICATION_XML_VALUE)//응답의 헤더에 마인타입??
    public List<MemoDto> t4(){

        log.info("GET /rest/getXMLList...");
        List<MemoDto> list = new ArrayList();
        for(long i=0; i<100; i++) {
           MemoDto tmp = new MemoDto(i, "text" + i, "writer" + i, LocalDateTime.now());
            list.add(tmp);
        }
        return list;
    }


    @GetMapping(value ="/getXMLList2/{show}",produces = MediaType.APPLICATION_XML_VALUE)//응답의 헤더에 마인타입??
    public ResponseEntity <List<MemoDto>> t5(
            @PathVariable("show") boolean show
    ) {
        log.info("GET /rest/getXMLList2...show:" + show);
        List<MemoDto> list = new ArrayList();
        if (show) {
            for (long i = 0; i < 100; i++) {
                MemoDto tmp = new MemoDto(i, "text" + i, "writer" + i, LocalDateTime.now());
                list.add(tmp);
            }
            return new ResponseEntity(list, HttpStatus.OK);
        }
        return new ResponseEntity(null, HttpStatus.BAD_GATEWAY);
    }
}
