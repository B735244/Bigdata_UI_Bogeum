package com.example.demo.Restful.Kakao;


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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@Controller
@RequestMapping("/th/Kakao")
@Slf4j
public class KakaoLoginController {
//Redirect URL : http://localhost:8090/th/Kakao/getCode

    String client_id="e5923ec597bc30b05ac13d8e57e0d18a"; //REST API키
    String redirect_uri="http://localhost:8090/th/Kakao/getCode";
   private String code;
   private KakaoTokenResponse kakaoTokenResponse;
   private String logout_redirect = "http://localhost:8090/th/Kakao";

    @GetMapping("/login")
    public String login(){ //redirect url 던져버릴것임
        log.info("GET /th/Kakao/login...");
    return "redirect:https://kauth.kakao.com/oauth/authorize?client_id="+client_id+"&redirect_uri="+redirect_uri+"&response_type=code";
    }


    @GetMapping("/getCode")

    public String getCode(String code){

        log.info("GET /th/Kakao/getCode.... : " + code);
        // console 출력값 : GET /th/Kakao/getCode.... : cBZeSCbzi1X_VCPFueAS9eKCgb8_t1vbQoInRqXXhvA_w3ji1FzimwAAAAQKFwHPAAABmWBrMmSBPKUF0hG4dQ
        this.code=code;
        return "forward:/th/Kakao/getAccessToken";

    }

    //2. 토큰 요청
    @GetMapping("/getAccessToken")
     // 비동기
    public String getAccessToken(String code) {
        log.info("GET /th/Kakao/getAccessToken...");
        String url = "https://kauth.kakao.com/oauth/token";

        RestTemplate restTemplate = new RestTemplate();

        //2. 요청 헤더 설정
        // Content-Type: application/x-www-form-urlencoded;charset=utf-8
        HttpHeaders header = new HttpHeaders();
        header.add("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

        //3. 요청 바디 파라미터 설정
        //
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "authorization_code");
        params.add("client_id", client_id);
        params.add("redirect_uri", redirect_uri);
        params.add("code", code);

        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(params, header);
        //4. 요청
        //URL,요청Method,entity,반환값 받아낼 자료형
        ResponseEntity<KakaoTokenResponse> response = restTemplate.exchange(url, HttpMethod.POST, entity, KakaoTokenResponse.class);

        System.out.println(response.getBody());
        this.kakaoTokenResponse = response.getBody();
        //출력값 확인
        // {"access_token":"h8UfcAJQKIwzQL5bVT9MUW7YXvsLzlWvAAAAAQoXEpYAAAGZYJ0ufNIOHznOlwLN",
        // "token_type":"bearer",
        // "refresh_token":"R1Sa6NO09PHhMc7ROXTO9d5wLPxsIZz0AAAAAgoXEpYAAAGZYJ0ud9IOHznOlwLN","expires_in":21599,
        // "scope":"account_email profile_image profile_nickname","refresh_token_expires_in":5183999}
        // json -> java로 응답받은  값들을 class로 받아줍니다.


        //main으로 리다이렉트
        return "redirect:/th/Kakao";



    }
    //5. main으로 redirect 하기
    @GetMapping
    public String main(Model model){
        log.info("GET /th/Kakao/index...");

        // 사용자 정보 요청
        String url = "https://kapi.kakao.com/v2/user/me";

        RestTemplate restTemplate = new RestTemplate();

        //2. 요청 헤더 설정
        // Content-Type: application/x-www-form-urlencoded;charset=utf-88
        // Authorization : Bearer ${ACCESS_TOKEN} 공백 반드시 체크할것
        HttpHeaders header = new HttpHeaders();
        header.add("Authorization", "Bearer "+kakaoTokenResponse.getAccess_token());
        header.add("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
        //3. 요청 바디 파라미터 설정

        //여기는 파라미터가 없고 헤더만 있기 때문에 이렇게 설정해야 함.
        HttpEntity entity = new HttpEntity(header);
        //4. 요청
        //URL,요청Method,entity,반환값 받아낼 자료형
        ResponseEntity<KakaoProfileResponse> response = restTemplate.exchange(url, HttpMethod.POST, entity, KakaoProfileResponse.class);

        System.out.println(response.getBody());

        //뷰(index.html)로 전달하겠음
        String nickname =response.getBody().getProperties().getNickname();
        String thumbnail = response.getBody().getProperties().getThumbnail_image();
        String email = response.getBody().getKakao_account().getEmail();

        model.addAttribute("nickname",nickname);
        model.addAttribute("thumbnail",thumbnail);
        model.addAttribute("email",email);

        return "th/Kakao/index";
    }


    //로그아웃-1 (액세스 토큰만 만료 시키는 로그아웃)
    @GetMapping("/logout1")
    @ResponseBody
    public void logout1(){
        log.info("GET /th/Kakao/logout1");
        String url = "https://kapi.kakao.com/v1/user/logout";

        RestTemplate restTemplate = new RestTemplate();

        //2. 요청 헤더 설정
        //사용자 인증 수단, 액세스 토큰 값
        //Authorization: Bearer ${ACCESS_TOKEN} 공백 반드시 체크할 것

        HttpHeaders header = new HttpHeaders();
        header.add("Authorization", "Bearer "+kakaoTokenResponse.getAccess_token());

        //3. 요청 바디 파라미터 설정

        //여기는 파라미터가 없고 헤더만 있기 때문에 이렇게 설정해야 함.
        HttpEntity entity = new HttpEntity(header);
        //4. 요청
        //URL,요청Method,entity,반환값 받아낼 자료형
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);

        System.out.println(response.getBody());

    }

    //로그아웃-2 : 연결해제(액세스 토큰 만료/ 리프레시 토큰 만료/ 동의 철회)
    @GetMapping("/logout2")
    @ResponseBody
    public void logout2(){
        log.info("GET /th/Kakao/logout2");
        String url = "https://kapi.kakao.com/v1/user/unlink";

        RestTemplate restTemplate = new RestTemplate();

        //2. 요청 헤더 설정
        //사용자 인증 수단, 액세스 토큰 값
        //Authorization: Bearer ${ACCESS_TOKEN} 공백 반드시 체크할 것

        HttpHeaders header = new HttpHeaders();
        header.add("Authorization", "Bearer "+kakaoTokenResponse.getAccess_token());

        //3. 요청 바디 파라미터 설정

        //여기는 파라미터가 없고 헤더만 있기 때문에 이렇게 설정해야 함.
        HttpEntity entity = new HttpEntity(header);
        //4. 요청
        //URL,요청Method,entity,반환값 받아낼 자료형
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);

        System.out.println(response.getBody());
    }

    //로그아웃-3 : 카카오계정과 함께 로그아웃
    @GetMapping("/logout3")

    public String logout3()throws Exception{
        log.info("GET /th/Kakao/logout3");

//        String url = "https://kauth.kakao.com/oauth/logout";
//
//        RestTemplate restTemplate = new RestTemplate();
//
//        //2. 요청 헤더 설정
//        //사용자 인증 수단, 액세스 토큰 값
//        //Authorization: Bearer ${ACCESS_TOKEN} 공백 반드시 체크할 것
//
//        HttpHeaders header = new HttpHeaders();
//        header.add("Authorization", "Bearer "+kakaoTokenResponse.getAccess_token());
//
//        //3. 요청 바디 파라미터 설정
//        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
//        params.add("client_id", client_id);
//        params.add("logout_redirect_uri",logout_redirect);
//
//
//
//
//        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity(header,params);
//        //4. 요청
//        //URL,요청Method,entity,반환값 받아낼 자료형
//        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
//
//        System.out.println(response.getBody());
       return "redirect:https://kauth.kakao.com/oauth/logout?client_id="+client_id+"&logout_redirect_uri="+logout_redirect;


    }



   //-----응답받은 토큰 정보-----------
    @Data
    private static class KakaoTokenResponse{
        public String access_token;
        public String token_type;
        public String refresh_token;
        public int expires_in;
        public String scope;
        public int refresh_token_expires_in;
    }

    //----- 응답받은 사용자의 정보.java-------
    @Data
    private static class KakaoAccount{
        public boolean profile_nickname_needs_agreement;
        public boolean profile_image_needs_agreement;
        public Profile profile;
        public boolean has_email;
        public boolean email_needs_agreement;
        public boolean is_email_valid;
        public boolean is_email_verified;
        public String email;
    }
    @Data
    private static class Profile{
        public String nickname;
        public String thumbnail_image_url;
        public String profile_image_url;
        public boolean is_default_image;
        public boolean is_default_nickname;
    }
    @Data
    private static class Properties{
        public String nickname;
        public String profile_image;
        public String thumbnail_image;
    }
    @Data
    private static class KakaoProfileResponse{
        public long id;
        public Date connected_at;
        public Properties properties;
        public KakaoAccount kakao_account;
    }




}
