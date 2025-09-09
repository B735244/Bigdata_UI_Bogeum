package com.example.demo.Domain.Common.Repository;

import com.example.demo.Domain.Common.Entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class UserRepositoryTest {
    @Autowired UserRepository userRepository;
    @Test
    public void t1()throws Exception{
//        List<User> list4= userRepository.selectAllByRole("Manager");
//list4.forEach(System.out::println);
//
//List<User> list = userRepository.selectAllByRoleAndPwd("Cat","1234");
//        list.forEach(System.out::println);

        List<User> list2 = userRepository.selectAllByRole_2("Manager");
        list2.forEach(System.out::println);
        List<User> list = userRepository.selectAllLikeUsername(("박"));
        list.forEach(System.out::println);
    }

}