package com.example.demo.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
public class TxConfig {

    @Autowired
    private DataSource dataSource;

//jpaTransactionManager라는 Bean 등록
    //EntityManagerFactory는 EntityManager를 만들어내는 팩토리 입니다.
    //여기서 EntityManager는 실제 DB와 통신하는 객체입니다.
    //transactionManager라는 이름의 JpaTransactionManger객체를 생성해서 트랜잭션을 관리할 수 있도록 합니다.
    //transactionManager에 아까 인자로 받은 entityMangerFactory를 연결해주어야 DB작업을 트랜잭션 단위로 관리할 수 있습니다.
    //어떤 DB를 사용할건지 정보를 넘겨주고(dataSource)
    //마지막으로 transactionManager를 반환해줍니다.
        @Bean(name="jpaTransactionManager")
            public JpaTransactionManager jpaTransactionManager(EntityManagerFactory entityManagerFactory) {
                JpaTransactionManager transactionManager = new JpaTransactionManager();
                transactionManager.setEntityManagerFactory(entityManagerFactory);
                transactionManager.setDataSource(dataSource);
                return transactionManager;


    }

}

