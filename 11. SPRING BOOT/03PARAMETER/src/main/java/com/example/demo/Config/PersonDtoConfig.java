package com.example.demo.Config;

import com.example.demo.Dto.PersonDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersonDtoConfig {
    @Bean
    public PersonDto person03(){
        return PersonDto.builder()
            .name("손보동")
            .addr("진주")
            .age(17)
            .build();
    }
@Bean(name = "personBean")
    public PersonDto person04(){
        return PersonDto.builder()
                .name("손금동")
                .addr("진주")
                .age(18)
                .build();
    }
}


