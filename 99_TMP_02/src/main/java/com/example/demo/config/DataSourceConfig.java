package com.example.demo.config;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

// 이름이 DataSource인 Bean을 등록해줍니다.
    //DataSource는 DB와 연결할 수 있는 통로임.(Connection Pool)
    //DB 연결을 위해 연결할 DB주소롸 접속 계정 정보를 입력해줍니다.
    @Bean
    public HikariDataSource dataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/testdb");
        dataSource.setUsername("root");
        dataSource.setPassword("1234");

        return dataSource;

    }

}
