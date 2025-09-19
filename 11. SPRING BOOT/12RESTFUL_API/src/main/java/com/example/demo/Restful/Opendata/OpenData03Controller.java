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

//Bus노선
@RestController
//@Controller
@Slf4j
@RequestMapping("/Bus")
public class OpenData03Controller {
    private String server="https://apis.data.go.kr/6270000/dbmsapi02/getRealtime02";
private String servicekey ="8bceb13caa7cc1b37b809ce6a03a1143468d5dd10dad0e97bf8f15965304c8b4";
private String bsId;
private String routeNo;
//@GetMapping("/index1")
   @GetMapping(value = "/{bsId}/{routeNo}")
    public void get(
            @PathVariable(value = "bsId",required = true)String bsId,
            @PathVariable(value = "routeNo",required = true) String routeNo,
            Model model
    ) {
       log.info("GET /Bus....bsId:" + bsId + "routeNo:" + routeNo);
       this.bsId = bsId;
       this.routeNo = routeNo;
       //1. 파라미터 설정(service key 포함)
       String url = UriComponentsBuilder.fromHttpUrl(server)
               .queryParam("serviceKey", servicekey)
               .queryParam("pageNo", bsId)
               .queryParam("numOfRows", routeNo)

               .toUriString();

       RestTemplate restTemplate = new RestTemplate();

       //2. 요청 헤더 설정 -> 보통 공공데이터는 헤더, 바디 설정은 필요없음.
//        HttpHeaders header = new HttpHeaders();
//        header.add("key","value");
//
//        //3. 요청 바디 설정(x)
//        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
//        params.add("","");
//
//        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(params, header);
       //4. 요청 후 응답 확인하기
       //URL,요청Method,entity,반환값 받아낼 자료형
       ResponseEntity<Root> response = restTemplate.exchange(url, HttpMethod.GET, null, Root.class);
//REST TYPE -> Class Type 변환
       System.out.println(response.getBody());

       //확인
       Root root = response.getBody();
       Body body = root.getBody();
       ArrayList<Item> items =  body.getItems();
       items.forEach((item)->{
           System.out.println(item);
       });

   }
    @Data
    private static class ArrList{
        public String routeId;
        public String routeNo;
        public String moveDir;
        public int bsGap;
        public String bsNm;
        public String vhcNo2;
        public String busTCd2;
        public String busTCd3;
        public String busAreaCd;
        public String arrState;
        public int prevBsGap;
        public int arrTime;
    }
    @Data
    private static class Body{
        public ArrayList<Item> items;
        public int totalCount;
    }
    @Data
    private static class Header{
        public boolean success;
        public String resultCode;
        public String resultMsg;
    }
    @Data
    private static class Item{
        public String routeNo;
        public ArrayList<ArrList> arrList;
    }
    @Data
    private static class Root{
        public Header header;
        public Body body;
    }



}
