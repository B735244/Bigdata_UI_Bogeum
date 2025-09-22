package com.example.demo.Restful.Naver;


import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@Slf4j
@RequestMapping("/th/naver")
public class NaverLoginController {


    private String Client_ID = "JpAxufwm7yy8tFcT2Rmz";
    private String Client_Secret = "kyqlYdOKZd";
    private String Redirect_URL = "http://localhost:8090/th/naver/getCode";
    private String code;
    private String state;
    private NaverTokenResponse naverTokenResponse;

    @GetMapping("/login")
    public String login(){
        log.info("GET /th/naver/login...");
        return "redirect:https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id="+Client_ID+"&state=STATE_STRING&redirect_uri="+Redirect_URL;

    }

    @GetMapping("/getCode")
    public String getCode(String code, String state){
        log.info("GET th/kakao/getCode...code : " + code+ " state:" +state);
        this.code=code;
        this.state=state;
        return "forward:/th/naver/getAccessToken";

    }

    @GetMapping("/getAccessToken")
    public String getAccessToken(){
        log.info("GET /th/naver/getAccessToken....");

        String url = "https://nid.naver.com/oauth2.0/token";

        RestTemplate restTemplate = new RestTemplate();

//        // 요청 헤더 설정
        HttpHeaders header = new HttpHeaders();
        //header.add("Content-Type","application/x-www-form-urlencoded;charset=utf-8");
//        // 요청 바디 파라미터
        MultiValueMap<String,String> params = new LinkedMultiValueMap<>();
        params.add("grant_type","authorization_code");
        params.add("client_id",Client_ID);
        params.add("client_secret",Client_Secret);
        params.add("code",code);
        params.add("state", state);
//
        HttpEntity< MultiValueMap<String,String>  > entity = new HttpEntity<>(params,header);

        // 요청 후 응답 확인
        ResponseEntity<NaverTokenResponse> response = restTemplate.exchange(url, HttpMethod.POST,entity, NaverTokenResponse.class);
        System.out.println(response.getBody());

        this.naverTokenResponse = response.getBody();


        //main으로 리다이렉트
        return "redirect:/th/naver";
    }


    //Main
    @GetMapping
    public String main(Model model){
        log.info("GET /th/naver/index...");

       String url = "https://openapi.naver.com/v1/nid/me";
//
        RestTemplate restTemplate = new RestTemplate();
//
        // 요청 헤더 설정
        HttpHeaders header = new HttpHeaders();
        header.add("Authorization","Bearer "+ naverTokenResponse.getAccess_token());

        // 요청 바디 파라미터(X)

        HttpEntity entity = new HttpEntity(header);
//
//        // 요청 후 응답 확인
        ResponseEntity<Root> response = restTemplate.exchange(url, HttpMethod.POST,entity, Root.class);
        System.out.println(response.getBody());
//
        // 뷰로 전달
        model.addAttribute("profile",response.getBody());
        Root root = response.getBody();
        assert root != null;
        String id = root.response.getId();
        String nickname = root.response.getNickname();
        String profile_iamge = root.response.getProfile_image();
        String email = root.response.getEmail();
        String name = root.response.getName();

        model.addAttribute("id",id);
        model.addAttribute("nickname", nickname);
        model.addAttribute("profile_image", profile_iamge);
        model.addAttribute("email", email);
        model.addAttribute("name", name);

//     
//
        return "th/naver/index";
    }

    @Data
    private static class NaverTokenResponse{
        public String access_token;
        public String refresh_token;
        public String token_type;
        public String expires_in;
    }



  @Data
    private static class Profile{
        public String id;
        public String nickname;
        public String profile_image;
        public String email;
        public String name;
    }
    @Data
    private static class Root{
        public String resultcode;
        public String message;
        public Profile response;
    }


}
