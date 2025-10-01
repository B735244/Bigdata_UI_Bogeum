package com.example.demo.Filter;


import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

//@WebFilter("/*")
@Slf4j
public class MemoFilter implements Filter{

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        //전
        log.info("[Filter] Global Filter Start...");
        chain.doFilter(request,response);
        //후
        log.info("[Filter] Global Filter end...");
    }
}
