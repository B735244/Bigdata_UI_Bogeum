package com.example.demo.domain.repository;

import com.example.demo.domain.entity.JwtToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JwtTokenRepository extends JpaRepository<JwtToken,Long> {
    //access-token 이용하여 token 정보 삭제
    void deleteByAccessToken(String accessToken);
    //access-token 이용하여 token 정보 가져오기
    JwtToken findByAccessToken(String accessToken);
    //username 이용하여 token 정보 가져오기
    JwtToken findByUsername(String username);
}
