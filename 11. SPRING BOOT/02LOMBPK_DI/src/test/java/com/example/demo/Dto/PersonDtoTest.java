package com.example.demo.Dto;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PersonDtoTest {
    @Test
    public void t1() {
        PersonDto dto = new PersonDto("손보금",28,"진주");
        System.out.println(dto);
}
@Test
public void t2(){
PersonDto dto = PersonDto.builder()
        .age(20)
        .name("보동")
        .build();
System.out.println(dto);
}
}