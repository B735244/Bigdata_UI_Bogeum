package com.example.demo.config.auth.provier;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;

@Slf4j
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class KakaoUserInfo implements OAuth2UserInfo{
    //카카오 전용 속성
    private Long id;
    private LocalDateTime connected_at;
    private Map<String, Object> properties;
    private Map<String, Object> kakao_account;


    // 공동화 된 속성을 뽑아올거임(kakao, naver, google/)
    //==============================================
    @Override
    public String getName() {
        return (String) properties.get("nickname");
    }

    @Override
    public String getEmail() {
        return (String)kakao_account.get("email");
    }

    @Override
    public String getProvider() {
        return "Kakao";
    }

    @Override
    public String getProviderId() {
        return id!= null?id.toString():"0";
    }

    @Override
    public Map<String, Object> getAttributes() {
        return kakao_account;
    }
}
