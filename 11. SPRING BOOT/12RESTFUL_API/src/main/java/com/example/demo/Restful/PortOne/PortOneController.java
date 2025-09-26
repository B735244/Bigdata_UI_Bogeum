package com.example.demo.Restful.PortOne;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
@Slf4j
@RequestMapping("/th/portOne")
public class PortOneController {

    private String HOSTNAME = "https://api.iamport.kr";
    private String APIKEY = "7717341750465882";
    private String SECRET="vOKiaeg8Lt97LIik3gR3GIzPlbj5v9ls7Vjv7E7kJIH8dfNkJuUpXujkw5JLSaqnzbLCnX8WhbvlMMgm";
    private TokenResponse tokenResponse;

    @GetMapping("/index")
    public void index(){

        log.info("GET /th/portOne/index....");
    }

    //1 . AccessToken 발급
    @GetMapping("/getAccessToken")
    @ResponseBody
    public String getToken() throws JSONException {
        //1. 파라미터
        //2. Header
        //3. Body
        //4. Entity
        //5. Req->Resp


            String url = HOSTNAME + "/users/getToken";

            RestTemplate restTemplate = new RestTemplate();

            // 요청 헤더
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/json");


            // ✅ Map으로 요청 바디 생성
            JSONObject params = new JSONObject();
            params.put("imp_key", APIKEY);
            params.put("imp_secret", SECRET);

            HttpEntity<String> entity = new HttpEntity<>(params.toString(), headers);

            // 요청 후 응답 확인
            ResponseEntity<TokenResponse> response =
                    restTemplate.exchange(url, HttpMethod.POST, entity, TokenResponse.class);

            log.info("PortOne Token Response: {}", response.getBody());
            this.tokenResponse =response.getBody();

            return ""; // JSON 그대로 리턴

    }

    @GetMapping("/payments")
    @ResponseBody
    private void getPayments(){
        String url = HOSTNAME+"/payments?imp_uid[]=&merchant_uid[]=";
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type","application/json");
        headers.add("Authorization","Bearer " +tokenResponse.getItem().getAccess_token());

        HttpEntity entity = new HttpEntity(headers);

        RestTemplate rt= new RestTemplate();
        ResponseEntity<String> response = rt.exchange(url,HttpMethod.GET,entity,String.class);
        System.out.println(response.getBody());
    }

    @GetMapping("/pay/cancel")
    @ResponseBody
    public void pay_cancel() throws JSONException {
        log.info("POST th/portOne/pay/cancel...");

        String url = HOSTNAME+"/payments/cancel?imp_uid[]=&merchant_uid[]=";
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type","application/json");
        headers.add("Authorization","Bearer " +tokenResponse.getItem().getAccess_token());

        JSONObject params = new JSONObject();
        params.put("merchant_uid","");
        HttpEntity<String> entity = new HttpEntity(params.toString(),headers);

        RestTemplate rt= new RestTemplate();
        ResponseEntity<String> response = rt.exchange(url,HttpMethod.POST,entity,String.class);
        System.out.println(response.getBody());
    }

    @GetMapping("/certifications/{imp_uid}")
    @ResponseBody
    public ResponseEntity<String> certifications(@PathVariable("imp_uid")String imp_uid) throws JSONException {
        //AccessToken 발급
        getToken();

        log.info("GET /th/portOne/certifications...");
        String url = HOSTNAME + "/certifications/"+imp_uid;
        //요청 헤더 설정
        HttpHeaders header = new HttpHeaders();
        header.add("Authorization","Bearer "+this.tokenResponse.getItem().getAccess_token());
        header.add("Content-Type","application/json");

        HttpEntity entity = new HttpEntity<>(header);

        //요청 후 응답확인
        RestTemplate rt = new RestTemplate();
        ResponseEntity<String> response = rt.exchange(url, HttpMethod.GET,entity, String.class);

        System.out.println(response);

        return new ResponseEntity<>(response.getBody() , HttpStatus.OK);

    }


    @Data
    private static class Item{
        public String access_token;
        public int now;
        public int expired_at;
    }
    @Data
    private static class TokenResponse{
        public int code;
        public Object message;
        @JsonProperty("response")
        public Item item;
    }


}
