package com.example.demo.config.auth.jwt;

import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Arrays;

@Slf4j
@Component
public class JWTAuthorizationFilter extends OncePerRequestFilter {

    @Autowired
    JWTTokenProvider jwtTokenProvider;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //access-token 쿠키 받기
        System.out.println("[JWTAuthorizationFilter] doFilterInternal ...");
        String token = null;
        token = Arrays.stream(request.getCookies())
                        .filter((cookie)->{return cookie.getName().equals(JWTProperties.ACCESS_TOKEN_COOKIE_NAME);})
                        .findFirst()
                        .map((cookie)->{return cookie.getValue();})
                        .orElse(null);

        System.out.println("Token: "+token);
        if(token!=null){
            //access-token 받기 후 -> Authentication 생성이후 SecurityContextHolder에 저장

            //1)access-token 만료되었는지 확인
            //1-1)access-token 만료시? refresh-token 만료 여부 확인
            try {
                if (jwtTokenProvider.validateToken(token)) {
                    //1-1)access-token 만료 안되었을 시? Authentication 생성
                    Authentication authentication = jwtTokenProvider.getAuthentication(token);
                    if(authentication!=null){
                        SecurityContextHolder.getContext().setAuthentication(authentication);
                    }

                }
            }catch(ExpiredJwtException e){
                //1-1)access-token 만료시? refresh-token 만료 여부 확인

                log.info("ExpiredJwtException...!!!"+e.getMessage());
            }catch(Exception e){
                //1-1)access-token 만료시? refresh-token 만료 여부 확인

            }
            }


        filterChain.doFilter(request,response);

        }

        
        //후
        
    }

