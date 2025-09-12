package com.example.demo.Domain.Common.Dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MemoDaoTest {
    @Autowired
    private MemoDao memoDao;

    @Test
    public void t1() throws Exception{
     //   memoDao.insert(new MemoDto(10L,"내용","user@naver.com", LocalDateTime.now(),null));
    }

}