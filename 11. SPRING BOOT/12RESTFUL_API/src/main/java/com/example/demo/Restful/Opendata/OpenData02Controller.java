package com.example.demo.Restful.Opendata;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

//초단기 예보 조회
// 페이지 찾지 않겟음.
@RestController
//페이지 찾겠음.
//@Controller
@Slf4j
@RequestMapping("/Weather")
public class OpenData02Controller {
    private String server = "https://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtNcst";
    private String servicekey = "8bceb13caa7cc1b37b809ce6a03a1143468d5dd10dad0e97bf8f15965304c8b4";
    private String pageNo;
    private String numOfRows;
    private String dataType;
    private String base_date;
    private String base_time;
    private String nx;
    private String ny;

    //@GetMapping("/index1")
    @GetMapping(value = "/{pageNo}/{numOfRows}/{dataType}/{base_date}/{base_time}/{nx}/{ny}")
    public void get(
            @PathVariable(value = "pageNo", required = true) String pageNo,
            @PathVariable(value = "numOfRows", required = true) String numOfRows,
            @PathVariable(value = "dataType", required = true) String dataType,
            @PathVariable(value = "base_date", required = true) String base_date,
            @PathVariable(value = "base_time", required = true) String base_time,
            @PathVariable(value = "nx", required = true) String nx,
            @PathVariable(value = "ny", required = true) String ny,
            Model model
    ) {
        log.info("GET /Weather....pageNo:{} numOfRows:{} dataType: {} base_date:{} base_time:{} nx:{} ny:{}", pageNo, numOfRows, dataType, base_date
                , base_time, nx, ny);
        this.pageNo = pageNo;
        this.numOfRows = numOfRows;
        this.dataType = dataType;
        this.base_date = base_date;
        this.base_time = base_time;
        this.nx = nx;
        this.ny = ny;
        //1. 파라미터 설정(service key 포함)
        String url = UriComponentsBuilder.fromHttpUrl(server)
                .queryParam("serviceKey",servicekey)
                .queryParam("pageNo",pageNo)
                .queryParam("numOfRows",numOfRows)
                .queryParam("dataType",dataType)
                .queryParam("base_date",base_date)
                .queryParam("base_time",base_time)
                .queryParam("nx",nx)
                .queryParam("ny",ny)
                .toUriString();

        RestTemplate restTemplate = new RestTemplate();
//
//        //2. 요청 헤더 설정 -> 보통 공공데이터는 헤더, 바디 설정은 필요없음.
//        HttpHeaders header = new HttpHeaders();
//        header.add("key","value");
//
//        //3. 요청 바디 설정(x)
//        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
//        params.add("","");
//
//        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(params, header);
//        //4. 요청 후 응답 확인하기
//        //URL,요청Method,entity,반환값 받아낼 자료형
        ResponseEntity<Root> response= restTemplate.exchange(url, HttpMethod.GET,null,Root.class);
//REST TYPE -> Class Type 변환
        System.out.println(response.getBody());
//
//        //확인
        Root root = response.getBody();
        Response resp =root.getResponse();
        Body body = resp.getBody();
        Items items = body.getItems();
        List<Item> list = items.getItem();
        list.forEach(System.out::println);



//        model.addAttribute("list",list);
//        return "th/Opendata/index2";

    }


    // import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */
    @Data
    private static class Body{
        public String dataType;
        public Items items;
        public int pageNo;
        public int numOfRows;
        public int totalCount;
    }
    @Data
    private static class Header{
        public String resultCode;
        public String resultMsg;
    }
    @Data
    private static class Item{
        public String baseDate;
        public String baseTime;
        public String category;
        public int nx;
        public int ny;
        public String obsrValue;
    }
    @Data
    private static class Items{
        public ArrayList<Item> item;
    }
    @Data
    private static class Response{
        public Header header;
        public Body body;
    }
    @Data
    private static class Root{
        public Response response;
    }


}