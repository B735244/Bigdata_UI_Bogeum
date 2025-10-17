package com.example.demo.config.auth.jwt;

public class JWTProperties {

    public static final int ACCESS_TOKEN_EXPIRATION_TIME=1000*20;  //30초  millisecond
    public static final int REFRESH_TOKEN_EXPIRATION_TIME=1000*60*10; // 5분
    public static final String ACCESS_TOKEN_COOKIE_NAME="access-token";
    public static final String REFRESH_TOKEN_COOKIE_NAME="refresh-token";


    //Access-Token만료 시간 != Access-Token Cookie 만료시간
    // -> RefreshToken을 따로 관리하는 경우
    public static final int ACCESS_TOKEN_COOKIE_EXPIRATION_TIME= ACCESS_TOKEN_EXPIRATION_TIME;
}
