package com.example.demo.Listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class CustomContextListener implements ApplicationListener <ContextRefreshedEvent>{

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("CustomContextListener's onApplicationEvent invoke!!!"+event);
    }
}
