package com.example.demo.config.auth.provier;


import java.util.Map;


public interface OAuth2UserInfo {
    String getName();
    String getEmail(); // 접속 이메일 계정
    String getProvider(); // provider의 이름 kakao,naver,google
    String getProviderId();
    Map<String, Object> getAttributes(); //(중요) 계정 정보 반환
}

